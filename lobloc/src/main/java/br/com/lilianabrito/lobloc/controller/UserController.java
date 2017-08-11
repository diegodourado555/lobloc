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

import br.com.lilianabrito.lobloc.service.UserService;
import br.com.lilianabrito.lobloc.vo.User;
import lombok.Getter;
import lombok.Setter;
 
@Controller
public class UserController {
	
    @Autowired
    private UserService service;
    
	@GetMapping("/searchusers")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/user/searchusers");
        mv.addObject("users", service.findAll());
        mv.addObject("user", new User());
        
        return mv;
    }
     
    @GetMapping("/edituser/{id}")
    public ModelAndView edit(@PathVariable("id") String cpf) {
         
        ModelAndView mv = new ModelAndView("/user/searchusers");
        mv.addObject("users", service.findAll());
        mv.addObject("user", service.findOne(cpf));
        
        return mv;
    }
     
    @GetMapping("/deleteuser/{id}")
    public ModelAndView delete(@PathVariable("id") String cpf) {
         
        service.delete(cpf);
         
        return findAll();
    }
 
    @PostMapping("/saveuser")
    public ModelAndView save(@Valid User user, BindingResult result) {
         
        if(result.hasErrors()) {
            //TODO: fazer algo quando der erro
        }
        
        service.save(user);
         
        return findAll();
    }
     
}