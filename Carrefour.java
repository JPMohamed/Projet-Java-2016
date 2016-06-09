package V1;

class Carrefour extends Agent{
	int larg;
	int haut;
	int fin;// nombre de cases en plus du carrefour
	char type;
	boolean voie;
	void cycle(){}
	Carrefour(int posX,int posY,char type,int fin,int largeur,int hauteur,boolean voie){
		aff="C_";
		pos_x=posX;pos_y=posY;
		larg=largeur;
		haut=hauteur;
		this.type=type;// O=ouest, N=NORD, S=sud, E=est , T=4 voies , V=voie ,C=case de carefour
		this.fin=fin;
		this.voie=voie; //True si c'est une voie 
		LVC.add(this);
	}
	
	Carrefour(int posX,int posY,boolean voie){
		if (voie)aff=" _";else aff="C_";
		pos_x=posX;pos_y=posY;
		this.type='C';
		this.voie=voie; //True si c'est une voie 
		LVC.add(this);
	}
	
	
	
	static void init(){
		Carrefour c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25;
		c1=new Carrefour(1,1, 'E', 5, 1, 1, false);
		c2=new Carrefour(7,1, 'E', 5, 2, 1, false);
		c3=new Carrefour(14,1, 'E', 6, 3, 1, false);
		c4=new Carrefour(22,1, 'E', 5, 2, 1, false);
		c5=new Carrefour(30,1, 'S', 5, 1, 1, false);
		
		c6=new Carrefour(1,7, 'N', 5, 1, 2, false);
		c7=new Carrefour(7,7, 'T', 5, 2, 2, false);
		c8=new Carrefour(14,7, 'T', 5, 3, 2, false);
		c9=new Carrefour(22,7, 'T', 5, 2, 2, false);
		c10=new Carrefour(30,7, 'S', 5, 1, 2, false);
		
		c11=new Carrefour(1,14, 'N', 5, 1, 3, false);
		c12=new Carrefour(7,14, 'T', 5, 2, 3, false);
		c13=new Carrefour(14,14, 'T', 5, 3, 3, false);
		c14=new Carrefour(22,14, 'T', 5, 2, 3, false);
		c15=new Carrefour(30,14, 'S', 5, 1, 3, false);
		
		c16=new Carrefour(1,22, 'N', 5, 1, 2, false);
		c17=new Carrefour(7,22, 'T', 5, 2, 2, false);
		c18=new Carrefour(14,22, 'T', 5, 3, 2, false);
		c19=new Carrefour(22,22, 'T', 5, 2, 2, false);
		c20=new Carrefour(30,22, 'S', 5, 1, 2, false);
		
		c21=new Carrefour(1,1, 'N', 5, 1, 1, false);
		c22=new Carrefour(7,1, 'O', 5, 2, 1, false);
		c23=new Carrefour(14,1, 'O', 6, 3, 1, false);
		c24=new Carrefour(22,1, 'O', 5, 2, 1, false);
		c25=new Carrefour(30,1, 'O', 5, 1, 1, false);
		
		
		Carrefour c,cc;
		int s = LVC.size();
		for(int i=0;i<s;i++){
			if(LVC.get(i) instanceof Carrefour){
				c=(Carrefour)LVC.get(i);
				
				// construction des cases du carrefour
				for(int l=c.pos_x;l<c.pos_x+c.larg;l++){
					for(int h=c.pos_y;h<c.pos_y+c.haut;h++){
						cc=	new Carrefour(l,h,false);
					}
				}
				
				if(c.type=='T' || c.type=='E' ){// si on a un 4 voie on cré les voies ou voie Est
					
					for(int l=c.pos_x+c.larg;l<c.pos_x+c.larg+c.fin;l++){
						for(int h=c.pos_y;h<c.pos_y+c.haut;h++){
							cc=	new Carrefour(l,h,true);
						}
					}
				}
				if(c.type=='T' || c.type=='O' ){// si on a un 4 voie on cré les voies ou voie ouest
					
					for(int l=c.pos_x+1;l<c.pos_x+1+c.fin;l++){
						for(int h=c.pos_y;h<c.pos_y+c.haut;h++){
							cc=	new Carrefour(l,h,true);
						}
					}
				}
				if(c.type=='T' || c.type=='N' ){// si on a un 4 voie on cré les voies ou voie Nord
					
					for(int l=c.pos_x;l<c.pos_x+c.larg+1;l++){
						for(int h=c.pos_y+1;h<c.pos_y+1+c.fin;h++){
							cc=	new Carrefour(l,h,true);
						}
					}
				}
				if(c.type=='T' || c.type=='S' ){// si on a un 4 voie on cré les voies ou voie Sud
					
					for(int l=c.pos_x;l<c.pos_x+c.larg+1;l++){
						for(int h=c.pos_y+c.haut;h<c.pos_y+c.haut+c.fin;h++){
							cc=	new Carrefour(l,h,true);
						}
					}
				}
				
				
				
				
			}
		}
	}
}