package com.example.currencyexchange.web.mapper.impl;

import com.example.currencyexchange.domain.entity.ExchangeRate;
import com.example.currencyexchange.web.dto.rate.RateResponse;
import com.example.currencyexchange.web.mapper.RateMappper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RateMapperImpl implements RateMappper {
    @Override
    public RateResponse toDto(ExchangeRate rate) {
        RateResponse response = new RateResponse();
        response.setId(rate.getId());
        response.setRate(rate.getRate());
        response.setBaseCurrency(rate.getBaseCurrency());
        response.setTargetCurrency(rate.getTargetCurrency());
        return response;
    }


    public List<RateResponse> toDtos(List<ExchangeRate>rates){
        List<RateResponse> rateResponses = new ArrayList<>();
        for (ExchangeRate rate:rates) {
            rateResponses.add(toDto(rate));
        }
        return rateResponses;
    }
}
