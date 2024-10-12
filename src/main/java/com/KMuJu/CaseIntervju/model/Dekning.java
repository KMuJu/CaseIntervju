package com.KMuJu.CaseIntervju.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Dekning
 */
@Entity
public class Dekning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String navn;

	@Column(nullable = false)
    private String beskrivelse;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Dekning> inkluderer = new ArrayList<>();

    @Column(nullable = false)
    private int pris;

    public Dekning(){}

    public Dekning(String navn, String beskrivelse, List<Dekning> inkluderer, int pris){
        // TODO: Verifikasjon av parametre
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        if (inkluderer!= null) {
            this.inkluderer.addAll(inkluderer);
        }
        this.pris = pris;
    }

	public String getNavn() {
		return navn;
	}
	public String getBeskrivelse() {
		return beskrivelse;
	}
	public List<Dekning> getInkluderer() {
		return inkluderer;
	}
	public int getPris() {
		return pris;
	}

	@Override
	public String toString() {
		return navn;
	}
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
