package br.com.lilianabrito.lobloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lilianabrito.lobloc.vo.Piece;

@Repository
public interface PieceRepository extends JpaRepository<Piece, Integer> {

}
