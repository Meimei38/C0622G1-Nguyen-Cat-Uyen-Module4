package case_study.controller;

import case_study.model.facility.Facility;
import case_study.model.facility.FacilityType;
import case_study.model.facility.RentType;
import case_study.service.facility.IFacilityService;
import case_study.service.facility.IFacilityTypeService;
import case_study.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("facility", new Facility());
        return modelAndView;
    }

    @PostMapping("/create")
    public String addFacility(@ModelAttribute Facility facility, RedirectAttributes redirect){
        facility.setIsPresent(1);
        facilityService.checkFacility(facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess","New facility added!");
        return "redirect:/facility/create";
    }
    @GetMapping("/list")
    public ModelAndView showList(){
        List<Facility> facilities = facilityService.findFacilityExist();
        ModelAndView modelAndView = new ModelAndView("facility/list", "facilities", facilities);
        modelAndView.addObject("facility", new Facility());
        return modelAndView;
    }

    @ModelAttribute
    public List<FacilityType> showFacilityType(){
        return facilityTypeService.findAll();
    }

    @ModelAttribute
    public List<RentType> showRentType(){
        return rentTypeService.findAll();
    }

}
