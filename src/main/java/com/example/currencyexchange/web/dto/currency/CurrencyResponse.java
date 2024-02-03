package com.example.currencyexchange.web.dto.currency;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrencyResponse {
    private Long id;
    private String code;
    private String fullName;
    private String sign;
}
