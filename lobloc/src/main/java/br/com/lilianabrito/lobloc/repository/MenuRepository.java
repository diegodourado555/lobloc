package br.com.lilianabrito.lobloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lilianabrito.lobloc.vo.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
