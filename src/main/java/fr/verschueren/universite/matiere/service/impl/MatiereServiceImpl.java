package fr.verschueren.universite.matiere.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.verschueren.universite.matiere.domaine.Matiere;
import fr.verschueren.universite.matiere.repository.IMatiereRepository;
import fr.verschueren.universite.matiere.service.IMatiereService;

@Service
public class MatiereServiceImpl implements IMatiereService{
	Logger log = LoggerFactory.getLogger(MatiereServiceImpl.class);	

	@Autowired
	IMatiereRepository matiereRepository;
	
	public List<Matiere> findAll() {
		List<Matiere> liste = matiereRepository.findAll(); 
		return liste;
	}

	@Override
	public Matiere getOne(Integer id) {
		Matiere m = matiereRepository.getOne(id);
		return m;
	}

	@Override
	public Matiere ajouterMatiere(Matiere mat) {
		Matiere m = matiereRepository.save(mat);
		return m;
	}

	@Override
	public Matiere ModifierMatiere(Matiere mat) {
		Matiere ma = matiereRepository.save(mat);
		return ma;
	}

	@Override
	public void supprimer(Integer id) {
		matiereRepository.deleteById(id);
		
	}

}
