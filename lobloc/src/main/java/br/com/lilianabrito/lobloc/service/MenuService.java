package br.com.lilianabrito.lobloc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lilianabrito.lobloc.repository.MenuRepository;
import br.com.lilianabrito.lobloc.vo.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	public Menu findOne(Integer code) {
		return menuRepository.findOne(code);
	}

	public Menu save(Menu menu) {
		return menuRepository.saveAndFlush(menu);
	}

	public void delete(Integer code) {
		menuRepository.delete(code);
	}

}
