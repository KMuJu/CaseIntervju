package com.KMuJu.CaseIntervju;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.KMuJu.CaseIntervju.model.Dekning;
import com.KMuJu.CaseIntervju.model.Forsikring;
import com.KMuJu.CaseIntervju.model.ForsikringSammenligner;
import com.KMuJu.CaseIntervju.model.Sammenligning;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SammenligningsTest
 */
@SpringBootTest
class SammenligningsTest {

    @Test
    void testSammenligning() {
        List<Dekning> begge = List.of(Dekning.LEIEBIL, Dekning.MASKINSKADE);
        List<Dekning> kun_a = List.of(Dekning.VEIHJELP);
        List<Dekning> kun_b = List.of(Dekning.ANSVAR);
        List<Dekning> a_dekning = new ArrayList<>(begge);
        a_dekning.addAll(kun_a);
        List<Dekning> b_dekning = new ArrayList<>(begge);
        b_dekning.addAll(kun_b);
        Forsikring a = new Forsikring("A", "aa", new ArrayList<>(), a_dekning, 200);
        Forsikring b = new Forsikring("B", "bb", new ArrayList<>(), b_dekning, 100);
        Sammenligning expected = new Sammenligning(a, b, begge, kun_a, kun_b, 100);

        Sammenligning output = ForsikringSammenligner.Compare(a, b);

        assertEquals(expected, output);
    }
}
