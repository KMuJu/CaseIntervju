/* (C)2024 */
package com.KMuJu.CaseIntervju.service;

import com.KMuJu.CaseIntervju.exception.BadRequestException;
import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.model.Forsikring;
import com.KMuJu.CaseIntervju.model.ForsikringSammenligner;
import com.KMuJu.CaseIntervju.model.Sammenligning;
import com.KMuJu.CaseIntervju.repository.ForsikringRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ForsikringService
 */
@Service
public class ForsikringService {

    @Autowired
    private ForsikringRepository forsikringRepository;

    public ForsikringService() {}

    public Forsikring createForsikring(Forsikring forsikring) {
        if (forsikring == null) {
            throw new BadRequestException("Forsikring kan ikke være null");
        }
        return forsikringRepository.save(forsikring);
    }

    public List<Forsikring> getForsikringer() {
        return forsikringRepository.findAll();
    }

    /**
     * Returns a forsikring that covers every dekning in dekninger and the price is less than the max price.
     * If max_pris is -1, we can ignore the price. This is done by setting the price to the highest int value.
     *
     * @param max_Pris
     * @param dekninger
     * @return Anbefalt forsikring
     */
    public Forsikring getAnbefaling(int max_Pris, List<Dekning> dekninger) {
        if (max_Pris == -1) {
            max_Pris = Integer.MAX_VALUE;
        }
        final int maxPris = max_Pris;
        List<Forsikring> forsikringer = forsikringRepository.findAll();
        Forsikring anbefaling = forsikringer.stream()
                .filter(f -> f.getPris() < maxPris
                        && dekninger.stream().filter(f.getDekninger()::contains).toArray().length == dekninger.size())
                .sorted((a, b) -> Integer.compare(maxPris - a.getPris(), maxPris - b.getPris()))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Ingen forsikring passer med krav og koster mindre enn maxpris"));

        return anbefaling;
    }

    public Sammenligning getSammenligning(Long a_id, Long b_id) {
        if (a_id == null || b_id == null) {
            throw new BadRequestException("Ingen av id-ene kan være null");
        }

        Forsikring a = forsikringRepository.findById(a_id)
            .orElseThrow(() -> new BadRequestException("Id 1 finnes ikke"));

        Forsikring b = forsikringRepository.findById(b_id)
            .orElseThrow(() -> new BadRequestException("Id 2 finnes ikke"));

        return ForsikringSammenligner.Compare(a, b);
    }
}
