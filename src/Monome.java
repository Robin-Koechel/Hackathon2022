
public class Monome extends Function{
	private double coefficient;
	private double expo;
	
	
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
		setX(neutralElement);
	}
	public Monome(double expo,double c, boolean neutralElement) {
		this.expo = expo;
		coefficient =  c;
	}
	@Override
	public Function derivative() {
		
		if(expo != 0) {
			if(this != neutralElement) {
				Function f = new Monome(expo-1,coefficient * expo );
				ConnectTwoFunctions c = new ConnectTwoFunctions(f, x.derivative(), '*');
				return c;
			}
			else{
				return new Monome(0, 1);
			}
			
		}
		else {
			Function f = new Monome(1,0);
			return  f;
		}
		
	}
	@Override
	public double getY(double x) {
		if(expo == 0) {
			if(this == neutralElement) {
				return x;
			}
			else {
				return getCoefficient()* Math.pow(this.x.getY(x),expo);

			}
		}
		else {
			if(coefficient != 0) {
				return 1;
			}
			else {
				return 0;
			}
			
		}

		
	}
	@Override
	public void setX(Function f) {
		x = f;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(this.getExpo() != 0) {
			if(this == neutralElement) {
				return "x";
			}
			String ausgabe = "(";
			ausgabe += getCoefficient() + "*"+getX().toString() +"^("+ expo+ "))";
			return ausgabe;
		}
		else {
			String ausgabe = "";
			ausgabe += coefficient;
			return ausgabe;
		}
		
	}
	
	
}
