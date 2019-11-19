package Audit.configs;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionTimestamp;
import org.hibernate.envers.strategy.ValidityAuditStrategy;

import lombok.Getter;
import lombok.Setter;

@Entity
@RevisionEntity(AuditRevisionListener.class)
@Table(name = "REVINFO")
@AttributeOverrides({@AttributeOverride(name = "timestamp", column = @Column(name = "REVTSTMP")),
@AttributeOverride(name = "id", column = @Column(name = "REV")) })
@Getter
@Setter
public class AuditRevisionEntity extends  DefaultRevisionEntity {

	@Column(name = "USERNAME", nullable = false)
	private String username;

	private Date LastmodifiedAt;
}
