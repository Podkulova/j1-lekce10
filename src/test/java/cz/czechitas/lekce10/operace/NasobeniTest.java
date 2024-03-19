package cz.czechitas.lekce10.operace;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class NasobeniTest {
    private static final int OVERSIZE_VALUE = 100_000_000;

    @Nested
    class Setters {
        @Test
        void positive() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(5);
            nasobeni.setB(23);

            assertAll(
                    () -> assertEquals(5, nasobeni.getA()),
                    () -> assertEquals(23, nasobeni.getB())
            );
        }

        @Test
        void negative() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(-12);
            nasobeni.setB(-47);

            assertAll(
                    () -> assertEquals(-12, nasobeni.getA()),
                    () -> assertEquals(-47, nasobeni.getB())
            );
        }

        @Test
        void zero() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(0);
            nasobeni.setB(0);

            assertAll(
                    () -> assertEquals(0, nasobeni.getA()),
                    () -> assertEquals(0, nasobeni.getB())
            );
        }

        @Test
        void tooBigPositive() {
            Nasobeni nasobeni = new Nasobeni();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> nasobeni.setA(OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> nasobeni.setB(OVERSIZE_VALUE)
                    )
            );
        }

        @Test
        void tooBigNegative() {
            Nasobeni nasobeni = new Nasobeni();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> nasobeni.setA(-OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> nasobeni.setB(-OVERSIZE_VALUE)
                    )
            );
        }

    }

    @Test
    void getPocetOperandu() {
        Nasobeni nasobeni = new Nasobeni();
        int pocetOperandu = nasobeni.getPocetOperandu();

        assertEquals(2, pocetOperandu);
    }

    @Nested
    class Vypocet {
        @Test
        void bothPositive() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(5);
            nasobeni.setB(23);
            String vysledek = nasobeni.vypocet();

            assertEquals("5 ⋅ 23 = 115", vysledek);
        }

        @Test
        void bothNegative() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(-12);
            nasobeni.setB(-47);
            String vysledek = nasobeni.vypocet();

            assertEquals("-12 ⋅ -47 = 564", vysledek);
        }

        @Test
        void positiveAndNegative() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(5);
            nasobeni.setB(-23);
            String vysledek = nasobeni.vypocet();

            assertEquals("5 ⋅ -23 = -115", vysledek);
        }

        @Test
        void negativeAndPositive() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(-5);
            nasobeni.setB(23);
            String vysledek = nasobeni.vypocet();

            assertEquals("-5 ⋅ 23 = -115", vysledek);
        }

        @Test
        void doubleZero() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(0);
            nasobeni.setB(0);
            String vysledek = nasobeni.vypocet();

            assertEquals("0 ⋅ 0 = 0", vysledek);
        }

        @Test
        void zeroAndPositive() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(0);
            nasobeni.setB(23);
            String vysledek = nasobeni.vypocet();

            assertEquals("0 ⋅ 23 = 0", vysledek);
        }

        @Test
        void positiveAndZero() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(5);
            nasobeni.setB(0);
            String vysledek = nasobeni.vypocet();

            assertEquals("5 ⋅ 0 = 0", vysledek);
        }

        @Test
        void zeroAndNegative() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(0);
            nasobeni.setB(-23);
            String vysledek = nasobeni.vypocet();

            assertEquals("0 ⋅ -23 = 0", vysledek);
        }

        @Test
        void negativeAndZero() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(-5);
            nasobeni.setB(0);
            String vysledek = nasobeni.vypocet();

            assertEquals("-5 ⋅ 0 = 0", vysledek);
        }

        @Test
        void tooBigPositiveResult() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(10_000);
            nasobeni.setB(10_000);

            assertThrows(
                    ArithmeticException.class,
                    () -> nasobeni.vypocet()
            );
        }

        @Test
        void tooBigNegativeResult() {
            Nasobeni nasobeni = new Nasobeni();
            nasobeni.setA(10_000);
            nasobeni.setB(-10_000);

            assertThrows(
                    ArithmeticException.class,
                    () -> nasobeni.vypocet()
            );
        }
    }
}
