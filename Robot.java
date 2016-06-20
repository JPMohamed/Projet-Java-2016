package projet_java;

class Robot extends Agent{
	char etat;
	char dir;
	void cycle(){
	}
	Robot(int i,int j,char dir,String n){
		pos_x=i;pos_y=j;
		this.dir=dir;
		aff=n;
		Rob.add(this);
	}
	
	void avancer(String direction) {
		switch(direction){
		case "direction_bas" :
			pos_y--;
			break;
		case "direction_haut" :
			pos_y++;
			break;
		case "direction_droite" :
			pos_x++;
			break;
		case "direction_gauche" :
			pos_x--;
			break;
		}
	}
}