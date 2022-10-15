package sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String showForm(){
        return "index";
    }


    @RequestMapping("/save")
    public String saveList(@RequestParam(required = false) String[] condiment, Model model){



        if(condiment==null){
            model.addAttribute("condiment", "No condiment chosen");
        }else {
            String listString = String.join(", ", condiment);
            model.addAttribute("condiment", listString);
        }
       return "index";
    }
}
