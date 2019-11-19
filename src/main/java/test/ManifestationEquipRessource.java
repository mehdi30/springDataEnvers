package test;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revision;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/manifestationEquip")
public class ManifestationEquipRessource {

	private final Logger log = LoggerFactory.getLogger(ManifestationEquipRessource.class);
	
	
	@Autowired
	private ManifestationEquipService manifestationEquipService;

	@Autowired
	private EntityManager  entityManager ;
	
	
	private static final String ENTITY_NAME = "ManifestationEquip";

	@GetMapping("/rev/{id}")
	public Page<Revision<Integer, ManifestationEquip>> getAllRevisions(@PathVariable Long id, Pageable pageable) {
		 return this.manifestationEquipService.getAllRevisions(id, pageable);
		 
	}

	@GetMapping("/rev1/{id}")
	public List<ManifestationEquip> getAllRevisions1(@PathVariable Long id, Pageable pageable) {
		AuditReader reader = AuditReaderFactory.get(entityManager);
		
		AuditQuery q = reader.createQuery().forRevisionsOfEntity(ManifestationEquip.class, true, true);
		q.add(AuditEntity.id().eq(id));
		List<ManifestationEquip> audit = q.getResultList();

		 return audit;
		 
	}
	
	
	
	
	  

    

}
