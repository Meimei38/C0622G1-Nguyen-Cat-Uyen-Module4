package blog.controller;

import blog.model.Blog;
import blog.service.IBlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ModelAndView list(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("notify",
                "Blog named: " + blog.getName() + " created!");

        return "redirect:/blog";

    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("notify","blog editted!");
        return "index";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id).orElse(null));
        return "/view";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String searchName, Model model){
        List<Blog> blogs = blogService.findByName(searchName);
        model.addAttribute("blogs", blogs);
        model.addAttribute("notify", "No result!");
        return "/index";
    }


}
