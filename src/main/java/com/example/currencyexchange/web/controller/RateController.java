package com.example.currencyexchange.web.controller;

import com.example.currencyexchange.domain.entity.ExchangeRate;
import com.example.currencyexchange.repository.RateRepository;
import com.example.currencyexchange.service.RateService;
import com.example.currencyexchange.web.dto.convertedValue.ConvertedCurrency;
import com.example.currencyexchange.web.dto.rate.RateRequest;
import com.example.currencyexchange.web.dto.rate.RateResponse;
import com.example.currencyexchange.web.mapper.RateMappper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
public class RateController {
    private RateService rateService;


    @GetMapping("/exchangeRates")
    public List<RateResponse> getAll(){
        return rateService.getALlRate();
    }


    @GetMapping("/exchangeRate/{codes}")
    public RateResponse getRate(@PathVariable String codes){
        String from = codes.substring(0, 3).toUpperCase();
        String to = codes.substring(3).toUpperCase();
        return rateService.getRate(from, to);
    }

    @PostMapping("/exchangeRates")
    public void addRate(@RequestBody RateRequest request){
        rateService.addRate(request);
    }

    @PatchMapping("/exchangeRate/{codes}")
    public void updateRate(@PathVariable String codes, @RequestParam Double rate){
        String from = codes.substring(0, 3).toUpperCase();
        String to = codes.substring(3).toUpperCase();
        rateService.updateRate(from, to, rate);
    }

    @GetMapping("/exchange")
    public ConvertedCurrency exchange(@RequestParam String from, String to, Integer amount){
        return rateService.exchange(from, to, amount);
    }
}
