package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer profilecode;

	private String description;

	//bi-directional many-to-many association to Menu
	@ManyToMany(mappedBy="profiles")	
	private List<Menu> menus;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="profiles")
	private List<User> users;

	public Profile() {
	}

	public Integer getProfilecode() {
		return profilecode;
	}

	public void setProfilecode(Integer profilecode) {
		this.profilecode = profilecode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}