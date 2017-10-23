package br.ufes.inf.s2cvv.core.domain;

import br.ufes.inf.s2cvv.event.domain.Event_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-23T09:34:54.353-0200")
@StaticMetamodel(Wedding.class)
public class Wedding_ extends Event_ {
	public static volatile SingularAttribute<Wedding, String> groom;
	public static volatile SingularAttribute<Wedding, String> bride;
}
