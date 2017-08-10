package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the estimate database table.
 * 
 */
@Entity
@NamedQuery(name="Estimate.findAll", query="SELECT e FROM Estimate e")
public class Estimate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int estimatecode;

	private BigDecimal discount;

	private String notes;

	private BigDecimal price;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientcode")
	private Client client;

	public Estimate() {
	}

	public int getEstimatecode() {
		return this.estimatecode;
	}

	public void setEstimatecode(int estimatecode) {
		this.estimatecode = estimatecode;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}