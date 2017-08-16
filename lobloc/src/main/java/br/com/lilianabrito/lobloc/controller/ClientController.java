package br.com.lilianabrito.lobloc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lilianabrito.lobloc.service.ClientService;
import br.com.lilianabrito.lobloc.vo.Client;

@Controller
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping("/searchclients")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/client/searchclients");
		mv.addObject("clients", service.findAll());
		mv.addObject("client", new Client());

		return mv;
	}

	@GetMapping("/editclient/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {

		ModelAndView mv = new ModelAndView("/client/searchclients");
		mv.addObject("clients", service.findAll());
		mv.addObject("client", service.findOne(id));

		return mv;
	}

	@GetMapping("/deleteclient/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/saveclient")
	public ModelAndView save(@Valid Client client, BindingResult result) {

		if (result.hasErrors()) {
			// TODO: fazer algo quando der erro
		}

		service.save(client);

		return findAll();
	}

}