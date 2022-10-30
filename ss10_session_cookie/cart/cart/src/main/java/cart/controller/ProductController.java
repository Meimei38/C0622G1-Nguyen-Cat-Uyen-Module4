package cart.controller;

import cart.dto.CartDto;
import cart.dto.ProductDto;
import cart.model.Product;
import cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

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
    public ModelAndView showListPage(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct){
        if(idProduct !=-1){
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        return new ModelAndView("product/list","productList", productService.findAll());
    }
@GetMapping("/detail/{id}")
    public  ModelAndView showDetail(@PathVariable long id, HttpServletResponse response){
    Cookie cookie = new Cookie("idProduct", id+"");
    cookie.setMaxAge(24*60*60);
    cookie.setPath("/");
    response.addCookie(cookie);
    return new ModelAndView("product/detail","product",productService.findById(id).get());

}
@GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cart){
    Optional<Product> productOption = productService.findById(id);
    if(productOption.isPresent()){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOption.get(),productDto);
        cart.addProduct(productDto);
    }
    return "redirect:/cart";
}
@GetMapping("/decrease/{id}")
    public  String decreaseToCart(@PathVariable Long id, @SessionAttribute ("cart") CartDto cart){
    Optional<Product> productOption = productService.findById(id);
    if(productOption.isPresent()){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOption.get(),productDto);
        cart.decreaseProduct(productDto);
    }
    return "redirect:/cart";
}
@GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @SessionAttribute ("cart") CartDto cart){
        Optional<Product> productOption = productService.findById(id);
        if(productOption.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOption.get(), productDto);
            cart.remove(productDto);
        }
        return "redirect:/cart";
}
@GetMapping("/updateQuantity")
    public String updateQuantity(@RequestParam Long id, Integer quantity, @SessionAttribute("cart") CartDto cart){
        Optional<Product> productOption = productService.findById(id);
        if(productOption.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOption.get(),productDto);
            cart.updateQuantity(productDto, quantity);
        }
        return "redirect:/cart";
}
}
