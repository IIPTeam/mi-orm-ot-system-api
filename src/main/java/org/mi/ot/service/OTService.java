package org.mi.ot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mi.ot.domain.OTInfo;
import org.mi.ot.repository.OTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OTService {
	
	@Autowired
	private OTRepository repository;

	@Transactional
	public void update(OTInfo ot){
		StringBuffer hql = new StringBuffer("update staff_ot set ");
		List<Object> params = new ArrayList<Object>();
		OTInfo old_ot = null;
		if(ot != null){
			old_ot = repository.findOne(ot.getId());
			
			if(ot.getApproval() != null){
				hql.append(" approval = ?, ");
				params.add(ot.getApproval());
			}
			if(ot.getCurrentProject() != null){
				hql.append(" currentProject = ?, ");
				params.add(ot.getCurrentProject());
			}
			if(ot.getDate() != null){
				hql.append(" date = ?, ");
				params.add(ot.getDate());
			}
			if(ot.getHours() != null){
				hql.append(" hours = ?, ");
				params.add(ot.getHours());
			}
			if(!StringUtils.isEmpty(ot.getReason())){
				hql.append(" reason = ?, ");
				params.add(ot.getReason());
			}
			if(ot.getStaffID() != null){
				hql.append(" staffID = ?, ");
				params.add(ot.getStaffID());
			}
			if(ot.getSupportProject() != null){
				hql.append(" supportProject = ?, ");
				params.add(ot.getSupportProject());
			}
			hql.append(" version = ? where id = ? and version = ? ");
			params.add(old_ot.getVersion() + 1);
			params.add(old_ot.getId());
			params.add(old_ot.getVersion());
		}
		repository.executeUpdate(hql.toString(), params);
	}
	
	@Transactional
	public OTInfo add(OTInfo ot){
		return this.repository.save(ot);
	}
}
