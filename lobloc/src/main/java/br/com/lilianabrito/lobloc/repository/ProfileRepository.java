package br.com.lilianabrito.lobloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lilianabrito.lobloc.vo.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
