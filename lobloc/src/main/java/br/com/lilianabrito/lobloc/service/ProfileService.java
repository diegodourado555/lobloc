package br.com.lilianabrito.lobloc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lilianabrito.lobloc.repository.ProfileRepository;
import br.com.lilianabrito.lobloc.vo.Profile;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	public List<Profile> findAll() {
		return profileRepository.findAll();
	}

	public Profile findOne(Integer code) {
		return profileRepository.findOne(code);
	}

	public Profile save(Profile profile) {
		return profileRepository.saveAndFlush(profile);
	}

	public void delete(Integer code) {
		profileRepository.delete(code);
	}

}
