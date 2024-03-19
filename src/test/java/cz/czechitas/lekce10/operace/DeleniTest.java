package cz.czechitas.lekce10.operace;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class DeleniTest {
    private static final int OVERSIZE_VALUE = 100_000_000;

    @Nested
    class Setters {
        @Test
        void positive() {
            Deleni deleni = new Deleni();
            deleni.setA(5);
            deleni.setB(23);

            assertAll(
                    () -> assertEquals(5, deleni.getA()),
                    () -> assertEquals(23, deleni.getB())
            );
        }

        @Test
        void negative() {
            Deleni deleni = new Deleni();
            deleni.setA(-12);
            deleni.setB(-47);

            assertAll(
                    () -> assertEquals(-12, deleni.getA()),
                    () -> assertEquals(-47, deleni.getB())
            );
        }

        @Test
        void zero() {
            Deleni deleni = new Deleni();
            deleni.setA(0);

            assertEquals(0, deleni.getA());
            assertThrows(
                    IllegalArgumentException.class,
                    () -> deleni.setB(0)
            );
        }

        @Test
        void tooBigPositive() {
            Deleni deleni = new Deleni();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> deleni.setA(OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> deleni.setB(OVERSIZE_VALUE)
                    )
            );
        }

        @Test
        void tooBigNegative() {
            Deleni deleni = new Deleni();
            assertAll(
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> deleni.setA(-OVERSIZE_VALUE)
                    ),
                    () -> assertThrows(
                            IllegalArgumentException.class,
                            () -> deleni.setB(-OVERSIZE_VALUE)
                    )
            );
        }

    }

    @Test
    void getPocetOperandu() {
        Deleni deleni = new Deleni();
        int pocetOperandu = deleni.getPocetOperandu();

        assertEquals(2, pocetOperandu);
    }

    @Nested
    class Vypocet {
        @Test
        void bothPositive() {
            Deleni deleni = new Deleni();
            deleni.setA(23);
            deleni.setB(5);
            String vysledek = deleni.vypocet();

            assertEquals("23 ÷ 5 = 4", vysledek);
        }

        @Test
        void bothNegative() {
            Deleni deleni = new Deleni();
            deleni.setA(-47);
            deleni.setB(-12);
            String vysledek = deleni.vypocet();

            assertEquals("-47 ÷ -12 = 3", vysledek);
        }

        @Test
        void positiveAndNegative() {
            Deleni deleni = new Deleni();
            deleni.setA(23);
            deleni.setB(-5);
            String vysledek = deleni.vypocet();

            assertEquals("23 ÷ -5 = -4", vysledek);
        }

        @Test
        void negativeAndPositive() {
            Deleni deleni = new Deleni();
            deleni.setA(-23);
            deleni.setB(5);
            String vysledek = deleni.vypocet();

            assertEquals("-23 ÷ 5 = -4", vysledek);
        }

        @Test
        void doubleZero() {
            Deleni deleni = new Deleni();
            deleni.setA(0);

            assertThrows(
                    ArithmeticException.class,
                    () -> deleni.vypocet()
            );
        }

        @Test
        void zeroAndPositive() {
            Deleni deleni = new Deleni();
            deleni.setA(0);
            deleni.setB(23);
            String vysledek = deleni.vypocet();

            assertEquals("0 ÷ 23 = 0", vysledek);
        }

        @Test
        void positiveAndZero() {
            Deleni deleni = new Deleni();
            deleni.setA(5);

            assertThrows(
                    ArithmeticException.class,
                    () -> deleni.vypocet()
            );
        }

        @Test
        void zeroAndNegative() {
            Deleni deleni = new Deleni();
            deleni.setA(0);
            deleni.setB(-23);
            String vysledek = deleni.vypocet();

            assertEquals("0 ÷ -23 = 0", vysledek);
        }

        @Test
        void negativeAndZero() {
            Deleni deleni = new Deleni();
            deleni.setA(-5);

            assertThrows(
                    ArithmeticException.class,
                    () -> deleni.vypocet()
            );
        }

        @Test
        void reminderOne() {
            Deleni deleni = new Deleni();
            deleni.setA(41);
            deleni.setB(5);
            String vysledek = deleni.vypocet();

            assertEquals("41 ÷ 5 = 8", vysledek);
        }


        @Test
        void reminderZero() {
            Deleni deleni = new Deleni();
            deleni.setA(40);
            deleni.setB(5);
            String vysledek = deleni.vypocet();

            assertEquals("40 ÷ 5 = 8", vysledek);
        }


        @Test
        void reminderMinusOne() {
            Deleni deleni = new Deleni();
            deleni.setA(39);
            deleni.setB(5);
            String vysledek = deleni.vypocet();

            assertEquals("39 ÷ 5 = 7", vysledek);
        }


    }
}
