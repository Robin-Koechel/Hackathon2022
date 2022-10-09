
public class TrigonometricFunctions extends Function{
	 private double coefficient;
	 
	 
	 public double getCoefficient() {
		 return coefficient;
	 }
	 public Function getX() {
		 return x;
	 }
	 public TrigonometricFunctions(double c) {
		 coefficient = c;
		setX(neutralElement);
	 }
	@Override
	Function derivative() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getY(double x) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setX(Function f) {
		x = f;
		
	}
}
