package br.com.lilianabrito.lobloc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lilianabrito.lobloc.service.ProfileService;
import br.com.lilianabrito.lobloc.vo.Profile;
import lombok.Getter;
import lombok.Setter;
 
@Controller
public class ProfileController {
	
    @Autowired
    private ProfileService service;
    
	@GetMapping("/searchprofiles")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/profile/searchprofiles");
        mv.addObject("profiles", service.findAll());
        mv.addObject("profile", new Profile());
        
        return mv;
    }
     
    @GetMapping("/editprofile/{id}")
    public ModelAndView edit(@PathVariable("id") Integer code) {
         
        ModelAndView mv = new ModelAndView("/profile/searchprofiles");
        mv.addObject("profiles", service.findAll());
        mv.addObject("profile", service.findOne(code));
        
        return mv;
    }
     
    @GetMapping("/deleteprofile/{id}")
    public ModelAndView delete(@PathVariable("id") Integer code) {
         
        service.delete(code);
         
        return findAll();
    }
 
    @PostMapping("/saveprofile")
    public ModelAndView save(@Valid Profile profile, BindingResult result) {
         
        if(result.hasErrors()) {
            //TODO: fazer algo quando der erro
        }
        
        service.save(profile);
         
        return findAll();
    }
     
}