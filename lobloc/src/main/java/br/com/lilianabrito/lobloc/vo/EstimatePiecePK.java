package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the estimate_pieces database table.
 * 
 */
@Embeddable
public class EstimatePiecePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int estimatecode;

	private int piecescode;

	public EstimatePiecePK() {
	}
	public int getEstimatecode() {
		return this.estimatecode;
	}
	public void setEstimatecode(int estimatecode) {
		this.estimatecode = estimatecode;
	}
	public int getPiecescode() {
		return this.piecescode;
	}
	public void setPiecescode(int piecescode) {
		this.piecescode = piecescode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstimatePiecePK)) {
			return false;
		}
		EstimatePiecePK castOther = (EstimatePiecePK)other;
		return 
			(this.estimatecode == castOther.estimatecode)
			&& (this.piecescode == castOther.piecescode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.estimatecode;
		hash = hash * prime + this.piecescode;
		
		return hash;
	}
}