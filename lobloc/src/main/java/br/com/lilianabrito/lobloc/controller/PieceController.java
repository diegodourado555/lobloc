package br.com.lilianabrito.lobloc.controller;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lilianabrito.lobloc.service.PieceService;
import br.com.lilianabrito.lobloc.vo.Piece;

@Controller
public class PieceController {

	@Autowired
	private PieceService service;

	@GetMapping("/searchpieces")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/piece/searchpieces");
		mv.addObject("pieces", service.findAll());
		mv.addObject("piece", new Piece());

		return mv;
	}

	@GetMapping("/editpiece/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {

		ModelAndView mv = new ModelAndView("/piece/searchpieces");
		mv.addObject("pieces", service.findAll());
		mv.addObject("piece", service.findOne(id));

		return mv;
	}

	@GetMapping("/deletepiece/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/savepiece")
	public ModelAndView save(@Valid Piece piece, BindingResult result) {

		if (result.hasErrors()) {
			// TODO: fazer algo quando der erro
		}
		piece.setReference(new Timestamp(System.currentTimeMillis()).toString().substring(0, 19).replaceAll(":", "").replaceAll("-", "").replaceAll(" ", ""));
		service.save(piece);

		return findAll();
	}

}