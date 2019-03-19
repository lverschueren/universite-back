package fr.verschueren.universite.enseignant.controller;

import java.util.List;

import fr.verschueren.universite.enseignant.domaine.Enseignant;

public interface IEnseignantController {
	public List<Enseignant> findAll();
	
	public Enseignant findOne(Integer id);
	
	public Enseignant save(Enseignant enseignant);
	
	public void supprimer(Integer id);
	
	public Enseignant update(Enseignant enseignant, Integer id);

}
