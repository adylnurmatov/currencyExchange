package com.example.currencyexchange.web.dto.rate;

import com.example.currencyexchange.domain.entity.Currency;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateResponse {
    private Long id;
    private Currency baseCurrency;
    private Currency targetCurrency;
    private Double rate;
}
