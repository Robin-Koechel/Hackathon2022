
public class Main {

	public static void main(String[] args) {
		RandomFunctionGenerator r = new RandomFunctionGenerator();
		ConnectTwoFunctions c =  r.getRandomFunctionBig(1);
		System.out.println(c.getY(1));
	}

}
