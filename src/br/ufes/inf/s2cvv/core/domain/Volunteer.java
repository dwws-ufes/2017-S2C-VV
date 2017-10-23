package br.ufes.inf.s2cvv.core.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.ufes.inf.s2cvv.people.domain.Person;
import br.ufes.inf.s2cvv.people.domain.VolunteerFormation;

@Entity
public class Volunteer extends Person {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	VolunteerFormation formation;

	public VolunteerFormation getFormation() {
		return formation;
	}

	public void setFormation(VolunteerFormation formation) {
		this.formation = formation;
	}
}
