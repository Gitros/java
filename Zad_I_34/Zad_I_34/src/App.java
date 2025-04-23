public class App {
    public static void main(String[] args) {
        double[] wspolrzedne = {4.0, 5.0};
        Wektor2D wektor = new Wektor2D(wspolrzedne);

        System.out.println("Długość wektora: " + wektor.dlugosc());
    }
}


class Wektor {

    protected double[] dane;

    public Wektor(double[] dane) {
        this.dane = dane;
    }
}


class Wektor2D extends Wektor {

    public Wektor2D(double[] dane) {
        super(dane);
    }

    public double dlugosc() {
        return Math.sqrt(Math.pow(dane[0], 2) + Math.pow(dane[1], 2));
    }
}
