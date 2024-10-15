package com.KMuJu.CaseIntervju.model;

import java.util.List;

/**
 * Stores data about a sammenligning of forsikring a and b.
 *
 * @param a
 * @param b
 * @param begge
 * @param kun_a
 * @param kun_b
 * @param prisforskjell
 */
public record Sammenligning(
        Forsikring a, Forsikring b, List<Dekning> begge, List<Dekning> kun_a, List<Dekning> kun_b, int prisforskjell) {}
