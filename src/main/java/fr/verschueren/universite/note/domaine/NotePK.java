package fr.verschueren.universite.note.domaine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable  /* = Injectable : Ce n'est pas une entité, la classe est là pour être utilisée dans notre table Entité*/
public class NotePK implements Serializable{   /* Serializable permet de dire que l'on peut transformer l'objet en ce que l'on veut */
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID_ETUDIANT")
	private Integer etudiant;
	
	@Column(name="ID_MATIERE")
	private Integer matiere;

	public Integer getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Integer etudiant) {
		this.etudiant = etudiant;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}

}
