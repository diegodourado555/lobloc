package br.com.lilianabrito.lobloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lilianabrito.lobloc.vo.Client;
import br.com.lilianabrito.lobloc.vo.Piece;
import br.com.lilianabrito.lobloc.vo.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
