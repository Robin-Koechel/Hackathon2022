
public class ConnectTwoFunctions extends Function {
	private Function f1;
	private Function f2;
	private char connector;
	public ConnectTwoFunctions(Function f1, Function f2, char c) {
		this.f1 = f1;
		this.f2 = f2;
		connector = c;
	}
	public Function getFunc1() {
		return f1;
	}
	public Function getFunc2() {
		return f2;
	}
	public char getConnetor() {
		return connector;
	}
	@Override
	public Function derivative() {
		if(connector == '*') {
			//u*v = u'*v + u*v'
			Function u = f1;
			Function v = f2;
			Function uA= f1.derivative();
			Function vA = f2.derivative();
			ConnectTwoFunctions leftSide = new ConnectTwoFunctions(uA, v, '*');
			ConnectTwoFunctions rightSide = new ConnectTwoFunctions(u,vA,  '*');
			ConnectTwoFunctions all = new ConnectTwoFunctions(leftSide, rightSide,'+');
			return all;
		}
		else {
			ConnectTwoFunctions summand =  new ConnectTwoFunctions(f1.derivative(), f2.derivative(), '+');
			return summand;
		}
	}
	
	@Override
	public double getY(double x) {
		if(connector == '*') {
			return f1.getY(x)* f2.getY(x);
		}
		else {
			double df1 = f1.getY(x);
			double df2 = f2.getY(x);

			return df1 + df2;
		}
	}
	@Override
	public void setX(Function f) {
		f1.setX(f);
		f2.setX(f);
		
	}
	@Override
	public Function getX() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ausgabe = "";
		ausgabe += connector;
		return ausgabe;
	}
	
}
