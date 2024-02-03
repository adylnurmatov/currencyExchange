package com.example.currencyexchange.service.impl;

import com.example.currencyexchange.domain.entity.Currency;
import com.example.currencyexchange.domain.entity.ExchangeRate;
import com.example.currencyexchange.domain.exception.NotFoundException;
import com.example.currencyexchange.repository.CurrencyRepository;
import com.example.currencyexchange.repository.RateRepository;
import com.example.currencyexchange.service.RateService;
import com.example.currencyexchange.web.dto.convertedValue.ConvertedCurrency;
import com.example.currencyexchange.web.dto.rate.RateRequest;
import com.example.currencyexchange.web.dto.rate.RateResponse;
import com.example.currencyexchange.web.mapper.RateMappper;
import com.example.currencyexchange.web.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RateServiceImpl implements RateService {

    private RateMappper rateMappper;
    private RateRepository rateRepository;
    private CurrencyRepository currencyRepository;
    @Override
    public List<RateResponse> getALlRate() {
        List<ExchangeRate> exchangeRates = rateRepository.findAll();
        return rateMappper.toDtos(exchangeRates);
    }

    @Override
    public RateResponse getRate(String from, String to) {
        Currency baseCurrency = currencyRepository.findByCode(from).orElseThrow(()-> new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND));
        Currency targetCurrency = currencyRepository.findByCode(to).orElseThrow(()-> new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND));
        Optional<ExchangeRate> rate = rateRepository.findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency);
        if(rate.isEmpty()){
            throw new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        return rateMappper.toDto(rate.get());
    }

    @Override
    public void addRate(RateRequest request) {
        ExchangeRate rate = new ExchangeRate();
        rate.setRate(request.getRate());
        rate.setBaseCurrency(currencyRepository.findByCode(request.getBaseCurrency()).get());
        rate.setTargetCurrency(currencyRepository.findByCode(request.getTargetCurrency()).get());
        rateRepository.saveAndFlush(rate);
    }

    @Override
    public void updateRate(String from, String to, Double rate) {
        Currency baseCurrency = currencyRepository.findByCode(from).orElseThrow(()-> new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND));
        Currency targetCurrency = currencyRepository.findByCode(to).orElseThrow(()-> new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND));
        Optional<ExchangeRate> exchangeRate = rateRepository.findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency);
        if(exchangeRate.isEmpty()){
            throw new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND);
        }
        exchangeRate.get().setRate(rate);
        rateRepository.saveAndFlush(exchangeRate.get());
    }

    @Override
    public ConvertedCurrency exchange(String from, String to, Integer amount) {
        Currency baseCurrency = currencyRepository.findByCode(from).orElseThrow(()-> new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND));
        Currency targetCurrency = currencyRepository.findByCode(to).orElseThrow(()-> new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND));
        Optional<ExchangeRate> exchangeRate = rateRepository.findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency);
        Double rate = exchangeRate.get().getRate();
        Double converted = Converter.convert(rate, amount);
        ConvertedCurrency convertedCurrency = new ConvertedCurrency();
        convertedCurrency.setBaseCurrency(baseCurrency);
        convertedCurrency.setTargetCurrency(targetCurrency);
        convertedCurrency.setRate(rate);
        convertedCurrency.setAmount(amount);
        convertedCurrency.setConvertedAmount(converted);
        return convertedCurrency;
    }
}
