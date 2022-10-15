package currency_converter.Controller;

import currency_converter.Service.ICurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.font.CreatedFontTracker;

@Controller
@RequestMapping("/exchange")
public class CurrencyConverterController {

    @Autowired
    private ICurrencyConverterService currencyConverterService;

    @GetMapping
    public String getCurrencyForm() {
        return "index";
    }

    @PostMapping
    public String getCurrency(@RequestParam String usdAmount, Model model) {

        if (usdAmount == "") {

            model.addAttribute("note", "Vui lòng nhập số tiền VND!");

        } else {
            model.addAttribute("usdAmount", usdAmount);
            model.addAttribute("result", currencyConverterService.getCurrency(Double.parseDouble(usdAmount)));
        }

        return "index";
    }


}
