package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the estimatepieces database table.
 * 
 */
@Entity
@Table(name = "estimatepieces")
@NamedQuery(name = "Estimatepiece.findAll", query = "SELECT e FROM Estimatepiece e")
public class Estimatepiece implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstimatepiecePK id;

	private int quantity;

	public Estimatepiece() {
	}

	public EstimatepiecePK getId() {
		return this.id;
	}

	public void setId(EstimatepiecePK id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}