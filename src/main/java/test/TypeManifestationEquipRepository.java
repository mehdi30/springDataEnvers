package test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unuManysed")
@Repository
public interface TypeManifestationEquipRepository extends JpaRepository<TypeManifestationEquip, Long>, JpaSpecificationExecutor<TypeManifestationEquip>{


}
