package fr.verschueren.universite.note.controller;

import java.util.List;

import fr.verschueren.universite.note.domaine.Note;

public interface INoteController {
	public List<Note> findAll();
	
	public Note findOne(Integer idEtudiant, Integer idMatiere);
	
	public Note save(Note note);

}
