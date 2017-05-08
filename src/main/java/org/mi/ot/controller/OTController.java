package org.mi.ot.controller;

import javax.validation.Valid;

import org.mi.ot.domain.OTInfo;
import org.mi.ot.service.OTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process/ot")
public class OTController {
	
	@Autowired
	private OTService otService;
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody @Valid OTInfo ot){
		otService.update(ot);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public OTInfo add(@RequestBody OTInfo ot) {
		return otService.add(ot);
	}
}
