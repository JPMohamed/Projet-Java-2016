package projet_java.trunk;

public class TestIncendie {
	public static void main(String[] args) {
		//Robot r1 = new Robot(1,1,'o',"a");
		//Robot r2 = new Robot(8,4,'e',"_b_");
		
		Carrefour.init();
		System.out.println(Agent.LVC);
		Agent.affiche();
	}
}
