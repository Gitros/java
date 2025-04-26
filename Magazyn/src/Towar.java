public class Towar {

    private String nazwa;
    private double cena;

    public Towar(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return nazwa + ", " + cena + " zł";
    }
}
