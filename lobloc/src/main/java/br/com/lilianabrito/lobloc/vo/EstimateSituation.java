package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estimate_situation database table.
 * 
 */
@Entity
@Table(name="estimate_situation")
@NamedQuery(name="EstimateSituation.findAll", query="SELECT e FROM EstimateSituation e")
public class EstimateSituation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int estimatesituationcode;

	private String estimatesituationdesc;

	public EstimateSituation() {
	}

	public int getEstimatesituationcode() {
		return this.estimatesituationcode;
	}

	public void setEstimatesituationcode(int estimatesituationcode) {
		this.estimatesituationcode = estimatesituationcode;
	}

	public String getEstimatesituationdesc() {
		return this.estimatesituationdesc;
	}

	public void setEstimatesituationdesc(String estimatesituationdesc) {
		this.estimatesituationdesc = estimatesituationdesc;
	}

}