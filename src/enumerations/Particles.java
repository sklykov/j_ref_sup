package enumerations;

/**
 * Demo of using enums along with a class constructor - simple representation of elementary particles
 */

enum Particles {
    NEUTRON(0, 1, 0.5), PROTON(1, 1, 0.5), ELECTRON(-1, 0, 0.5);

    int charge, weight; double spin;
    Particles(int charge, int weight, double spin){
        this.charge = charge; this.spin = spin; this.weight = weight;
    }
}
