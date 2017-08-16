package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the pieceskit database table.
 * 
 */
@Entity
@NamedQuery(name = "Pieceskit.findAll", query = "SELECT p FROM Pieceskit p")
public class Pieceskit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pieceskitcode;

	private String pieceskitdesc;

	public Pieceskit() {
	}

	public int getPieceskitcode() {
		return this.pieceskitcode;
	}

	public void setPieceskitcode(int pieceskitcode) {
		this.pieceskitcode = pieceskitcode;
	}

	public String getPieceskitdesc() {
		return this.pieceskitdesc;
	}

	public void setPieceskitdesc(String pieceskitdesc) {
		this.pieceskitdesc = pieceskitdesc;
	}

}