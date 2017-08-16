package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the piecesagenda database table.
 * 
 */
@Entity
@NamedQuery(name = "Piecesagenda.findAll", query = "SELECT p FROM Piecesagenda p")
public class Piecesagenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agendacode;

	private Timestamp datehourremoval;

	private Timestamp datehourreturn;

	// bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name = "piecescode")
	private Piece piece;

	public Piecesagenda() {
	}

	public int getAgendacode() {
		return this.agendacode;
	}

	public void setAgendacode(int agendacode) {
		this.agendacode = agendacode;
	}

	public Timestamp getDatehourremoval() {
		return this.datehourremoval;
	}

	public void setDatehourremoval(Timestamp datehourremoval) {
		this.datehourremoval = datehourremoval;
	}

	public Timestamp getDatehourreturn() {
		return this.datehourreturn;
	}

	public void setDatehourreturn(Timestamp datehourreturn) {
		this.datehourreturn = datehourreturn;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}