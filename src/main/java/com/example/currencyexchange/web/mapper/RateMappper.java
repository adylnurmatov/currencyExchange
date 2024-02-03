package com.example.currencyexchange.web.mapper;

import com.example.currencyexchange.domain.entity.ExchangeRate;
import com.example.currencyexchange.web.dto.rate.RateResponse;

import java.util.List;
import java.util.Optional;

public interface RateMappper {
    RateResponse toDto(ExchangeRate rate);
    List<RateResponse> toDtos(List<ExchangeRate> rates);
}

