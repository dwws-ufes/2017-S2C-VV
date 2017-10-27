package br.ufes.inf.s2cvv.core.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.s2cvv.core.application.ManagePriestsService;
import br.ufes.inf.s2cvv.core.domain.Priest;

@Named
@SessionScoped
public class ManagePriestsController extends CrudController<Priest> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagePriestsService managePriestsService;

	@Override
	protected CrudService<Priest> getCrudService() {
		return managePriestsService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("managePriests.filter.byName", "name", getI18nMessage("msgsCore", "managePriests.text.filter.byName")));
	}
	
	private static final Logger logger = Logger.getLogger(ManagePriestsController.class.getCanonicalName());

	@Inject
	private Conversation conversation;
	
	/** Path to the folder where the view files (web pages) for this action are placed. */
//	private static final String VIEW_PATH = "/core/managePriests/";
	
	/**  */
	public String begin() {
		logger.log(Level.FINEST, "Beginning conversation. Current conversation transient? -> {0}", new Object[] { conversation.isTransient() });

		// Begins the conversation, dropping any previous conversation, if existing.
		if (!conversation.isTransient()) conversation.end();
		conversation.begin();

		// Go to the first view.
		//return VIEW_PATH + "form.xhtml?faces-redirect=true";
		return create();
	}
	
}
