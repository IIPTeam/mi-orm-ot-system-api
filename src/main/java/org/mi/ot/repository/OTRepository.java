package org.mi.ot.repository;

import org.mi.ot.domain.OTInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTRepository extends JpaRepository<OTInfo, Long>{

//	void updateById(OTInfo ot, long id); 
}
