package fr.verschueren.universite.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.verschueren.universite.note.domaine.Note;
import fr.verschueren.universite.note.domaine.NotePK;
import fr.verschueren.universite.note.repository.INoteRepository;
import fr.verschueren.universite.note.service.INoteService;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	INoteRepository noteRepository;
	
	@Override
	public List<Note> findAll() {
		List<Note> liste = noteRepository.findAll();
		return liste;
	}

	@Override
	public Note save(Note note) {
		Note n = noteRepository.save(note);
		return n;
	}

	@Override
	public Note findOne(Integer idEtudiant, Integer idMatiere) {
		NotePK npk = new NotePK();
		npk.setEtudiant(idEtudiant);
		npk.setMatiere(idMatiere);
		Note n = noteRepository.getOne(npk);
		return n;
	}

	
	

}
