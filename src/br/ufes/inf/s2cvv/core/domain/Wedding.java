package br.ufes.inf.s2cvv.core.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.s2cvv.event.domain.Event;

@Entity
public class Wedding extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic
	@NotNull
	@Size(max = 100)
	protected String groom;
	
	@Basic
	@NotNull
	@Size(max = 100)
	protected String bride;

	public String getGroom() {
		return groom;
	}

	public void setGroom(String groom) {
		this.groom = groom;
	}

	public String getBride() {
		return bride;
	}

	public void setBride(String bride) {
		this.bride = bride;
	}
}
