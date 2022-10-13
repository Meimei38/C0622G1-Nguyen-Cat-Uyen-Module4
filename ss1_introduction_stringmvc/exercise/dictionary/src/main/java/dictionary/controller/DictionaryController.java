package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping
    public String showForm() {
        return "index";
    }

    @PostMapping
    public String checkUp(@RequestParam String englishWord, Model model) {
        String result;
        if (englishWord == "") {
            result = null;
        } else {
            result = dictionaryService.checkUp(englishWord);
        }
        model.addAttribute("result", result);
        return "index";

    }

}
