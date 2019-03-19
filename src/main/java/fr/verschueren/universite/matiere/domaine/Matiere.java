package fr.verschueren.universite.matiere.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.verschueren.universite.enseignant.domaine.Enseignant;
import fr.verschueren.universite.note.domaine.Note;

@Entity
@Table(name = "t_matiere")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Matiere implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "NUMERO_MATIERE")
	private Integer numero;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "NOM")
	private String nom;
		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COEFF")
	private Integer coeff;
	
	@ManyToOne
	@JoinColumn(name="ID_ENSEIGNANT")
	private Enseignant enseignantlien;
	
	@JsonIgnore
	@OneToMany(mappedBy="matiere")
	private List<Note> notes;
	
	public Enseignant getEnseignant() {
		return enseignantlien;
	}

	public Enseignant getEnseignantlien() {
		return enseignantlien;
	}

	public void setEnseignantlien(Enseignant enseignantlien) {
		this.enseignantlien = enseignantlien;
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignantlien = enseignant;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCoeff() {
		return coeff;
	}

	public void setCoeff(Integer coeff) {
		this.coeff = coeff;
	}

}
