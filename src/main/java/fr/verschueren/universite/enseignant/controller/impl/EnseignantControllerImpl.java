package fr.verschueren.universite.enseignant.controller.impl;

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

import fr.verschueren.universite.enseignant.controller.IEnseignantController;
import fr.verschueren.universite.enseignant.domaine.Enseignant;
import fr.verschueren.universite.enseignant.service.impl.EnseignantServiceImpl;

@RestController
public class EnseignantControllerImpl implements IEnseignantController {		
	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);
	
	@Autowired
	EnseignantServiceImpl enseignantService;
	
	@Override
	@GetMapping("/enseignants")
	public List<Enseignant> findAll() {
		List<Enseignant> liste = enseignantService.findAll();
		log.info("Nombre enseignants: {};", liste.size());
		return liste;
	}

	@Override
	@GetMapping("/enseignants/{id}")
	public Enseignant findOne(@PathVariable Integer id) {
		Enseignant e = enseignantService.getOne(id);
		return e;
	}

	@Override
	@PostMapping("/enseignants")
	public Enseignant save(@RequestBody Enseignant enseignant) {
		Enseignant e = enseignantService.ajouterEnseignant(enseignant);
		return e;
	}

	@Override
	@DeleteMapping("/enseignants/{id}")
	public void supprimer(@PathVariable Integer id) {
		enseignantService.supprimer(id);		
	}

	@Override
	@PutMapping("/enseignants/{id}")
	public Enseignant update(@RequestBody Enseignant enseignant, @PathVariable Integer id) {
		enseignant.setId(id);
		Enseignant e = enseignantService.modifierEnseignant(enseignant);
		return e;	

	}	
	

}
