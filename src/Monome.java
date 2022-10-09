
public class Monome extends Function{
	private double coefficient;
	private double expo;
	private Function x;
	
	public double getExpo() {
		return expo;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public Function getX() {
		return x;
	}
	public Monome(double expo,double c) {
		this.expo = expo;
		coefficient =  c;
	}
	@Override
	public Function derivative() {
		
		if(expo != 0) {
			Function f = new Monome(expo-1,coefficient * expo );
			ConnectTwoFunctions c = new ConnectTwoFunctions(f, x.derivative(), '*');
			return c;
		}
		else {
			Function f = new Monome(1,0);
			return  f;
		}
		
	}
	@Override
	public double getY(double x) {
		return getCoefficient()* Math.pow(this.x.getY(x),expo);
	}
	
	
}
