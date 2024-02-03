package com.example.currencyexchange.service.impl;

import com.example.currencyexchange.domain.entity.Currency;
import com.example.currencyexchange.domain.exception.NotFoundException;
import com.example.currencyexchange.repository.CurrencyRepository;
import com.example.currencyexchange.service.CurrencyService;
import com.example.currencyexchange.web.dto.currency.CurrencyRequest;
import com.example.currencyexchange.web.dto.currency.CurrencyResponse;
import com.example.currencyexchange.web.mapper.CurrencyMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyRepository currencyRepository;
    private CurrencyMapper currencyMapper;

    @Override
    public CurrencyResponse getById(Long id) {
        Optional<Currency> currency = currencyRepository.findById(id);
        if(currency.isEmpty()) throw new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND);
        return currencyMapper.toDto(currency.get());
    }

    @Override
    public List<CurrencyResponse> getAll() {
        return currencyMapper.toDtos(currencyRepository.findAll());
    }

    @Override
    public void addCurrency(CurrencyRequest currencyRequest) {
        Currency currency = new Currency();
        currency.setCode(currencyRequest.getCode());
        currency.setSign(currencyRequest.getSign());
        currency.setFullName(currencyRequest.getFullName());
        currencyRepository.saveAndFlush(currency);
    }

    @Override
    public CurrencyResponse getByCode(String code) {
        Optional<Currency> currency = currencyRepository.findByCode(code);
        if(currency.isEmpty()) throw new NotFoundException("NOT_FOUND", HttpStatus.NOT_FOUND);
        return currencyMapper.toDto(currency.get());
    }


}
