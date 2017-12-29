package br.ufes.inf.s2cvv.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import br.ufes.inf.s2cvv.core.domain.Community;
import br.ufes.inf.s2cvv.core.persistence.CommunityDAO;


@WebServlet(urlPatterns = { "/data/communities" })
public class ListCommunitiesInRdfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListCommunitiesInRdfServlet.class.getCanonicalName());
	
	@EJB
	private CommunityDAO communityDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		
		List<Community> communities = communityDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/s2cvv/data/Community/";
		String dboNS = "http://dbpedia.org/ontology/" ;
		model.setNsPrefix("dbo", dboNS);
		
		Resource Church = ResourceFactory.createResource(dboNS + "Church"); // dbo:Person

		for (Community community : communities) {
			System.out.println(community.getName());
			System.out.println(community.getTelephone());
			System.out.println(community.getAddress());
			//System.out.println(community.getState());
			
			model.createResource(myNS + community.getName()); // this is the resource id
			
			model.getResource(myNS + community.getName()).addProperty(RDF.type, Church);
			model.getResource(myNS + community.getName()).addProperty(RDFS.label, community.getName());
			
			if (!(community.getTelephone() == null)) {
				model.getResource(myNS + community.getName()).addProperty(FOAF.phone, community.getTelephone());
			}
			logger.log(Level.INFO, "Added Community/" + community.getName() + " to the RDF model");
		}
		
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
		
}