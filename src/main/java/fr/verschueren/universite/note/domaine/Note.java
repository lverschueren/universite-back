package fr.verschueren.universite.note.domaine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.verschueren.universite.etudiant.domaine.Etudiant;
import fr.verschueren.universite.matiere.domaine.Matiere;

@Entity
@Table(name="T_NOTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Note implements Serializable{
	
	@EmbeddedId              /* Injecter ID */
	private NotePK notePK;   /*Cette variable notePK est maintenant la clef primaire avec les deux id_enseignant et id_matiere*/
	
	public NotePK getNotePK() {
		return notePK;
	}

	public void setNotePK(NotePK notePK) {
		this.notePK = notePK;
	}

	@Column(name="NOTE")
	private Double note;
	
	@ManyToOne
	@JoinColumn(name="ID_ETUDIANT", insertable=false, updatable=false)  /* Ne pas prendre en compte id_etudiant car il est dupliqué */
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name="ID_MATIERE", insertable=false, updatable=false)
	private Matiere matiere;

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}
