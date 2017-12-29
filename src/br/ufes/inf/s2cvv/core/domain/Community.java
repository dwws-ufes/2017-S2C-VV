package br.ufes.inf.s2cvv.core.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;
import br.ufes.inf.s2cvv.event.domain.Event;

@Entity
public class Community extends PersistentObjectSupport implements Comparable<Community>{

	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	@Size(max = 100)
	protected String name;
	
	@Basic
	@NotNull
	@Size(max = 15)
	protected String telephone;
	
	@Basic
	@NotNull
	@Size(max = 200)
	protected String address;
	
	@Basic
	@NotNull
	@Size(max = 60)
	protected String city;
	
	@Lob
	protected String state;

	@Temporal(TemporalType.DATE)
	protected Date creationDate;

	@Temporal(TemporalType.DATE)
	protected Date loginDate;

	@Temporal(TemporalType.DATE)
	protected Date updateDate;
	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	protected Set<Event> communityEvents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int compareTo(Community o) {
		// Compare the persons' names
		if (name == null) return 1;
		if (o.name == null) return -1;
		int cmp = name.compareTo(o.name);
		if (cmp != 0) return cmp;

		// If it's the same name, check if it's the same entity.
		return uuid.compareTo(o.uuid);
	}

}
