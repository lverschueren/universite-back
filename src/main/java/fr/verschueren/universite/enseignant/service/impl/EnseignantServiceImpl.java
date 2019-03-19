package fr.verschueren.universite.enseignant.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.verschueren.universite.enseignant.domaine.Enseignant;
import fr.verschueren.universite.enseignant.repository.IEnseignantRepository;
import fr.verschueren.universite.enseignant.service.IEnseignantService;

@Service
public class EnseignantServiceImpl implements IEnseignantService{
	Logger log = LoggerFactory.getLogger(EnseignantServiceImpl.class);	
	@Autowired
	IEnseignantRepository enseignantRepository;

	@Override
	public List<Enseignant> findAll(){		
		List<Enseignant> liste = enseignantRepository.findAll();
		// Verifier l'image pour chaque enseignant
		// Si Il n'en possède pas, on lui donne la suivante par défaut
		// http://www.icone-png.com/png/48/47932.png
		
		for(int i = 0 ; i < liste.size() ; i++) {
			Enseignant e = liste.get(i);
			log.info("Image de l'enseignant : {}", e.getPhoto() );	
			if(e.getPhoto() == null) {
				liste.get(i).setPhoto("http://www.icone-png.com/png/48/47932.png");
			}
		}
		return liste;		
	}

	@Override
	public Enseignant getOne(Integer id) {
		Enseignant e = enseignantRepository.getOne(id);
		if(e.getPhoto() == null || e.getPhoto().equals("")) {
			e.setPhoto("http://www.icone-png.com/png/48/47932.png");
		}
		return e;	
		
		}

	@Override
	public Enseignant ajouterEnseignant(Enseignant e) {
		Enseignant en = enseignantRepository.save(e);
		return en;
		
	}

	@Override
	public Enseignant modifierEnseignant(Enseignant e) {
		Enseignant en = enseignantRepository.save(e);
		return en;
	}

	@Override
	public void supprimer(Integer id) {
		enseignantRepository.deleteById(id);
		
	}		
}



