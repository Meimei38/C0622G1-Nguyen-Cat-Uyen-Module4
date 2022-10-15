package currency_converter.Service.impl;

import currency_converter.Service.ICurrencyConverterService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService implements ICurrencyConverterService {

    @Override
    public double getCurrency(double USDCurrency) {
        return USDCurrency * 23000;
    }
}
