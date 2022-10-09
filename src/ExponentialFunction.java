
public class ExponentialFunction extends Function{
	private double base;
	private double coefficient;
	
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
		setX(neutralElement);

	}
	
	
	public Function getEAsBasis() {
		return this;
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
	@Override
	public void setX(Function f) {
		x = f;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ausgabe= "(";
		ausgabe+= coefficient;
		ausgabe += "*e^(";
		ausgabe += x.toString()+ "))";
	
		return ausgabe;
	}
	
	
}
