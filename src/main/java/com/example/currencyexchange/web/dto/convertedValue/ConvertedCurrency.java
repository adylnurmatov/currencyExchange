package com.example.currencyexchange.web.dto.convertedValue;

import com.example.currencyexchange.domain.entity.Currency;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConvertedCurrency {
    private Currency baseCurrency;
    private Currency targetCurrency;
    private Double rate;
    private Integer amount;
    private Double convertedAmount;
}
