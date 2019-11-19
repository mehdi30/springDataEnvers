package test;

import java.util.List;
import java.util.Optional;

import org.springframework.data.history.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@SuppressWarnings("unuManysed")
@Repository
public interface ManifestationEquipRepository extends RevisionRepository<ManifestationEquip,Long, Integer>,JpaRepository<ManifestationEquip, Long>, JpaSpecificationExecutor<ManifestationEquip>{

	@Query(value="SELECT A.montant, A.rev FROM manifestation_equip_aud A RIGHT JOIN revinfo B ON A.rev = B.rev", nativeQuery=true)
	public List<Object[]> getAllAudits();
	
	public  Page<Revision<Integer,ManifestationEquip>> findRevisions(Long id, Pageable pageable);

	
}
