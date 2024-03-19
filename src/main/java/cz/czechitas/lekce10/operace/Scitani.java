package cz.czechitas.lekce10.operace;

/**
 * Operace sčítání dvou čísel.
 *
 * @author Filip Jirsák
 */
public class Scitani implements Operace {
    private int a;
    private int b;

    @Override
    public void setA(int a) {
        this.a = a;
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int getPocetOperandu() {
        return 2;
    }

    @Override
    public String vypocet() {
        int vysledek = a + b;
        return "%d + %d = %d".formatted(a, b, vysledek);
    }
}
