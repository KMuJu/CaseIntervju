package com.KMuJu.CaseIntervju.service;

import org.springframework.stereotype.Service;

import com.KMuJu.CaseIntervju.model.Forsikring;
/**
 * ForsikringService
 */
@Service
public class ForsikringService {

    private Forsikring[] forsikringer;

    
	public ForsikringService() {
		this.forsikringer = new Forsikring[]{
            new Forsikring("Toppkasko", "", new String[]{}, 0),
            new Forsikring("Kasko med leiebil",
                "En forsikring som passer de fleste biler. Dekker for det meste av skader, også de du selv er ansvarlig for.",
                new String[]{"minikasko", "ansvar"},
                117900),
            new Forsikring("Kasko", "", new String[]{}, 0),
            new Forsikring("Minikasko", "", new String[]{}, 0),
            new Forsikring("Ansvar", "", new String[]{}, 0),
        };
	}


	public Forsikring[] getForsikringer() {
		return forsikringer;
	}
}
