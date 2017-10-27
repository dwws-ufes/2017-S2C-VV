package br.ufes.inf.s2cvv.core.application;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.TextUtils;
import br.ufes.inf.s2cvv.core.domain.Priest;
import br.ufes.inf.s2cvv.core.domain.S2CVVConfiguration;
import br.ufes.inf.s2cvv.core.exceptions.SystemInstallFailedException;
import br.ufes.inf.s2cvv.core.persistence.CommunityDAO;
import br.ufes.inf.s2cvv.core.persistence.PriestDAO;
import br.ufes.inf.s2cvv.core.persistence.S2CVVConfigurationDAO;
import br.ufes.inf.s2cvv.core.persistence.VolunteerDAO;

@Stateless
public class InstallSystemServiceBean implements InstallSystemService {

	private static final long serialVersionUID = 1L;

	
	private static final Logger logger = Logger.getLogger(InstallSystemServiceBean.class.getCanonicalName());
	
	@EJB
	private CommunityDAO communityDAO;
	
	@EJB
	private PriestDAO priestDAO;
	
	@EJB
	private VolunteerDAO volunteerDAO;
	
	@EJB
	private S2CVVConfigurationDAO s2cvvConfigurationDAO;
	
	// core info about the system
	@EJB
	private CoreInformation coreInformation;

	@Override
	public void installSystem(S2CVVConfiguration config, Priest admin) throws SystemInstallFailedException {
		logger.log(Level.FINER, "Installing system...");

		try {
			// Encodes the admin's password.
			admin.setPassword(TextUtils.produceMd5Hash(admin.getPassword()));
			
			// Register the last update date / creation date.
			Date now = new Date(System.currentTimeMillis());
			admin.setUpdateDate(now);
			admin.setCreationDate(now);
//			admin.setEmail("");
//			admin.setTelephone("");
			config.setCreationDate(now);
			logger.log(Level.FINE, "Admin's last update date have been set as: {0}", new Object[] { now });
			
			// Saves the administrator.
			logger.log(Level.FINER, "Persisting admin data...\n\t- Short name = {0}\n\t- Last update date = {1}", new Object[] { admin.getName(), admin.getUpdateDate() });
			priestDAO.save(admin);
			logger.log(Level.FINE, "The administrator has been saved: {0} ({1})", new Object[] { admin.getName(), admin.getEmail() });

			// Saves Marvin's configuration.
			logger.log(Level.FINER, "Persisting configuration data...\n\t- Date = {0}\n\t- Acronym = {1}", new Object[] { config.getCreationDate(), config.getParishAcronym() });
			s2cvvConfigurationDAO.save(config);
			logger.log(Level.FINE, "The configuration has been saved");

			// Reloads the bean that holds the configuration and determines if the system is installed.
			logger.log(Level.FINER, "Reloading core information...");
			coreInformation.init();
		}
		catch (NoSuchAlgorithmException e) {
			// Logs and rethrows the exception for the controller to display the error to the user.
			logger.log(Level.SEVERE, "Could not find MD5 algorithm for password encription!", e);
			throw new SystemInstallFailedException(e);
		}
		catch (Exception e) {
			// Logs and rethrows the exception for the controller to display the error to the user.
			logger.log(Level.SEVERE, "Exception during system installation!", e);
			throw new SystemInstallFailedException(e);
		}
	}
}
