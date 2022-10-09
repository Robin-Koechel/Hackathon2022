public class Main {

	public static void main(String[] args) {
		RandomFunctionGenerator r = new RandomFunctionGenerator();
		ConnectTwoFunctions c =  r.getRandomFunctionBig(10);
		System.out.println(c.getY(1));
	

		
		ExponentialFunction e = new ExponentialFunction(Math.E, 1);
		
		
		Sinus sin = new Sinus(1);
		Monome m3 = new Monome(0, 2);
		c = new ConnectTwoFunctions(sin, m3, '+');	
		Function n = c.derivative();
		Cosinus cos = new Cosinus(1);
		
		//ConnectTwoFunctions cPrüfen = new ConnectTwoFunctions(m2, e, '*');
		//ConnectTwoFunctions cPrüfen2 = new ConnectTwoFunctions(sin, e, '*');

	    //cPrüfen = new ConnectTwoFunctions(cPrüfen,cos,'*');
	    //cPrüfen2 = new ConnectTwoFunctions(cPrüfen2, m2, '*');
		//cPrüfen = new ConnectTwoFunctions(cPrüfen, cPrüfen2, '+');
		System.out.println(Function.testIFFunctionsAreTheSame(n, cos));
	}
	
	
	

}
