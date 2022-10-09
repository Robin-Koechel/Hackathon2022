package Parser;

public class Konstante implements Ausdruck{
    private double wert;

    public Konstante(double wert){
        this.wert = wert;
    }

    public double auswerten(){
        return wert;
    }
}
