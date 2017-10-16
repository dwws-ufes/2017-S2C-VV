package br.ufes.inf.s2cvv.people.domain;

public enum PriestFormation {
	ITEM1 ("Item 1"),
	ITEM2 ("Item 2");
	
	protected String formation;
	
	public String getFormation() {
		return formation;
	}

	private PriestFormation(String o) {
		this.formation = o;
	}
}
