package auto.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.spring.dao.RapportDao;
import auto.spring.modele.Fidelisation;
import auto.spring.modele.RapportJournalier;

@Service
public class RapportService {

	@Autowired
	private RapportDao RapportDao;

	public List<Fidelisation> getRapportFidelisation() {
		return RapportDao.getRapportFidelisation();
	}

	public List<RapportJournalier> getRapportJournalier() {
		return RapportDao.getRapportJournalier();
	}
}
