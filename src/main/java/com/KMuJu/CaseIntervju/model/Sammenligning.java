package com.KMuJu.CaseIntervju.model;

import java.util.List;

/**
 * Sammenligning
 */
public record Sammenligning (Forsikring a, Forsikring b, List<Dekning> begge, List<Dekning> kun_a, List<Dekning> kun_b, int prisforskjell) { }
