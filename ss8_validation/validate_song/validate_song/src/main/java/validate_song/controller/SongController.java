package validate_song.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import validate_song.dto.SongDto;
import validate_song.model.Song;
import validate_song.service.ISongService;

import java.util.List;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("/create-song")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("songDto", new SongDto());
        return modelAndView;

    }
    @PostMapping("/validateSong")
    public ModelAndView checkValidation(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("/list");
            modelAndView.addObject("songs",songService.findAll());
            modelAndView.addObject("message","New song added!");
            return modelAndView;
        }
    }
    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Song>songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }
}
