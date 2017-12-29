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

import br.ufes.inf.s2cvv.core.domain.Priest;
import br.ufes.inf.s2cvv.core.persistence.PriestDAO;


@WebServlet(urlPatterns = { "/data/priests" })
public class ListPriestsInRdfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListPriestsInRdfServlet.class.getCanonicalName());
	
	@EJB
	private PriestDAO priestDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		
		List<Priest> priests = priestDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/s2cvv/data/Priest/";
		String foafNS = "http://xmlns.com/foaf/0.1/";
		String dboNS = "http://dbpedia.org/ontology/" ;
		model.setNsPrefix("foaf", foafNS);
		model.setNsPrefix("dbo", dboNS);
		
		Resource Person = ResourceFactory.createResource(foafNS + "Person"); // foaf:Person
		Resource Cleric = ResourceFactory.createResource(dboNS + "Cleric"); // dbo:Cleric

		for (Priest priest : priests) {
			model.createResource(myNS + priest.getName()); // this is the resource id
			
			model.getResource(myNS + priest.getName()).addProperty(RDF.type, Person);
			model.getResource(myNS + priest.getName()).addProperty(RDF.type, Cleric);
			model.getResource(myNS + priest.getName()).addProperty(FOAF.name, priest.getName());
			
			if (!(priest.getEmail() == null)) {
				model.getResource(myNS + priest.getName()).addProperty(FOAF.mbox, priest.getEmail());
			}
			if (!(priest.getTelephone() == null)) {
				model.getResource(myNS + priest.getName()).addProperty(FOAF.phone, priest.getTelephone());
			}			
			logger.log(Level.INFO, "Added Priest/" + priest.getName() + " to the RDF model");
		}
		
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
		
}