package fr.verschueren.universite.etudiant.domaine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.verschueren.universite.note.domaine.Note;

@Entity
@Table(name = "t_etudiant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  /* Toujours avec @RestController, Pour ignorer le conflit entre Jackson JSON et Spring mvc Hibbernate quand création objet java. */
public class Etudiant implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "NOM")
	private String nom;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PRENOM")
	private String prenom;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "NUMERO_ETUDIANT")
	private Integer numero;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SEXE")
	private String sexe;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "DATE_NAISSANCE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PHOTO")
	private String photo;
	
	@JsonIgnore
	@OneToMany(mappedBy="etudiant")
	private List<Note> notes;
	
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
}
