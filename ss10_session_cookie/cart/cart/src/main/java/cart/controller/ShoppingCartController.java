package cart.controller;

import cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false)CartDto cart){
        return new ModelAndView("cart/list", "cart", cart);
    }
}
