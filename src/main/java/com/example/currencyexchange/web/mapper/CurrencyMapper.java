package com.example.currencyexchange.web.mapper;

import com.example.currencyexchange.domain.entity.Currency;
import com.example.currencyexchange.web.dto.currency.CurrencyResponse;

import java.util.List;

public interface CurrencyMapper {
    CurrencyResponse toDto(Currency currency);
    List<CurrencyResponse> toDtos(List<Currency> currencies);
}
