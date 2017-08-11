package br.com.lilianabrito.lobloc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lilianabrito.lobloc.repository.UserRepository;
import br.com.lilianabrito.lobloc.vo.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}

	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public void delete(Integer id) {
		userRepository.delete(id);
	}

}
