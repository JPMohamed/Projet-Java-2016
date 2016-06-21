package projet_java.trunk;

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
}