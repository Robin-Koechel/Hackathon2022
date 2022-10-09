
public abstract class Function {
	abstract Function derivative(); 
	protected Function x;
	public static Monome neutralElement=  new Monome(1,1,true);
	abstract public double getY(double x);
		
	
	abstract public void setX(Function f);
	abstract public Function getX();
	public static boolean testIFFunctionsAreTheSame(Function f1,Function f2) {
		boolean same = true;
		for(int i= -100; i< 100; i++) {
			double df1 = f1.getY(i);
			double df2 = f2.getY(i);

			if(f1.getY(i) != f2.getY(i)) {
				return false;
			}
		}
		return same;
	}
	abstract public String toString();
	
}
