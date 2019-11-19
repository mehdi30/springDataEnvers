package test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;


import lombok.Data;

@Entity
@Audited
public class ManifestationEquip{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long nbre;
	
	private Double montant;
	
	private String source;
	
	  
	  
	
	@Audited
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(insertable=false, updatable=false) //(fetch = FetchType.EAGER)
	private TypeManifestationEquip typeManifestationEquip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNbre() {
		return nbre;
	}

	public void setNbre(Long nbre) {
		this.nbre = nbre;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
	public TypeManifestationEquip getTypeManifestationEquip() {
		return typeManifestationEquip;
	}

	public void setTypeManifestationEquip(TypeManifestationEquip typeManifestationEquip) {
		this.typeManifestationEquip = typeManifestationEquip;
	}

	public ManifestationEquip() {
		super();
	}

	

	
	

	
	
	
}
