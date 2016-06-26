package projet_java.trunk;

class Robot extends Agent{
	char etat;
	char dir;
	boolean dansCarrefour;
	void cycle(){
	}
	Robot(int i,int j,char dir,String n){
		pos_x=i;pos_y=j;
		this.dir=dir;
		aff=n;
		Rob.add(this);
	}
	
	public void avancer(char direction) {
		System.out.println("test avancer");
		switch(direction){
		case 'N' :
			pos_x--;
			break;
		case 'S' :
			pos_x++;
			break;
		case 'E' :
			pos_y++;
			break;
		case 'O' :
			pos_y--;
			break;
		}
	}
	
static void pasApas(){
		
		System.out.println("test pas a pas ");
		
		// on fait avancer tous les robots d'une case  
		for(int i=0;i<Agent.Rob.size();i++){
			System.out.println("Général" + Rob.get(i));
			
			
			Robot r=((Robot)Agent.Rob.get(i));
			// regarder s'il y a un incendie
			
			
			// si on voit un autre robot => parcourir la liste des robot
			boolean testChangeDir=false; // true si le robot doit changer de direction car il voit un autre robot
			for(int j=0;j<Agent.Rob.size();j++){
		
				System.out.println("visible " + Rob.get(j));
				Robot r2 = (Robot)Agent.Rob.get(j);
				if (r.equals(r2)) continue;
				if(r.visible(r2)){
					System.out.println("test visible " + r.visible(r2));
					testChangeDir=true;
					break;
				}
			}
			int test =1;
			// regarder si on est sur un carrefour 
			if (!(Carrefour.estCarefour(r.pos_x, r.pos_y))&&r.dansCarrefour)r.dansCarrefour=false;
			boolean testCarrefour=Carrefour.estCarefour(r.pos_x, r.pos_y)&&!r.dansCarrefour;
			System.out.println("est carrefour ? "+ r+ " "+testCarrefour);
			System.out.println(" change dire ? "+ testChangeDir);
			if(testChangeDir){
				if(testCarrefour){
					char voieStr=' ';
					do{
						int voie =(int)(Math.random() * ( 5 - 1 )+1);
						switch(voie){
							case 1 : //nord
								voieStr='N';
							case 2 : //sud
								voieStr='S';
							case 3 : // est
								voieStr='E';
							case 4 : //ouest
								voieStr='O';
						}
					}while (voieStr==r.dir && r.ilYAUneVoie(voieStr));
					r.dir=voieStr;
				}
				else{ //on tourne de 180°
					System.out.println("test else");
					switch(r.dir){
					case 'N' : //nord
						r.dir='S';
						break;
					case  'S': //sud
						r.dir='N';
						break;
					case 'E' : // est
						r.dir='O';
						break;
					case 'O' : //ouest
						r.dir='E';
						break;
					}
					System.out.println("nex dir "+ r+" "+r.dir );
				
					
				}
			}
			else if(testCarrefour){
				System.out.println("test elsif");
				char voieStr=' ';
				do{
					System.out.println("test do");
					int voie =(int)(Math.random() * ( 5 - 1 )+1);
					switch(voie){
						case 1 : //nord
							voieStr='N';
							break;
						case 2 : //sud
							voieStr='S';
							break;
						case 3 : // est
							voieStr='E';
							break;
						case 4 : //ouest
							voieStr='O';
							break;
					}
					test++;
					System.out.println(voieStr);
				}while (r.ilYAUneVoie(voieStr));
				r.dir=voieStr;
				System.out.println("nouvelle direction" +r.dir);
				r.dansCarrefour=true;
			}
			else r.avancer(r.dir);
		}
	}
	
	
	
	//regarder si 2 robot sont visibles
	public boolean visible(Robot r){
		
		if (this.dir=='N'&& this.pos_x<=r.pos_x)return false;
		if (this.dir=='S'&&this.pos_x>=r.pos_x)return false;
		if (this.dir=='O'&&this.pos_y<=r.pos_y)return false;
		if(this.dir=='E'&&this.pos_y>=r.pos_y)return false;
		
		return visible(this.pos_x, this.pos_y, r.pos_x, r.pos_y);
	}
	
	public boolean ilYAUneVoie(char dir){
		switch(dir){
			case 'N' : //nord
				if (Carrefour.ilYAUneVoie(this.pos_x-3, this.pos_y))return false;
				break;
			case  'S': //sud
				if (Carrefour.ilYAUneVoie(this.pos_x+3, this.pos_y))return false;
				break;
			case 'E' : // est
				if (Carrefour.ilYAUneVoie(this.pos_x, this.pos_y+3))return false;
				break;
			case 'O' : //ouest
				if (Carrefour.ilYAUneVoie(this.pos_x, this.pos_y-3))return false;
				break;
		}
		return true;
		
	}
	
	// return true si 2 cases sont visible c'est a dire pas de papier ni robot entre les 2 
	public static boolean visible(int x1,int y1, int x2, int y2){
		int xbis=(x1+x2)/2;
		int ybis =(y1+y2)/2;
		System.out.println(xbis+ "-"+ybis + " : " +occupee(xbis, ybis));
		if (occupee(xbis, ybis)) return false ;
		if (Math.abs(x1-x2)<=1 && Math.abs(y1-y2)<=1)return true;
		return visible(x1,y1,xbis,ybis)&&visible(xbis,ybis,x2,y2); 
		 
	}
	public static boolean occupee(int x,int y){
		// renvoie true si la case est occupée
		
		//on test si la case est du papier 
		for (int i = 0; i<Agent.LVC.size();i++){
			if (x==((Agent)Agent.LVC.get(i)).pos_x && y==((Agent)Agent.LVC.get(i)).pos_y){
				return false;
			}
		}
		
		// on test si un robot est sur la case
		for (int i = 0; i<Agent.Rob.size();i++){
			if (x==((Agent)Agent.Rob.get(i)).pos_x && y==((Agent)Agent.Rob.get(i)).pos_y){
				return false;
			}
		}
		return true;
		
	}
	
	public boolean equals(Robot r){
		return this.aff==r.aff;
	}
	
	static void initRobot(){
		
		Robot r1=new Robot(2,1, 'S',"a_");
		Robot r2=new Robot(29, 1, 'N', "b_");
		System.out.println(Rob);
		System.out.println(r1.visible(r2));
	}
	
}