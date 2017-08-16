package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the pieces database table.
 * 
 */
@Entity
@Table(name = "pieces")
@NamedQuery(name = "Piece.findAll", query = "SELECT p FROM Piece p")
public class Piece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int piecescode;

	private String color;

	private String piecesdesc;

	private BigDecimal price;

	private int quantity;

	private String reference;

	// bi-directional many-to-one association to Piecesagenda
	@OneToMany(mappedBy = "piece")
	private List<Piecesagenda> piecesagendas;

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

	public String getPiecesdesc() {
		return this.piecesdesc;
	}

	public void setPiecesdesc(String piecesdesc) {
		this.piecesdesc = piecesdesc;
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

	public List<Piecesagenda> getPiecesagendas() {
		return this.piecesagendas;
	}

	public void setPiecesagendas(List<Piecesagenda> piecesagendas) {
		this.piecesagendas = piecesagendas;
	}

	public Piecesagenda addPiecesagenda(Piecesagenda piecesagenda) {
		getPiecesagendas().add(piecesagenda);
		piecesagenda.setPiece(this);

		return piecesagenda;
	}

	public Piecesagenda removePiecesagenda(Piecesagenda piecesagenda) {
		getPiecesagendas().remove(piecesagenda);
		piecesagenda.setPiece(null);

		return piecesagenda;
	}

}