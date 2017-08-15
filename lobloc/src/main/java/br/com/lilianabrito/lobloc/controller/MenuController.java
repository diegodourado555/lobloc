package br.com.lilianabrito.lobloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.lilianabrito.lobloc.service.MenuService;
import br.com.lilianabrito.lobloc.service.ProfileService;
import br.com.lilianabrito.lobloc.vo.Menu;
import br.com.lilianabrito.lobloc.vo.Profile;
 
@Controller
public class MenuController {
	
    @Autowired
    private MenuService service;
    @Autowired
    private ProfileService profileService;
    
	@GetMapping("/searchmenus")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/menu/searchmenus");
        mv.addObject("menus", service.findAll());
        mv.addObject("menu", new Menu());
        mv.addObject("profiles", profileService.findAll());
        
        return mv;
    }
     
    @GetMapping("/editmenu/{id}")
    public ModelAndView edit(@PathVariable("id") Integer code) {
         
        ModelAndView mv = new ModelAndView("/menu/searchmenus");
        mv.addObject("menus", service.findAll());
        mv.addObject("menu", service.findOne(code));
        mv.addObject("profiles", profileService.findAll());
        
        return mv;
    }
     
    @GetMapping("/deletemenu/{id}")
    public ModelAndView delete(@PathVariable("id") Integer code) {
         
        service.delete(code);
         
        return findAll();
    }
 
    @PostMapping("/savemenu")
    public ModelAndView save(@ModelAttribute("menu")Menu menu, 
            @RequestParam(value = "cbxProfiles" , required = false) int[] cbxProfiles ,
            BindingResult bindingResult , Model model) {
         
    	
    	if(cbxProfiles != null) {
    	    Profile profile = null ;
    	    for (int i = 0; i < cbxProfiles.length; i++) {
    	    	profile = new Profile();
    	    	profile = profileService.findOne(cbxProfiles[i]);
	            menu.getProfiles().add(profile);  
    	    }   	        
    	}
        
        service.save(menu);
         
        return findAll();
    }
     
}