package fr.verschueren.universite.note.service;

import java.util.List;

import fr.verschueren.universite.note.domaine.Note;

public interface INoteService {
	public List<Note> findAll();
	
	public Note save(Note note);
	
	public Note findOne(Integer idEtudiant, Integer idMatiere);

}
