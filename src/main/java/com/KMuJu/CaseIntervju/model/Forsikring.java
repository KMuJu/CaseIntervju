/* (C)2024 */
package com.KMuJu.CaseIntervju.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Dekning
 */
@Entity
public class Forsikring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String navn;

    @Column(nullable = false)
    private String beskrivelse;

    @ElementCollection
    private List<Long> inkluderer = new ArrayList<>();

    @Column(nullable = false)
    private int pris;

    @ElementCollection(targetClass = Dekning.class)
    @Enumerated(EnumType.STRING)  // Store enum as strings in the DB
    @CollectionTable(name = "forsikring_dekninger", joinColumns = @JoinColumn(name = "forsikring_id"))
    @Column(name = "dekning")
    private List<Dekning> dekninger = new ArrayList<>();


	public Forsikring() {}

    public Forsikring(String navn, String beskrivelse, List<Long> inkluderer, List<Dekning> dekninger, int pris) {
        // TODO: Verifikasjon av parametre
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        if (inkluderer != null) {
            this.inkluderer.addAll(inkluderer);
        }
        if (dekninger != null) {
            this.dekninger.addAll(dekninger);
        }
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public List<Long> getInkluderer() {
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

    public List<Dekning> getDekninger() {
		return dekninger;
	}

	public void setDekninger(List<Dekning> dekninger) {
		this.dekninger = dekninger;
	}
}
