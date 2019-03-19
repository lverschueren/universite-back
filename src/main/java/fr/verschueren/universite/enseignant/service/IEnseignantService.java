package fr.verschueren.universite.enseignant.service;

import java.util.List;


import fr.verschueren.universite.enseignant.domaine.Enseignant;

public interface IEnseignantService {
	
	public List<Enseignant> findAll();
	
	public Enseignant getOne(Integer id);	
	
	public Enseignant ajouterEnseignant(Enseignant e);
	
	public Enseignant modifierEnseignant(Enseignant e);
	
	public void supprimer(Integer id);
	
	
			
}
