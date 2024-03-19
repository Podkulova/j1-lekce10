package cz.czechitas.lekce10.operace;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class CisloPiTest {
    private final CisloPi cisloPi = new CisloPi(3.1415927d);

    @Test
    void setA() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> cisloPi.setA(1)
        );
    }

    @Test
    void setB() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> cisloPi.setB(1)
        );
    }


    @Test
    void getPocetOperandu() {
        int pocetOperandu = cisloPi.getPocetOperandu();

        assertEquals(0, pocetOperandu);
    }

    @Test
    void vypocet() {
        String vysledek = cisloPi.vypocet();

        assertEquals("π = 3.1415927", vysledek);
    }

}
