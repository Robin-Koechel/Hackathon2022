import java.util.ArrayList;

public class RandomFunctionGenerator {
	public Function getRandomFunction(int difficulty) {
		int random = (int)(Math.random()*3);
		Function f = null;
		if(random == 0) {
			 random = (int)(Math.random()* 20);
			
			if(random > difficulty) {
				f = new Monome((int)(Math.random()*8-4), Math.round(Math.random()*8-4));
			}
			else {
				int nenner =(int) (Math.random()*3);
				int zähler =(int) (Math.random()*3);
				f = new Monome(zähler/nenner, Math.round(Math.random()*8-4));
			}
			
		}
		else if(random == 1) {
			random = (int)(Math.random()*2);
			if(random == 0 ) {
				f = new Sinus((int)(Math.random()*8-4));
			}
			else {
				f = new Cosinus((int)(Math.random()*8-4));

			}
		}
		else {
			f = new ExponentialFunction(Math.E, (int)(Math.random()*8-4));
		}
			
		return f;
	}

	public ConnectTwoFunctions getRandomFunctionBig(int difficulty) {
		int numberOfFunctions = (int) ((Math.random() * 2) + 2);
		ArrayList<Function> functions = new ArrayList<Function>();
		for (int i = 0; i < numberOfFunctions; i++) {
			functions.add(getRandomFunction(difficulty));
			int max = 3;
			do {
				int random = (int) (Math.random() * 20);
				if (random < difficulty) {
					if (max == 3) {
						functions.get(i).setX(getRandomFunction(difficulty));
					} else if (max == 2) {
						functions.get(i).getX().setX(getRandomFunction(difficulty));

					} else if (max == 1) {
						functions.get(i).getX().getX().setX(getRandomFunction(difficulty));

					}

				} else {
					max = 0;
				}
				max--;

			} while (max > 0);
		}
		// biggest difficulty 20

		int random = (int) (Math.random() * 20);
		ConnectTwoFunctions c = null;
		if (random > difficulty) {
			c = new ConnectTwoFunctions(functions.get(0), functions.get(1), '+');
		} else {
			c = new ConnectTwoFunctions(functions.get(0), functions.get(1), '*');

		}

		for (int i = 2; i < functions.size(); i++) {
			random = (int) (Math.random() * 20);
			if (random > difficulty) {
				c = new ConnectTwoFunctions(c, functions.get(i), '+');
			} else {
				c = new ConnectTwoFunctions(c, functions.get(i), '*');

			}

		}
		return c;
	}
}
