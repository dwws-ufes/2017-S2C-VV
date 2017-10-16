package br.ufes.inf.s2cvv.people.domain;

public enum VolunteerFormation {
	PRIMEIRA_EUCARISTIA ("Primeira Eucaristia"),
	CRISMA ("Crisma"),
	MINISTRO ("Ministro");
	
	public String getFormation() {
		return formation;
	}

	protected String formation;
	
	private VolunteerFormation(String o) {
		this.formation = o;
	}
}
