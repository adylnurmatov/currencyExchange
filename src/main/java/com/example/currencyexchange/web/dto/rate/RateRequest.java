package com.example.currencyexchange.web.dto.rate;

import com.example.currencyexchange.domain.entity.Currency;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateRequest {
    private String baseCurrency;
    private String targetCurrency;
    private Double rate;
}
