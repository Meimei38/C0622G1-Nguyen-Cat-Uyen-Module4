package case_study.controller;

import case_study.model.facility.Facility;
import case_study.model.facility.FacilityType;
import case_study.model.facility.RentType;
import case_study.service.facility.IFacilityService;
import case_study.service.facility.IFacilityTypeService;
import case_study.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("facility", new Facility());
        return modelAndView;
    }

    @PostMapping("/create")
    public String addFacility(@ModelAttribute Facility facility, RedirectAttributes redirect) {
        facility.setIsPresent(1);
        facilityService.checkFacility(facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess", "New facility added!");
        return "redirect:/facility/create";
    }

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "") String searchFacilityType) {
        Page<Facility> facilities = facilityService.findFacilityExist(pageable, searchName, searchFacilityType);
        ModelAndView modelAndView = new ModelAndView("facility/list");
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("searchName", searchName);
        modelAndView.addObject("searchFacilityType", searchFacilityType);
        modelAndView.addObject("facility", new Facility());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(value = "id") Integer id) {
        Facility facility = facilityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("facility/edit");
        if (facility == null) {
            modelAndView.addObject("mess", "Facility Not Found!");
            return modelAndView;
        }
        modelAndView.addObject("facility", facility);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateFacility(@ModelAttribute Facility facility, RedirectAttributes redirect) {
        facility.setIsPresent(1);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess", "Facility updated!");
        return "redirect:/facility/list";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam(value = "id") Integer id, RedirectAttributes redirect) {
        Facility facility = facilityService.findById(id);
        facility.setIsPresent(0);
        facilityService.save(facility);
        if (facility == null) {
            redirect.addFlashAttribute("mess", "Facility Not Found!");
        } else {
            redirect.addFlashAttribute("mess", "Facility removed!");
        }
        return "redirect:/facility/list";
    }

    @ModelAttribute
    public List<FacilityType> showFacilityType() {
        return facilityTypeService.findAll();
    }

    @ModelAttribute
    public List<RentType> showRentType() {
        return rentTypeService.findAll();
    }

}
