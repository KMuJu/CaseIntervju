package com.KMuJu.CaseIntervju.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.service.DekningService;


/**
 * ForsikringController
 */
@RestController
public class DekningController {

    private final DekningService forsikringService;
    
    public DekningController(DekningService forsikringService) {
		this.forsikringService = forsikringService;
	}

	@GetMapping("/dekninger")
    public List<Dekning> getDekninger() {
        return forsikringService.getDekninger();
    }

    @PutMapping("/dekning")
    public void putDekning(@RequestBody Dekning dekning) {
        forsikringService.createDekning(dekning);
    }
}
