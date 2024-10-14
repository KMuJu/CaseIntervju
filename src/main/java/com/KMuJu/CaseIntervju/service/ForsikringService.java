/* (C)2024 */
package com.KMuJu.CaseIntervju.service;

import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.model.Forsikring;
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
        return forsikringRepository.save(forsikring);
    }

    public List<Forsikring> getForsikringer() {
        return forsikringRepository.findAll();
    }

    public Forsikring getAnbefaling(int pris, List<Dekning> dekninger) {
        List<Forsikring> forsikringer = forsikringRepository.findAll();
        Forsikring anbefaling = forsikringer.stream()
            .filter(f ->
                f.getPris() > pris &&
                dekninger.stream()
                    .filter(f.getDekninger()::contains)
                    .toArray().length == dekninger.size()
            )
            .sorted((a,b) -> Integer.compare(a.getPris() - pris, b.getPris() - pris))
            .findFirst().orElse(null);

        return anbefaling;
    }
}
