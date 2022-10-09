
public class ExponentialFunction extends Function{
	private double base;
	private double coefficient;
	private Function x;
	
	public double getBase() {
		return base;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public Function getX() {
		return x;
	}
	public ExponentialFunction(double b,double c) {
		base =b;
		coefficient =  c;
	}
	
	public static ExponentialFunction getARandomExpoFunc() {
		
	}
	public Function getEAsBasis() {
		
	}
	
	@Override
	public Function derivative() {
		Function f = getEAsBasis();
		ConnectTwoFunctions c = new ConnectTwoFunctions(f, x.derivative(), '*');
		return f;
	}
	@Override
	public double getY(double x) {
		return getCoefficient()* Math.pow(base, this.x.getY(x));
	}
	
	
}
