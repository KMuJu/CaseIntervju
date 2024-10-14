/* (C)2024 */
package com.KMuJu.CaseIntervju.controller;

import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.model.Forsikring;
import com.KMuJu.CaseIntervju.service.ForsikringService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


enum Krav {
    JA,
    NEI
}

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
    public List<Forsikring> getForsikring() {
        return forsikringService.getForsikringer();
    }

    @PutMapping("/forsikring")
    public void putForsikring(@RequestBody Forsikring forsikring) {
        forsikringService.createForsikring(forsikring);
    }

    @GetMapping("/anbefaling")
    public Forsikring getMethodName(@RequestParam int pris, @RequestParam List<Dekning> krav) {
        return forsikringService.getAnbefaling(pris, krav);
    }
}
