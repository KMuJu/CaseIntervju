package com.KMuJu.CaseIntervju.model;

/**
 * ForsikringSammenligner
 */
public class ForsikringSammenligner {
    /**
     * @param a
     * @param b
     * @return Sammenligning between a and b
     */
    public static Sammenligning Compare(Forsikring a, Forsikring b) {
        var prisForskjell = Math.abs(a.getPris() - b.getPris());
        var begge = a.getDekninger().stream().filter(b.getDekninger()::contains).toList();
        var kun_a = a.getDekninger().stream()
                .filter(d -> !begge.contains(d))
                .toList();
        var kun_b = b.getDekninger().stream()
                .filter(d -> !begge.contains(d))
                .toList();
        return new Sammenligning(a, b, begge, kun_a, kun_b, prisForskjell);
    }
}
