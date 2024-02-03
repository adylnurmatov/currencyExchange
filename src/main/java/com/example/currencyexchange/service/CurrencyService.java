package com.example.currencyexchange.service;

import com.example.currencyexchange.web.dto.currency.CurrencyRequest;
import com.example.currencyexchange.web.dto.currency.CurrencyResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {
    CurrencyResponse getById(Long id);

    List<CurrencyResponse> getAll();

    void addCurrency(CurrencyRequest currencyRequest);

    CurrencyResponse getByCode(String code);
}
