package test;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revision;


public interface ManifestationEquipService {



	Page<Revision<Integer, ManifestationEquip>> getAllRevisions(Long id, Pageable pageable);



}
