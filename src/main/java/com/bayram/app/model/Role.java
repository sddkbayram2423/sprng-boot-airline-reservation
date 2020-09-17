package com.bayram.app.model;

import java.io.Serializable;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "t_role")
public class Role extends BaseEntity implements Serializable ,GrantedAuthority{
	
	
	private static final long serialVersionUID = 1L;

	@Column(name = "ROLE_NAME",unique = true,nullable = false)
	private String name;

	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
	private List<User> users;

	public Role() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", users=" + users + ", Id=" + getId() + "]";
	}

	@Override
	public String getAuthority() {
		return name;
	}

	


	

}
