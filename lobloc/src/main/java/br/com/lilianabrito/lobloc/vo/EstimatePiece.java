package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estimate_pieces database table.
 * 
 */
@Entity
@Table(name="estimate_pieces")
@NamedQuery(name="EstimatePiece.findAll", query="SELECT e FROM EstimatePiece e")
public class EstimatePiece implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstimatePiecePK id;

	private int quantity;

	public EstimatePiece() {
	}

	public EstimatePiecePK getId() {
		return this.id;
	}

	public void setId(EstimatePiecePK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}