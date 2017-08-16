package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the pieces database table.
 * 
 */
@Entity
@Table(name="pieces")
@NamedQuery(name="Piece.findAll", query="SELECT p FROM Piece p")
public class Piece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int piecescode;

	private String color;

	private String description;

	private BigDecimal price;

	private int quantity;

	private String reference;

	//bi-directional many-to-one association to PiecesAgenda
	@OneToMany(mappedBy="piece")
	private List<PiecesAgenda> piecesAgendas;

	public Piece() {
	}

	public int getPiecescode() {
		return this.piecescode;
	}

	public void setPiecescode(int piecescode) {
		this.piecescode = piecescode;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<PiecesAgenda> getPiecesAgendas() {
		return this.piecesAgendas;
	}

	public void setPiecesAgendas(List<PiecesAgenda> piecesAgendas) {
		this.piecesAgendas = piecesAgendas;
	}

	public PiecesAgenda addPiecesAgenda(PiecesAgenda piecesAgenda) {
		getPiecesAgendas().add(piecesAgenda);
		piecesAgenda.setPiece(this);

		return piecesAgenda;
	}

	public PiecesAgenda removePiecesAgenda(PiecesAgenda piecesAgenda) {
		getPiecesAgendas().remove(piecesAgenda);
		piecesAgenda.setPiece(null);

		return piecesAgenda;
	}

}