package fr.verschueren.universite.matiere.controller.impl;

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


import fr.verschueren.universite.matiere.controller.IMatiereController;
import fr.verschueren.universite.matiere.domaine.Matiere;
import fr.verschueren.universite.matiere.service.impl.MatiereServiceImpl;

@RestController
public class MatiereControllerImpl implements IMatiereController {
	Logger log = LoggerFactory.getLogger(MatiereControllerImpl.class);
	
	@Autowired	
	MatiereServiceImpl matiereService;

	@Override
	@GetMapping("/matieres")
	public List<Matiere> findAll() {
		List<Matiere> liste = matiereService.findAll();
		log.info("Nombre matieres: {};", liste.size());
		return liste;
	}

	@Override
	@GetMapping("/matieres/{id}")
	public Matiere findOne(@PathVariable Integer id) {
		Matiere m = matiereService.getOne(id);
		return m;
	}

	@Override
	@PostMapping("/matieres")
	public Matiere save(@RequestBody Matiere matiere) {
		Matiere m = matiereService.ajouterMatiere(matiere);
		return m;
	}

	@Override
	@DeleteMapping("/matieres/{id}")
	public void supprimer(@PathVariable Integer id) {
		matiereService.supprimer(id);		
		
	}

	@Override
	@PutMapping("/matieres/{id}")
	public Matiere update(@RequestBody Matiere matiere, @PathVariable Integer id) {
		matiere.setId(id);
		Matiere m = matiereService.ModifierMatiere(matiere);
		return m;		
	
	}

}
