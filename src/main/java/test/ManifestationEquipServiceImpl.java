package test;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ManifestationEquipServiceImpl implements ManifestationEquipService {

	private final Logger log = LoggerFactory.getLogger(ManifestationEquipServiceImpl.class);

	

	@Autowired
	private ManifestationEquipRepository manifestationEquipRepository;

	@Override
	public Page<Revision<Integer,ManifestationEquip>> getAllRevisions(Long id,Pageable pageable) {
		
		Page<Revision<Integer,ManifestationEquip>> a = manifestationEquipRepository.findRevisions(id, pageable);
	
		//System.out.println(A.getContent().stream().skip(1);{
				
				
				
		return a;
	}



}
