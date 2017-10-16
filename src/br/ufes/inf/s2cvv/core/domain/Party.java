package br.ufes.inf.s2cvv.core.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

import br.ufes.inf.s2cvv.event.domain.Event;

@Entity
public class Party extends Event {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@Min(value = 0)
	protected double budget;
	
	@Basic
	@Min(value = 0)
	protected double revenue;

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

}
