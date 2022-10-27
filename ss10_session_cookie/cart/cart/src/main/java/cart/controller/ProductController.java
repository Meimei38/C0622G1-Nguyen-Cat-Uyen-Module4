package cart.controller;

import cart.dto.CartDto;
import cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }
    @Autowired
    IProductService productService;

    @GetMapping("")
    public ModelAndView showListPage(){
        return new ModelAndView("product/list","productList", productService.findAll());
    }

}
