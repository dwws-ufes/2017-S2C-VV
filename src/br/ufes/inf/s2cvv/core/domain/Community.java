package br.ufes.inf.s2cvv.core.domain;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
