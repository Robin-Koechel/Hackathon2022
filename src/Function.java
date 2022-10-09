
public abstract class Function {
	abstract Function derivative(); 
	protected Function x;
	public static Monome neutralElement=  new Monome(1,1,true);
	abstract public double getY(double x);
		
	
	abstract public void setX(Function f);
	abstract public Function getX();

	
}
