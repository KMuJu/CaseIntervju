/* (C)2024 */
package com.KMuJu.CaseIntervju.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KMuJu.CaseIntervju.exception.BadRequestException;
import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.model.Forsikring;
import com.KMuJu.CaseIntervju.model.Sammenligning;
import com.KMuJu.CaseIntervju.service.ForsikringService;

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

    /**
     * Gir en anbefaling basert på parametre i url.
     *
     * @param maxPris - maks pris en anbefaling kan ha
     * @param krav - krav til anbefalingen
     * @return Forsikring - anbefalt forsikring
     */
    @GetMapping("/anbefaling")
    public Forsikring getMethodName(
            @RequestParam(name = "maxpris", defaultValue = "-1") int maxPris, @RequestParam List<Dekning> krav) {
        Forsikring f = forsikringService.getAnbefaling(maxPris, krav);
        return f;
    }

    @GetMapping("/sammenlign")
    public Sammenligning sammenlignForsikringer(@RequestParam(name = "id") List<Long> forsikring_ids) {
        if (forsikring_ids.size() != 2) {
            throw new BadRequestException("Kan kun sammenligne to forsikringer");
        }
        Long a_id = forsikring_ids.get(0);
        Long b_id = forsikring_ids.get(1);

        Sammenligning f = forsikringService.getSammenligning(a_id, b_id);
        return f;
    }

    /**
     * # Sikkerhet
     *
     * Denne må ha strenge tilgangskrav
     *
     * @param forsikring ligger i body av requesten som en json
     *
     */
    @PutMapping("admin/forsikring")
    public Forsikring putForsikring(@RequestBody Forsikring forsikring) {
        Forsikring f = forsikringService.createForsikring(forsikring);
        return f;
    }
}
