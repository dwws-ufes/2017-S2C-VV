package br.ufes.inf.s2cvv.event.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-23T09:34:54.354-0200")
@StaticMetamodel(Event.class)
public class Event_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Event, String> name;
	public static volatile SingularAttribute<Event, Date> date;
}
