public class TestPlanet {
    static Planet p1 = new Planet(4,6,34,56,2.3e-30,null);
    static Planet p2 = new Planet(56,89,43,77,2.2e-18,null);

    public static void main(String[] args) {
        double force = p1.calcForceExertedBy(p2);
        System.out.println(force);
    }
}
