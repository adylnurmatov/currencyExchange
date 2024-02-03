package com.example.currencyexchange.web.controller;

import com.example.currencyexchange.service.CurrencyService;
import com.example.currencyexchange.web.dto.currency.CurrencyRequest;
import com.example.currencyexchange.web.dto.currency.CurrencyResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyController {
    private CurrencyService currencyService;

    @GetMapping("/currency/{code}")
    public CurrencyResponse getCurrency(@PathVariable String code){
        return currencyService.getByCode(code);
    }

    @GetMapping("/currencies")
    public List<CurrencyResponse> getCurrencies(){
        return currencyService.getAll();
    }


    @PostMapping("/currencies")
    public void addCurrency(@RequestBody CurrencyRequest currencyRequest){
        currencyService.addCurrency(currencyRequest);
    }

//    @GetMapping("/currency/{id}")
//    public CurrencyResponse getCurrencyById(@PathVariable Long id){
//        return currencyService.getById(id);
//    }




}
