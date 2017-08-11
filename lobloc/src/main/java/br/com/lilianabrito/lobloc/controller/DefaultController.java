package br.com.lilianabrito.lobloc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lilianabrito.lobloc.vo.Client;
import br.com.lilianabrito.lobloc.vo.Login;
import lombok.Getter;
import lombok.Setter;
 
@Controller
public class DefaultController {
     
    @GetMapping("/")
    public ModelAndView initial() {
         
        ModelAndView mv = new ModelAndView("/login");
        
        Login login = new Login();
        
        mv.addObject("login", login);
        
        return mv;
    }
    @GetMapping("/login")
    public ModelAndView login() {
    	
    	ModelAndView mv = new ModelAndView("/login");
    	
    	Login login = new Login();
    	
    	mv.addObject("login", login);
    	
    	return mv;
    }
    @GetMapping("/home")
    public ModelAndView home() {
    	
    	ModelAndView mv = new ModelAndView("/home");
    	
    	return mv;
    }
        
}