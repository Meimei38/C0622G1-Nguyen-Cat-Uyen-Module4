package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class DictionaryController {
    IDictionaryService dictionaryService;
@GetMapping
    public String showForm(){
    return "index";
}
@PostMapping
    public String checkUp(@RequestParam String englishWord, Model model){
    model.addAttribute("result",dictionaryService.checkUp(englishWord));
    return "index";

}

}
