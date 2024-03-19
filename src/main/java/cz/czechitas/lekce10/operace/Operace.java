package cz.czechitas.lekce10.operace;

/**
 * Rozhraní pro operace prováděné na jednoduché kalkulačce.
 * @author Filip Jirsák
 */
public interface Operace {
    /**
     * Nastaví první operand zvolené operace.
     *
     * @param a
     *
     * @throws UnsupportedOperationException V případě, kdy operace nepodporuje operandy (např. výpis konstanty).
     */
    void setA(int a);

    /**
     * Vrací první operand zvolené operace.
     *
     * @return
     */
    int getA();

    /**
     * Nastaví druhý operand zvolené operace.
     *
     * @param b
     *
     * @throws UnsupportedOperationException V případě, kdy operace nepodporuje druhý operand.
     */
    void setB(int b);

    /**
     * Vrací druhý operand zvolené operace.
     *
     * @return
     */
    int getB();

    /**
     * Vrací počet operandů, které operace vyžaduje.
     *
     * @return Počet operandů, {@code 0}, pokud operace operandy nemá.
     */
    int getPocetOperandu();

    /**
     * Vypočítá výsledek operace a vrací celý výpočet jako {@code String}.
     *
     * @return Celý výpočet včetně operandů a výsledku.
     */
    String vypocet();
}
