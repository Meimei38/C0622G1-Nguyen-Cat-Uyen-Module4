package case_study.controller;

import case_study.model.customer.Customer;
import case_study.model.customer.CustomerType;
import case_study.service.customer.ICustomerService;
import case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        Page<Customer> customers = customerService.findAllCustomersExist(pageable);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerModal", new Customer());
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Customer> remove(@PathVariable(value = "id") Integer id) {
        Customer customer = customerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public String remove(@RequestParam(value = "id") Integer id, RedirectAttributes redirect) {
        Customer customer = customerService.findCustomerById(id);
        customer.setIsPresent(0);
        customerService.save(customer);
        redirect.addFlashAttribute("mess", "Customer removed!");
        return "redirect:/customer/list";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(value = "customerModal") Customer customer, RedirectAttributes redirect) {
        customer.setIsPresent(1);
        customerService.update(customer);
        redirect.addFlashAttribute("mess","Customer updated!");
        return "redirect:/customer/list";
    }

    @ModelAttribute("customerTypeList")
    public List<CustomerType> getAllCategories() {
        return customerTypeService.getCustomerTypes();
    }

    @GetMapping("/add")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create","customer",new Customer());
        return modelAndView;
    }
}
