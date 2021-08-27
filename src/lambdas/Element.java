package lambdas;

public class Element {

    private String shortName; private int atomicWeight; private int chargeNumber;

    public Element(String shortName, int atomicWeight, int chargeNumber) {
        this.shortName = shortName; this.atomicWeight = atomicWeight; this.chargeNumber = chargeNumber;
    }

    public int getAtomicWeight() {
        return atomicWeight;
    }

    public int getChargeNumber() {
        return chargeNumber;
    }

    public String getShortName() {
        return shortName;
    }
}
