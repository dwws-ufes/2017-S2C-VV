package br.ufes.inf.s2cvv.people.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@MappedSuperclass
public class Person extends PersistentObjectSupport implements Comparable<Person> {

	private static final long serialVersionUID = 1L;

	@Basic
	@NotNull
	@Size(max = 100)
	protected String name;

	@Temporal(TemporalType.DATE)
	protected Date birthDate;

	@Basic
	@Size(max = 25)
	protected String telephone;

	@Basic
	@Size(max = 50)
	protected String email;

	@Basic
	@Size(max = 50)
	protected String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	protected Date creationDate;

	@Temporal(TemporalType.DATE)
	protected Date loginDate;

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Temporal(TemporalType.DATE)
	protected Date updateDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public int compareTo(Person o) {
		// Compare the persons' names
		if (name == null) return 1;
		if (o.name == null) return -1;
		int cmp = name.compareTo(o.name);
		if (cmp != 0) return cmp;

		// If it's the same name, check if it's the same entity.
		return uuid.compareTo(o.uuid);
	}

	@Override
	public String toString() {
		return name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
