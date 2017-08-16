package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the piecesgroup database table.
 * 
 */
@Entity
@NamedQuery(name = "Piecesgroup.findAll", query = "SELECT p FROM Piecesgroup p")
public class Piecesgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int piecesgroupcode;

	private String piecesgroupdesc;

	public Piecesgroup() {
	}

	public int getPiecesgroupcode() {
		return this.piecesgroupcode;
	}

	public void setPiecesgroupcode(int piecesgroupcode) {
		this.piecesgroupcode = piecesgroupcode;
	}

	public String getPiecesgroupdesc() {
		return this.piecesgroupdesc;
	}

	public void setPiecesgroupdesc(String piecesgroupdesc) {
		this.piecesgroupdesc = piecesgroupdesc;
	}

}