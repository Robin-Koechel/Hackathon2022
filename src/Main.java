import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		RandomFunctionGenerator r = new RandomFunctionGenerator();
		ConnectTwoFunctions c =  r.getRandomFunctionBig(10);
		System.out.println(c.getY(1));
	

		
		ExponentialFunction e = new ExponentialFunction(Math.E, 1);
		
		
		Sinus sin = new Sinus(1);
		Monome m = new Monome(2, 3);
		sin.setX(m);
		c = new ConnectTwoFunctions(sin, e, '*');	
		Function n = c.derivative();
		Cosinus cos = new Cosinus(1);
		
		//ConnectTwoFunctions cPrüfen = new ConnectTwoFunctions(m2, e, '*');
		//ConnectTwoFunctions cPrüfen2 = new ConnectTwoFunctions(sin, e, '*');

	    //cPrüfen = new ConnectTwoFunctions(cPrüfen,cos,'*');
	    //cPrüfen2 = new ConnectTwoFunctions(cPrüfen2, m2, '*');
		//cPrüfen = new ConnectTwoFunctions(cPrüfen, cPrüfen2, '+');
		System.out.println(Function.testIFFunctionsAreTheSame(n, cos));
		ArrayList<Function> functions = new ArrayList<>();
		FuncToList(n,functions,0);
		String func = "";
		for(int i = 0; i < functions.size(); i++) {
			func += functions.get(i).toString();
		}
		System.out.println(func);
	}
	
	
	public static void FuncToList(Function f, ArrayList<Function> functions,int index) {
		if(f instanceof ConnectTwoFunctions) {
			functions.add(index,f);
			
			FuncToList(((ConnectTwoFunctions) f).getFunc2(), functions, ++index);
			index = index-1;
			FuncToList(((ConnectTwoFunctions) f).getFunc1(), functions, index);
		}
		else {
			
			functions.add(index, f);
		}
	}
	
	
	

}
