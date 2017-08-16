package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer menucode;

	private String description;

	//bi-directional many-to-many association to Profile
	@ManyToMany
	@JoinTable(
			name="menuprofile"
			, joinColumns={
					@JoinColumn(name="menucode")
				}
			, inverseJoinColumns={
					@JoinColumn(name="profilecode")
				}
			)
	private List<Profile> profiles;

	public Menu() {
		profiles = new ArrayList<>();
	}

	public Integer getMenucode() {
		return menucode;
	}

	public void setMenucode(Integer menucode) {
		this.menucode = menucode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}