package br.com.lilianabrito.lobloc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lilianabrito.lobloc.repository.ClientRepository;
import br.com.lilianabrito.lobloc.vo.Client;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findOne(Integer id) {
		return clientRepository.findOne(id);
	}

	public Client save(Client post) {
		return clientRepository.saveAndFlush(post);
	}

	public void delete(Integer id) {
		clientRepository.delete(id);
	}

}
