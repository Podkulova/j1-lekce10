package cz.czechitas.lekce10.operace;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class OdcitaniTest {
    private static final int OVERSIZE_VALUE = 100_000_000;

    @Nested
    class Setters {
        @Test
        void positive() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(5);
            odcitani.setB(23);

            assertAll(
                    () -> assertEquals(5, odcitani.getA()),
                    () -> assertEquals(23, odcitani.getB())
            );
        }

        @Test
        void negative() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(-12);
            odcitani.setB(-47);

            assertAll(
                    () -> assertEquals(-12, odcitani.getA()),
                    () -> assertEquals(-47, odcitani.getB())
            );
        }

        @Test
        void zero() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(0);
            odcitani.setB(0);

            assertAll(
                    () -> assertEquals(0, odcitani.getA()),
                    () -> assertEquals(0, odcitani.getB())
            );
        }

        @Test
        void tooBigPositive() {
            Odcitani odcitani = new Odcitani();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> odcitani.setA(OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> odcitani.setB(OVERSIZE_VALUE)
                    )
            );
        }

        @Test
        void tooBigNegative() {
            Odcitani odcitani = new Odcitani();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> odcitani.setA(-OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> odcitani.setB(-OVERSIZE_VALUE)
                    )
            );
        }

    }

    @Test
    void getPocetOperandu() {
        Odcitani odcitani = new Odcitani();
        int pocetOperandu = odcitani.getPocetOperandu();

        assertEquals(2, pocetOperandu);
    }

    @Nested
    class Vypocet {
        @Test
        void bothPositive() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(5);
            odcitani.setB(23);
            String vysledek = odcitani.vypocet();

            assertEquals("5 - 23 = -18", vysledek);
        }

        @Test
        void bothNegative() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(-12);
            odcitani.setB(-47);
            String vysledek = odcitani.vypocet();

            assertEquals("-12 - -47 = 35", vysledek);
        }

        @Test
        void positiveAndNegative() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(5);
            odcitani.setB(-23);
            String vysledek = odcitani.vypocet();

            assertEquals("5 - -23 = 28", vysledek);
        }

        @Test
        void negativeAndPositive() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(-5);
            odcitani.setB(23);
            String vysledek = odcitani.vypocet();

            assertEquals("-5 - 23 = -28", vysledek);
        }

        @Test
        void doubleZero() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(0);
            odcitani.setB(0);
            String vysledek = odcitani.vypocet();

            assertEquals("0 - 0 = 0", vysledek);
        }

        @Test
        void zeroAndPositive() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(0);
            odcitani.setB(23);
            String vysledek = odcitani.vypocet();

            assertEquals("0 - 23 = -23", vysledek);
        }

        @Test
        void positiveAndZero() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(5);
            odcitani.setB(0);
            String vysledek = odcitani.vypocet();

            assertEquals("5 - 0 = 5", vysledek);
        }

        @Test
        void zeroAndNegative() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(0);
            odcitani.setB(-23);
            String vysledek = odcitani.vypocet();

            assertEquals("0 - -23 = 23", vysledek);
        }

        @Test
        void negativeAndZero() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(-5);
            odcitani.setB(0);
            String vysledek = odcitani.vypocet();

            assertEquals("-5 - 0 = -5", vysledek);
        }

        @Test
        void tooBigPositiveResult() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(20_000_000);
            odcitani.setB(-90_000_000);

            assertThrows(
                    ArithmeticException.class,
                    () -> odcitani.vypocet()
            );
        }

        @Test
        void tooBigNegativeResult() {
            Odcitani odcitani = new Odcitani();
            odcitani.setA(-20_000_000);
            odcitani.setB(90_000_000);

            assertThrows(
                    ArithmeticException.class,
                    () -> odcitani.vypocet()
            );
        }
    }
}
