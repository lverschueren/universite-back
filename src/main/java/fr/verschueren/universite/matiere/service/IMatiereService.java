package fr.verschueren.universite.matiere.service;

import java.util.List;


import fr.verschueren.universite.matiere.domaine.Matiere;

public interface IMatiereService {
	public List<Matiere> findAll();
	
	public Matiere getOne(Integer id);
	
	public Matiere ajouterMatiere(Matiere mat);
	
	public Matiere ModifierMatiere(Matiere mat);
	
	public void supprimer(Integer id);
}
