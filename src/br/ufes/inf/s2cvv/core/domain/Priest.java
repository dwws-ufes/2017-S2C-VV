package br.ufes.inf.s2cvv.core.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.ufes.inf.s2cvv.people.domain.Person;
import br.ufes.inf.s2cvv.people.domain.PriestFormation;

@Entity
public class Priest extends Person {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	PriestFormation formation;

	public PriestFormation getFormation() {
		return formation;
	}

	public void setFormation(PriestFormation formation) {
		this.formation = formation;
	}

}
