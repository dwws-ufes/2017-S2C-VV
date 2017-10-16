package br.ufes.inf.s2cvv.core.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.s2cvv.event.domain.Event;
import br.ufes.inf.s2cvv.people.domain.VolunteerFormation;

@Entity
public class FormationCourse extends Event {

	private static final long serialVersionUID = 1L;

	@Basic
	protected VolunteerFormation volunteerFormation;
	
	@Basic
	@NotNull
	@Size(max = 100)
	protected String responsible;

	public VolunteerFormation getVolunteerFormation() {
		return volunteerFormation;
	}

	public void setVolunteerFormation(VolunteerFormation volunteerFormation) {
		this.volunteerFormation = volunteerFormation;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
}
