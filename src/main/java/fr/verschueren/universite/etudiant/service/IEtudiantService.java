package fr.verschueren.universite.etudiant.service;

import java.util.List;


import fr.verschueren.universite.etudiant.domaine.Etudiant;

public interface IEtudiantService {
	
	public List<Etudiant> findAll();
	
	public Etudiant getOne(Integer id);	
	
	public Etudiant ajouterEtudiant(Etudiant etud);
	
	public Etudiant modifierEtudiant(Etudiant etud);
	
	public void supprimer(Integer id);

}
