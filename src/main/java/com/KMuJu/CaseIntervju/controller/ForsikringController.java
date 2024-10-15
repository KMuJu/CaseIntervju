/* (C)2024 */
package com.KMuJu.CaseIntervju.controller;

import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.model.Forsikring;
import com.KMuJu.CaseIntervju.service.ForsikringService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * I produksjon så kan dette være knyttet til en bruker istedenfor url parametre, og da må man ha en auth.
     * Dette gjør at man kan gi bedre anbefaling fordi det er basert på mer informasjon.
     * Hvis man lekker data om brukere på grunn av et angrep så vil dette være dårllig personvern.
     * Man må da vekte fordelene mot ulempene ved å koble informasjonen opp mot enkeltpersoner.
     *
     * @param maxPris - maks pris en anbefaling kan ha
     * @param krav - krav til anbefalingen
     * @return Forsikring - anbefalt forsikring
     */
    @GetMapping("/anbefaling")
    public Forsikring getMethodName(
            @RequestParam(name = "maxpris", defaultValue = "-1") int maxPris, @RequestParam List<Dekning> krav) {
        return forsikringService.getAnbefaling(maxPris, krav);
    }

    @GetMapping("/sammenlign")
    public ResponseEntity<Object> sammenlignForsikringer(@RequestParam(name = "id") List<Long> forsikring_ids) {
        if (forsikring_ids.size() != 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kan kun sammenligne to forsikringer");
        }
        Long a_id = forsikring_ids.get(0);
        Long b_id = forsikring_ids.get(1);
        if (a_id == null || b_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ingen av id-ene kan være null");
        }

        return ResponseEntity.ok(forsikringService.getSammenligning(a_id, b_id));
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
    public void putForsikring(@RequestBody Forsikring forsikring) {
        forsikringService.createForsikring(forsikring);
    }
}
