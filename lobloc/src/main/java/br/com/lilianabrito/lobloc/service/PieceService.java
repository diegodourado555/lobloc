package br.com.lilianabrito.lobloc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lilianabrito.lobloc.repository.PieceRepository;
import br.com.lilianabrito.lobloc.vo.Piece;

@Service
public class PieceService {

	@Autowired
	private PieceRepository pieceRepository;

	public List<Piece> findAll() {
		return pieceRepository.findAll();
	}

	public Piece findOne(Integer id) {
		return pieceRepository.findOne(id);
	}

	public Piece save(Piece piece) {
		return pieceRepository.saveAndFlush(piece);
	}

	public void delete(Integer id) {
		pieceRepository.delete(id);
	}

}
