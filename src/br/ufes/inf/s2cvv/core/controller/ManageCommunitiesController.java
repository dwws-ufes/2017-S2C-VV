package br.ufes.inf.s2cvv.core.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.s2cvv.core.application.ManageCommunitiesService;
import br.ufes.inf.s2cvv.core.domain.Community;

@Named
@SessionScoped
public class ManageCommunitiesController extends CrudController<Community> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageCommunitiesService manageCommunitiesService;
	
	public void suggestState( ) {
		String name = selectedEntity.getCity();
		if (name != null && name.length() > 3) {
//			String query = "PREFIX dbo: <http://dbpedia.org/ontology/> " + "SELECT ?desc " +
//					"WHERE { " +
//					"?x a dbo:Place ; " +
//					"rdfs:label ?name ; " +
//					"dbo:abstract ?desc . " +
//					"FILTER (?name = \"" + name + "\"@en) " + "FILTER (langMatches(lang(?desc), \"EN\")) " +
//					"}";
			
//			String query = "PREFIX gn: <http://www.geonames.org/ontology#>\n" + 
//					"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
//					"PREFIX geo-pos: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n" + 
//					"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
//					"select (min(?link) as ?link) (min(?lmap) as ?lmap) (min(?wpa) as ?wpa)\n" + 
//					"    where {\n" + 
//					"        ?nbhood gn:parentCountry <http://sws.geonames.org/3469034/> ;\n" + 
//					"        gn:parentADM1 <http://sws.geonames.org/3463930/> ;\n" + 
//					"		gn:name \"" + name + "\" ;\n" + 
//					"  		rdfs:isDefinedBy ?link ;\n" + 
//					"    	gn:locationMap ?lmap ;\n" + 
//					"		gn:featureClass gn:A .\n" + 
//					"    	optional {?nbhood gn:wikipediaArticle ?wpa .}\n" + 
//					"    }\n" + 
//					"group by (?name)\n";
//			QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
//			ResultSet results = queryExecution.execSelect();
//			if (results.hasNext()) {
//				QuerySolution querySolution = results.next();
//				Literal literal = querySolution.getLiteral("state");
//				selectedEntity.setState("" + literal.getValue());
//			}
			selectedEntity.setState("Espírito Santo");
		}
	}

	@Override
	protected CrudService<Community> getCrudService() {
		return manageCommunitiesService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageCommunities.filter.byName", "name", getI18nMessage("msgsCore", "manageCommunities.text.filter.byName")));
	}
	
	private static final Logger logger = Logger.getLogger(ManageCommunitiesController.class.getCanonicalName());

	@Inject
	private Conversation conversation;
	
	/** Path to the folder where the view files (web pages) for this action are placed. */
	
	/**  */
	public String begin() {
		logger.log(Level.FINEST, "Beginning conversation. Current conversation transient? -> {0}", new Object[] { conversation.isTransient() });

		// Begins the conversation, dropping any previous conversation, if existing.
		if (!conversation.isTransient()) conversation.end();
		conversation.begin();

		return create();
	}
	
}
