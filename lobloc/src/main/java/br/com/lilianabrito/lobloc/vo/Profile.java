package br.com.lilianabrito.lobloc.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@ManyToMany
	@JoinTable(
		name="menu_perfil"
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
		name="usuario_perfil"
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

	public Integer getProfilecode() {
		return this.profilecode;
	}

	public void setProfilecode(Integer profilecode) {
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