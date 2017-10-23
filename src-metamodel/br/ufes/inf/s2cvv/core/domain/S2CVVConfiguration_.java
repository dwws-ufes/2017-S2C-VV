package br.ufes.inf.s2cvv.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-10-23T11:28:41.828-0200")
@StaticMetamodel(S2CVVConfiguration.class)
public class S2CVVConfiguration_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<S2CVVConfiguration, Date> creationDate;
	public static volatile SingularAttribute<S2CVVConfiguration, String> parishAcronym;
}
