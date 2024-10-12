package com.KMuJu.CaseIntervju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.repository.DekninRepository;
/**
 * ForsikringService
 */
@Service
public class DekningService {

    private Dekning[] forsikringer;

    @Autowired
    private DekninRepository dekninRepository;

    
	public DekningService() {
	}

    public Dekning createDekning(Dekning dekning){
        return dekninRepository.save(dekning);
    }

	public List<Dekning> getDekninger() {
		return dekninRepository.findAll();
	}
}
