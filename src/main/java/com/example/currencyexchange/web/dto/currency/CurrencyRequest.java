package com.example.currencyexchange.web.dto.currency;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrencyRequest {
    private String code;
    private String fullName;
    private String sign;
}
