package com.KMuJu.CaseIntervju.controller;

import org.springframework.web.bind.annotation.RestController;

import com.KMuJu.CaseIntervju.model.Forsikring;
import com.KMuJu.CaseIntervju.service.ForsikringService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * ForsikringController
 */
@RestController
public class ForsikringController {

    private final ForsikringService forsikringService;
    
    public ForsikringController(ForsikringService forsikringService) {
		this.forsikringService = forsikringService;
	}

	@GetMapping("/forsikringer")
    public Forsikring[] getForsikringer() {
        return forsikringService.getForsikringer();
    }
}
