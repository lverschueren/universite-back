package fr.verschueren.universite.etudiant.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import fr.verschueren.universite.etudiant.domaine.Etudiant;
import fr.verschueren.universite.etudiant.repository.IEtudiantRepository;
import fr.verschueren.universite.etudiant.service.IEtudiantService;

@Service
public class EtudiantServiceImpl implements IEtudiantService {
	Logger log = LoggerFactory.getLogger(EtudiantServiceImpl.class);
	@Autowired
	IEtudiantRepository etudiantRepository;

	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> liste = etudiantRepository.findAll();
		for (int i=0; i < liste.size(); i++) {			
			Etudiant etud = liste.get(i);
			log.info("Image de l'etudiant : {}", etud.getPhoto() );
			if(etud.getPhoto() == null) {
				liste.get(i).setPhoto("https://www.icone-png.com/png/40/39951.png");
			}
		}		
		return liste;
	}

	@Override
	public Etudiant getOne(Integer id) {
		Etudiant etud = etudiantRepository.getOne(id);
		if(etud.getPhoto() == null || etud.getPhoto().equals("")) {
			etud.setPhoto("https://www.icone-png.com/png/40/39951.png");
		}
		return etud;	
	}

	@Override
	public Etudiant ajouterEtudiant(Etudiant etud) {
		Etudiant x = etudiantRepository.save(etud);
		return x;
	}

	@Override
	public Etudiant modifierEtudiant(Etudiant etud) {
		Etudiant et = etudiantRepository.save(etud);
		return et;
		
	}

	@Override
	@PutMapping("/etudiants/{id}")
	public void supprimer(Integer id) {
		etudiantRepository.deleteById(id);
		
	}

}
