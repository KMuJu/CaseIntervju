package com.KMuJu.CaseIntervju.model;

/**
 * Forsikring
 */
public class Forsikring {

    private final String navn;
    private final String beskrivelse;
    private final String[] inkluderer;
    private final int pris;

    public Forsikring(String navn, String beskrivelse, String[] inkluderer, int pris){
        // TODO: Verifikasjon av parametre
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.inkluderer = inkluderer;
        this.pris = pris;
    }

	public String getNavn() {
		return navn;
	}
	public String getBeskrivelse() {
		return beskrivelse;
	}
	public String[] getInkluderer() {
		return inkluderer;
	}
	public int getPris() {
		return pris;
	}
    
}
