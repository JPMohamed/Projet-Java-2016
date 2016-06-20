package V1;
import java.util.*;


abstract class Agent{
	static int nl=30;
	static int nc=30;
	static List LVC = new LinkedList();//liste des voies carrefours
	static List Rob = new LinkedList();//liste des voies carrefours
	// la position correspond au coins en haut a gauche du carrefour
	int pos_x;
	int pos_y;
	String aff;
	abstract void cycle();
	static String affiche(){
		String s="   ";
		for(int i=1;i<10;i++) s+=+i+"_";
		for(int i=0;i<10;i++) s+=+i+"_";
		for(int i=0;i<10;i++) s+=+i+"_";
		s+="0\n";
		
		
		for(int i=1;i<=nl;i++){
			if(i<10){
				s+=" "+i;
			}
			else{
				s+=""+i;
				
			}
			s+=")";
			for(int j=1;j<=nc;j++){
				s+=caractereImprimable(i,j);
			}
			s+="\n";
		}
		return s;
	}
	static String caractereImprimable(int i,int j){
		String r="X_"; // affichage papier
		Agent a;
		// si on trouve un robot on est forcement sur une voie
		for(int k=0;k<Rob.size();k++){
			a=(Agent)Rob.get(k);
			if(a.pos_x==i && a.pos_y==j)return a.aff;
		}
		//si on a pas trouvé de robot on regarde si on a une voie 
		for(int k=0;k<LVC.size();k++){
			a=(Agent)LVC.get(k);
			if(a.pos_x==i && a.pos_y==j)return a.aff;
		}
		//sinon on a du papier
		return r;
	}
	public String toString(){
		return getClass().getSimpleName()+" "+pos_x+" "+pos_y+" / ";
	}
}
