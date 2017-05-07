package org.mi.ot.service;

import javax.transaction.Transactional;

import org.mi.ot.domain.OTInfo;
import org.mi.ot.repository.OTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTService {
	
	@Autowired
	private OTRepository repository;

	@Transactional
//	@Query(value = "update otInfo set name=?1 where id=?2 ", nativeQuery=true)
//	@Modifying
	public void update(OTInfo ot){
//		this.repository.updateById(ot, ot.getId());
		repository.save(ot);
	}
	
	@Transactional
	public OTInfo add(OTInfo ot){
		return this.repository.saveAndFlush(ot);
	}
}
