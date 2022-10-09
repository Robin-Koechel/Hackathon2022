
public class Sinus extends TrigonometricFunctions {

	public Sinus(double c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Function derivative() {
		Function f = new Cosinus(getCoefficient());
		f.setX(this.getX());
		ConnectTwoFunctions c = new  ConnectTwoFunctions(f, getX().derivative(), '*');
		return c;
	}
	
	@Override
	public double getY(double x) {
		return getCoefficient()* Math.sin(getX().getY(x));
	}
	@Override
	public String toString() {
		String ausgabe = "(" + getCoefficient();
		ausgabe += "*Sin";
		ausgabe += getX().toString()+ "";
		return ausgabe;
	}
}
