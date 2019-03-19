package fr.verschueren.universite.etudiant.controller;

import java.util.List;

import fr.verschueren.universite.etudiant.domaine.Etudiant;

public interface IEtudiantController {
	public List<Etudiant> findAll();
	
	public Etudiant findOne(Integer id);
	
	public Etudiant save(Etudiant etudiant);
	
	public void supprimer(Integer id);
	
	public Etudiant update(Etudiant etudiant, Integer id);


}
