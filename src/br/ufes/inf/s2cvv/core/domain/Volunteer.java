package br.ufes.inf.s2cvv.core.domain;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import br.ufes.inf.s2cvv.people.domain.Group;
import br.ufes.inf.s2cvv.people.domain.Person;
import br.ufes.inf.s2cvv.people.domain.VolunteerFormation;

@Entity
public class Volunteer extends Person {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	VolunteerFormation formation;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	protected Set<Group> participatesIn;

	public VolunteerFormation getFormation() {
		return formation;
	}

	public void setFormation(VolunteerFormation formation) {
		this.formation = formation;
	}

	public Set<Group> getParticipatesIn() {
		return participatesIn;
	}

	public void setParticipatesIn(Set<Group> participatesIn) {
		this.participatesIn = participatesIn;
	}
}
