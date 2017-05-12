package org.mi.ot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mi.common.MergeUtil;
import org.mi.ot.domain.OTInfo;
import org.mi.ot.repository.OTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTService {
	
	@Autowired
	private OTRepository repository;

	@Transactional
	public void update(OTInfo ot){
		OTInfo db_ot = repository.findOne(ot.getId());
		MergeUtil.simpleMerge(ot, db_ot, new String[]{""});
		repository.save(db_ot);
	}
	
	@Transactional
	public OTInfo add(OTInfo ot){
		return this.repository.save(ot);
	}
	
	public List<OTInfo> list(){
		return this.repository.findAll();
	}
}
