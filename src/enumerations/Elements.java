package enumerations;

/**
 * Element uses Particles enumeration for accessing some of their core properties
 */
public class Elements {
    private int coreCharge; private int weight;
    private int nProtons, nNeutrons;

    Elements(int nProtons, int nNeutrons){
        this.nNeutrons = nNeutrons; this.nProtons = nProtons;
    }

    int calculateCoreCharge(){
        this.coreCharge = 0;
        for(int i = 0; i < this.nProtons; i++){
           this.coreCharge += Particles.PROTON.charge;
        }
        return this.coreCharge;
    }

    int calculateWeight(){
        this.weight = 0;
        for(int i = 0; i < this.nProtons; i++){
            this.weight += Particles.PROTON.weight;
        }
        for(int i = 0; i < this.nNeutrons; i++){
            this.weight += Particles.NEUTRON.weight;
        }

        return this.weight;
    }



    public static void main(String[] args) {

        Elements helium = new Elements(2, 2);
        System.out.println("Core charge of helium is: " + helium.calculateCoreCharge());
        System.out.println("Weight of helium is: " + helium.calculateWeight());
    }
}
