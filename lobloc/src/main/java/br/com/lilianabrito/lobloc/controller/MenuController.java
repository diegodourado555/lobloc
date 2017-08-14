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

import br.com.lilianabrito.lobloc.service.MenuService;
import br.com.lilianabrito.lobloc.vo.Menu;
import lombok.Getter;
import lombok.Setter;
 
@Controller
public class MenuController {
	
    @Autowired
    private MenuService service;
    
	@GetMapping("/searchmenus")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/menu/searchmenus");
        mv.addObject("menus", service.findAll());
        mv.addObject("menu", new Menu());
        
        return mv;
    }
     
    @GetMapping("/editmenu/{id}")
    public ModelAndView edit(@PathVariable("id") Integer code) {
         
        ModelAndView mv = new ModelAndView("/menu/searchmenus");
        mv.addObject("menus", service.findAll());
        mv.addObject("menu", service.findOne(code));
        
        return mv;
    }
     
    @GetMapping("/deletemenu/{id}")
    public ModelAndView delete(@PathVariable("id") Integer code) {
         
        service.delete(code);
         
        return findAll();
    }
 
    @PostMapping("/savemenu")
    public ModelAndView save(@Valid Menu menu, BindingResult result) {
         
        if(result.hasErrors()) {
            //TODO: fazer algo quando der erro
        }
        
        service.save(menu);
         
        return findAll();
    }
     
}