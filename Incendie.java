package projet_java;

import java.util.Random;

public class Incendie extends Agent{
	int log_cycle_dec;
	void cycle(){};

	static void propagationIncendie(){
		Carrefour c = null;
		Random r = new Random();
		int val = 1 + r.nextInt(LVC.size()-1);
		int val2 = 1 + r.nextInt(LVC.size()-1);
		c.pos_x = val;
		c.pos_y = val2;
		while((c.pos_X == "X") && (c.pos_y.toString() == "X")){
			LVC.set(val, "O");
			LVC.set(val2, "O");
		}

		System.out.println(Agent.LVC);
	}
}



