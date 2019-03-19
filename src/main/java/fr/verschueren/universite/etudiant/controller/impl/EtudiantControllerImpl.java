package fr.verschueren.universite.etudiant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.verschueren.universite.enseignant.domaine.Enseignant;
import fr.verschueren.universite.etudiant.controller.IEtudiantController;
import fr.verschueren.universite.etudiant.domaine.Etudiant;
import fr.verschueren.universite.etudiant.service.impl.EtudiantServiceImpl;

@RestController
public class EtudiantControllerImpl implements IEtudiantController {
	Logger log = LoggerFactory.getLogger(EtudiantControllerImpl.class);
	
	@Autowired
	EtudiantServiceImpl etudiantService;

	@Override
	@GetMapping("/etudiants")
	public List<Etudiant> findAll() {
		List<Etudiant> liste = etudiantService.findAll();
		log.info("Nombre etudiants: {};", liste.size());
		return liste;
	}

	@Override
	@GetMapping("/etudiants/{id}")
	public Etudiant findOne(@PathVariable Integer id) {
		Etudiant e = etudiantService.getOne(id);
		return e;
	}

	@Override
	@PostMapping("etudiants")
	public Etudiant save(@RequestBody Etudiant etudiant) {
		Etudiant e = etudiantService.ajouterEtudiant(etudiant);		
		return e;
	}

	@Override
	@DeleteMapping("/etudiants/{id}")
	public void supprimer(@PathVariable Integer id) {
		etudiantService.supprimer(id);		
		
	}

	@Override
	@PutMapping("/etudiants/{id}")
	public Etudiant update(@RequestBody Etudiant etudiant, @PathVariable Integer id) {
		etudiant.setId(id);
		Etudiant e = etudiantService.modifierEtudiant(etudiant);
		return e;	

	}

}
