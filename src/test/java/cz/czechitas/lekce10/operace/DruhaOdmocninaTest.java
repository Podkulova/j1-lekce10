package cz.czechitas.lekce10.operace;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class DruhaOdmocninaTest {
    private static final int OVERSIZE_VALUE = 100_000_000;

    @Nested
    class Setters {
        @Test
        void positive() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(5);

            assertEquals(5, druhaOdmocnina.getA());
        }

        @Test
        void negative() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();

            assertThrowsExactly(
                    IllegalArgumentException.class,
                    () -> druhaOdmocnina.setA(-12)
            );
        }

        @Test
        void zero() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(0);

            assertEquals(0, druhaOdmocnina.getA());
        }

        @Test
        void tooBigPositive() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> druhaOdmocnina.setA(OVERSIZE_VALUE)
            );
        }

        @Test
        void tooBigNegative() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> druhaOdmocnina.setA(-OVERSIZE_VALUE)
            );
        }

    }

    @Test
    void getPocetOperandu() {
        DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
        int pocetOperandu = druhaOdmocnina.getPocetOperandu();

        assertEquals(1, pocetOperandu);
    }

    @Nested
    class Vypocet {
        @Test
        void positiveExact() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(4);
            String vysledek = druhaOdmocnina.vypocet();

            assertEquals("√4 = 2", vysledek);
        }

        @Test
        void positiveApproximately() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(5);
            String vysledek = druhaOdmocnina.vypocet();

            assertEquals("√5 = 2", vysledek);
        }

        @Test
        void two() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(2);
            String vysledek = druhaOdmocnina.vypocet();

            assertEquals("√2 = 1", vysledek);
        }

        @Test
        void one() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(1);
            String vysledek = druhaOdmocnina.vypocet();

            assertEquals("√1 = 1", vysledek);
        }

        @Test
        void zero() {
            DruhaOdmocnina druhaOdmocnina = new DruhaOdmocnina();
            druhaOdmocnina.setA(0);
            String vysledek = druhaOdmocnina.vypocet();

            assertEquals("√0 = 0", vysledek);
        }

    }
}
