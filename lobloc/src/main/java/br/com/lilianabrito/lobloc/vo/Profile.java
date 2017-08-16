package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
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
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profilecode;

	private String description;

	//bi-directional many-to-many association to Menu
		@ManyToMany
		@JoinTable(
			name="menuprofile"
			, joinColumns={
				@JoinColumn(name="profilecode")
				}
			, inverseJoinColumns={
				@JoinColumn(name="menucode")
				}
			)
		private List<Menu> menus;

		//bi-directional many-to-many association to User
		@ManyToMany
		@JoinTable(
			name="userprofile"
			, joinColumns={
				@JoinColumn(name="profilecode")
				}
			, inverseJoinColumns={
				@JoinColumn(name="cpf")
				}
			)
		private List<User> users;

	public Profile() {
	}

	public int getProfilecode() {
		return this.profilecode;
	}

	public void setProfilecode(int profilecode) {
		this.profilecode = profilecode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}