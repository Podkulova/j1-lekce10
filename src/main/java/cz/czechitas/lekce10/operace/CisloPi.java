package cz.czechitas.lekce10.operace;

/**
 * Operace vracející číslo π.
 *
 * @author Filip Jirsák
 */
public class CisloPi implements Operace {
    private final String cisloPi;

    public CisloPi(double cisloPi) {
        this.cisloPi = Double.toString(cisloPi);
    }

    @Override
    public void setA(int a) {
    }

    @Override
    public int getA() {
        return 0;
    }

    @Override
    public void setB(int b) {
    }

    @Override
    public int getB() {
        return 0;
    }

    @Override
    public int getPocetOperandu() {
        return 0;
    }

    @Override
    public String vypocet() {
        return "π = %s".formatted(cisloPi);
    }
}
