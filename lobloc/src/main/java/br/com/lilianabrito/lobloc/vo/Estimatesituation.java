package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the estimatesituation database table.
 * 
 */
@Entity
@NamedQuery(name = "Estimatesituation.findAll", query = "SELECT e FROM Estimatesituation e")
public class Estimatesituation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int estsitcode;

	private String estitdesc;

	// bi-directional many-to-one association to Estimate
	@OneToMany(mappedBy = "estimatesituation")
	private List<Estimate> estimates;

	public Estimatesituation() {
	}

	public int getEstsitcode() {
		return this.estsitcode;
	}

	public void setEstsitcode(int estsitcode) {
		this.estsitcode = estsitcode;
	}

	public String getEstitdesc() {
		return this.estitdesc;
	}

	public void setEstitdesc(String estitdesc) {
		this.estitdesc = estitdesc;
	}

	public List<Estimate> getEstimates() {
		return this.estimates;
	}

	public void setEstimates(List<Estimate> estimates) {
		this.estimates = estimates;
	}

	public Estimate addEstimate(Estimate estimate) {
		getEstimates().add(estimate);
		estimate.setEstimatesituation(this);

		return estimate;
	}

	public Estimate removeEstimate(Estimate estimate) {
		getEstimates().remove(estimate);
		estimate.setEstimatesituation(null);

		return estimate;
	}

}