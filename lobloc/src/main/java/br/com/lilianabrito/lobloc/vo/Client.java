package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer clientcode;
	@Column
	private String address;
	@Column
	private String cpf;
	@Column
	private String email;
	@Column
	private String name;
	@Column
	private String phone;

	//bi-directional many-to-one association to Estimate
	@OneToMany(mappedBy="client")
	private List<Estimate> estimates;

	public Client() {
	}
	
	public Client(Integer clientcode, String address, String cpf, String email, String name, String phone,
			List<Estimate> estimates) {
		super();
		this.clientcode = clientcode;
		this.address = address;
		this.cpf = cpf;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.estimates = estimates;
	}
	public Client(String address, String cpf, String email, String name, String phone,
			List<Estimate> estimates) {
		super();
		this.address = address;
		this.cpf = cpf;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.estimates = estimates;
	}

	public Integer getClientcode() {
		return this.clientcode;
	}

	public void setClientcode(Integer clientcode) {
		this.clientcode = clientcode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Estimate> getEstimates() {
		return this.estimates;
	}

	public void setEstimates(List<Estimate> estimates) {
		this.estimates = estimates;
	}

	public Estimate addEstimate(Estimate estimate) {
		getEstimates().add(estimate);
		estimate.setClient(this);

		return estimate;
	}

	public Estimate removeEstimate(Estimate estimate) {
		getEstimates().remove(estimate);
		estimate.setClient(null);

		return estimate;
	}

}