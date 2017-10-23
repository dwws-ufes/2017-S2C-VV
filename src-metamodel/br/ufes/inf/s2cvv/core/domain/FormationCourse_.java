package br.ufes.inf.s2cvv.core.domain;

import br.ufes.inf.s2cvv.event.domain.Event_;
import br.ufes.inf.s2cvv.people.domain.VolunteerFormation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-23T09:34:54.349-0200")
@StaticMetamodel(FormationCourse.class)
public class FormationCourse_ extends Event_ {
	public static volatile SingularAttribute<FormationCourse, VolunteerFormation> volunteerFormation;
	public static volatile SingularAttribute<FormationCourse, String> responsible;
}
