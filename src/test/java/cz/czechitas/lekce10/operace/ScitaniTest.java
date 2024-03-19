package cz.czechitas.lekce10.operace;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class ScitaniTest {
    private static final int OVERSIZE_VALUE = 100_000_000;

    @Nested
    class Setters {
        @Test
        void positive() {
            Scitani scitani = new Scitani();
            scitani.setA(5);
            scitani.setB(23);

            assertAll(
                    () -> assertEquals(5, scitani.getA()),
                    () -> assertEquals(23, scitani.getB())
            );
        }

        @Test
        void negative() {
            Scitani scitani = new Scitani();
            scitani.setA(-12);
            scitani.setB(-47);

            assertAll(
                    () -> assertEquals(-12, scitani.getA()),
                    () -> assertEquals(-47, scitani.getB())
            );
        }

        @Test
        void zero() {
            Scitani scitani = new Scitani();
            scitani.setA(0);
            scitani.setB(0);

            assertAll(
                    () -> assertEquals(0, scitani.getA()),
                    () -> assertEquals(0, scitani.getB())
            );
        }

        @Test
        void tooBigPositive() {
            Scitani scitani = new Scitani();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> scitani.setA(OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> scitani.setB(OVERSIZE_VALUE)
                    )
            );
        }

        @Test
        void tooBigNegative() {
            Scitani scitani = new Scitani();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> scitani.setA(-OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> scitani.setB(-OVERSIZE_VALUE)
                    )
            );
        }

    }

    @Test
    void getPocetOperandu() {
        Scitani scitani = new Scitani();
        int pocetOperandu = scitani.getPocetOperandu();

        assertEquals(2, pocetOperandu);
    }

    @Nested
    class Vypocet {
        @Test
        void bothPositive() {
            Scitani scitani = new Scitani();
            scitani.setA(5);
            scitani.setB(23);
            String vysledek = scitani.vypocet();

            assertEquals("5 + 23 = 28", vysledek);
        }

        @Test
        void bothNegative() {
            Scitani scitani = new Scitani();
            scitani.setA(-12);
            scitani.setB(-47);
            String vysledek = scitani.vypocet();

            assertEquals("-12 + -47 = -59", vysledek);
        }

        @Test
        void positiveAndNegative() {
            Scitani scitani = new Scitani();
            scitani.setA(5);
            scitani.setB(-23);
            String vysledek = scitani.vypocet();

            assertEquals("5 + -23 = -18", vysledek);
        }

        @Test
        void negativeAndPositive() {
            Scitani scitani = new Scitani();
            scitani.setA(-5);
            scitani.setB(23);
            String vysledek = scitani.vypocet();

            assertEquals("-5 + 23 = 18", vysledek);
        }

        @Test
        void doubleZero() {
            Scitani scitani = new Scitani();
            scitani.setA(0);
            scitani.setB(0);
            String vysledek = scitani.vypocet();

            assertEquals("0 + 0 = 0", vysledek);
        }

        @Test
        void zeroAndPositive() {
            Scitani scitani = new Scitani();
            scitani.setA(0);
            scitani.setB(23);
            String vysledek = scitani.vypocet();

            assertEquals("0 + 23 = 23", vysledek);
        }

        @Test
        void positiveAndZero() {
            Scitani scitani = new Scitani();
            scitani.setA(5);
            scitani.setB(0);
            String vysledek = scitani.vypocet();

            assertEquals("5 + 0 = 5", vysledek);
        }

        @Test
        void zeroAndNegative() {
            Scitani scitani = new Scitani();
            scitani.setA(0);
            scitani.setB(-23);
            String vysledek = scitani.vypocet();

            assertEquals("0 + -23 = -23", vysledek);
        }

        @Test
        void negativeAndZero() {
            Scitani scitani = new Scitani();
            scitani.setA(-5);
            scitani.setB(0);
            String vysledek = scitani.vypocet();

            assertEquals("-5 + 0 = -5", vysledek);
        }

        @Test
        void tooBigPositiveResult() {
            Scitani scitani = new Scitani();
            scitani.setA(90_000_000);
            scitani.setB(90_000_000);

            assertThrows(
                    ArithmeticException.class,
                    () -> scitani.vypocet()
            );
        }

        @Test
        void tooBigNegativeResult() {
            Scitani scitani = new Scitani();
            scitani.setA(-90_000_000);
            scitani.setB(-90_000_000);

            assertThrows(
                    ArithmeticException.class,
                    () -> scitani.vypocet()
            );
        }
    }
}
