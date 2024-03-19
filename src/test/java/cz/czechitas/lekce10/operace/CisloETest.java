package cz.czechitas.lekce10.operace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Filip Jirsák
 */
class CisloETest {
    private final CisloE cisloE = new CisloE(2.7182818d);

    @Test
    void setA() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> cisloE.setA(1)
        );
    }

    @Test
    void setB() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> cisloE.setB(1)
        );
    }


    @Test
    void getPocetOperandu() {
        int pocetOperandu = cisloE.getPocetOperandu();

        assertEquals(0, pocetOperandu);
    }

    @Test
    void vypocet() {
        String vysledek = cisloE.vypocet();

        assertEquals("e = 2.7182818", vysledek);
    }

}
