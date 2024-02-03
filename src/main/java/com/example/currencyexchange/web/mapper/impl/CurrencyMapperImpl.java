package com.example.currencyexchange.web.mapper.impl;

import com.example.currencyexchange.domain.entity.Currency;
import com.example.currencyexchange.web.dto.currency.CurrencyResponse;
import com.example.currencyexchange.web.mapper.CurrencyMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyMapperImpl implements CurrencyMapper {
    @Override
    public CurrencyResponse toDto(Currency currency) {
        CurrencyResponse currencyResponse = new CurrencyResponse();
        currencyResponse.setId(currency.getId());
        currencyResponse.setCode(currency.getCode());
        currencyResponse.setSign(currency.getSign());
        currencyResponse.setFullName(currency.getFullName());
        return currencyResponse;
    }

    @Override
    public List<CurrencyResponse> toDtos(List<Currency> currencies) {
        return null;
    }
}
