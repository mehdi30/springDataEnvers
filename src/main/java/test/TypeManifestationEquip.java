package test;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.envers.AuditMappedBy;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Audited
public class TypeManifestationEquip {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String libelle;
	
	
	@Audited
	//@OneToMany(mappedBy = "typeManifestationEquip", cascade = CascadeType.REMOVE)
	@OneToMany(mappedBy = "typeManifestationEquip")
	@AuditMappedBy(mappedBy = "typeManifestationEquip")
	private List<ManifestationEquip> manifestationEquip;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<ManifestationEquip> getManifestationEquip() {
		return manifestationEquip;
	}


	public void setManifestationEquip(List<ManifestationEquip> manifestationEquip) {
		this.manifestationEquip = manifestationEquip;
	}


	public TypeManifestationEquip() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((manifestationEquip == null) ? 0 : manifestationEquip.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeManifestationEquip other = (TypeManifestationEquip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (manifestationEquip == null) {
			if (other.manifestationEquip != null)
				return false;
		} else if (!manifestationEquip.equals(other.manifestationEquip))
			return false;
		return true;
	}



	

	
	
	
	
}
