package fr.verschueren.universite.note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.verschueren.universite.note.domaine.Note;
import fr.verschueren.universite.note.domaine.NotePK;

@Repository
public interface INoteRepository extends JpaRepository<Note, NotePK> {
	
	

}
