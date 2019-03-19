package fr.verschueren.universite.matiere.controller;

import java.util.List;


import fr.verschueren.universite.matiere.domaine.Matiere;

public interface IMatiereController {
	public List<Matiere> findAll();
	
	public Matiere findOne(Integer id);
	
	public Matiere save(Matiere matiere);
	
	public void supprimer(Integer id);
	
	public Matiere update(Matiere matiere, Integer id);
	
	


}
