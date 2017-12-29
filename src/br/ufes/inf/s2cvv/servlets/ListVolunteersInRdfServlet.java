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

import br.ufes.inf.s2cvv.core.domain.Volunteer;
import br.ufes.inf.s2cvv.core.persistence.VolunteerDAO;


@WebServlet(urlPatterns = { "/data/volunteers" })
public class ListVolunteersInRdfServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListVolunteersInRdfServlet.class.getCanonicalName());
	
	@EJB
	private VolunteerDAO volunteerDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		
		List<Volunteer> volunteers = volunteerDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/s2cvv/data/Volunteer/";
		String foafNS = "http://xmlns.com/foaf/0.1/";
		model.setNsPrefix("foaf", foafNS);
		
		Resource Person = ResourceFactory.createResource(foafNS + "Person"); // foaf:Person

		for (Volunteer volunteer : volunteers) {			
			model.createResource(myNS + volunteer.getName()); // this is the resource id
			
			model.getResource(myNS + volunteer.getName()).addProperty(RDF.type, Person);
			model.getResource(myNS + volunteer.getName()).addProperty(FOAF.name, volunteer.getName());
			
			if (!(volunteer.getEmail() == null)) {
				model.getResource(myNS + volunteer.getName()).addProperty(FOAF.mbox, volunteer.getEmail());
			}
			if (!(volunteer.getTelephone() == null)) {
				model.getResource(myNS + volunteer.getName()).addProperty(FOAF.phone, volunteer.getTelephone());
			}			
			logger.log(Level.INFO, "Added Volunteer/" + volunteer.getName() + " to the RDF model");
		}
		
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
		
}