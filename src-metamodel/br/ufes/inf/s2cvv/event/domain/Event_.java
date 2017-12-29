package br.ufes.inf.s2cvv.event.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-29T11:48:20.521-0200")
@StaticMetamodel(Event.class)
public class Event_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, Date> date;
}
