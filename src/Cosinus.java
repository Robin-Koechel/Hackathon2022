
public class Cosinus extends TrigonometricFunctions {

	public Cosinus(double c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Function derivative() {
		Function f = new Sinus(getCoefficient() *-1);
		f.setX(this.getX());
		ConnectTwoFunctions c= new ConnectTwoFunctions(f, getX().derivative(), '*');
		return f;
	}
	@Override
	public double getY(double x) {
		return getCoefficient()* Math.cos(getX().getY(x));
	}

	public String toString() {
		String ausgabe = "(" + getCoefficient();
		ausgabe += "*Cos";
		ausgabe += getX().toString()+ "";
		return ausgabe;
	}

}
