package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pieces_agenda database table.
 * 
 */
@Entity
@Table(name="pieces_agenda")
@NamedQuery(name="PiecesAgenda.findAll", query="SELECT p FROM PiecesAgenda p")
public class PiecesAgenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int agendacode;

	private Timestamp datehourremoval;

	private Timestamp datehourreturn;

	//bi-directional many-to-one association to Piece
	@ManyToOne
	@JoinColumn(name="piecescode")
	private Piece piece;

	public PiecesAgenda() {
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