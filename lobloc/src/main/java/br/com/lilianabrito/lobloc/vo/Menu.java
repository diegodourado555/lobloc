package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@ManyToMany(mappedBy="menus")
	private List<Profile> profiles;

	public Menu() {
	}

	public Integer getMenucode() {
		return this.menucode;
	}

	public void setMenucode(Integer menucode) {
		this.menucode = menucode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}