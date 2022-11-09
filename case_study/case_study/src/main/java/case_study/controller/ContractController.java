package case_study.controller;


import case_study.dto.contract.IContractPageDto;
import case_study.model.contract.AttachFacility;
import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.model.facility.Facility;
import case_study.service.contract.IAttachService;
import case_study.service.contract.IContractDetailService;
import case_study.service.contract.IContractService;
import case_study.service.customer.ICustomerService;
import case_study.service.employee.IEmployeeService;
import case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    IFacilityService facilityService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IAttachService attachService;


    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        Page<IContractPageDto> contractList = contractService.findContractExist(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contractList", contractList);
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("contractDetail", new ContractDetail());
        return modelAndView;
    }

    @ModelAttribute("facilityList")
    public List<Facility> getAllFacility() {
        return facilityService.findAllFacility();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @ModelAttribute("customerList")
    public List<Customer> getAllCustomer() {
        return customerService.findAllCustomer();
    }

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getAllAttachFacility() {
        return attachService.getAllAttachFacility();
    }


}
