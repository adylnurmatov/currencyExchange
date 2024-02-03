package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.entity.ExchangeRate;
import com.example.currencyexchange.web.dto.convertedValue.ConvertedCurrency;
import com.example.currencyexchange.web.dto.rate.RateRequest;
import com.example.currencyexchange.web.dto.rate.RateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateService {
    List<RateResponse> getALlRate();

    RateResponse getRate(String from, String to);

    void addRate(RateRequest request);

    void updateRate(String from, String to, Double rate);

    ConvertedCurrency exchange(String from, String to, Integer amount);
}
