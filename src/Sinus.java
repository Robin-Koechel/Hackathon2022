
public class Sinus extends TrigonometricFunctions {

	public Sinus(double c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Function derivative() {
		Function f = new Cosinus(getCoefficient());
		ConnectTwoFunctions c = new  ConnectTwoFunctions(f, getX().derivative(), '*');
		return c;
	}
	
	@Override
	public double getY(double x) {
		return getCoefficient()* Math.sin(getX().getY(x));
	}

}
