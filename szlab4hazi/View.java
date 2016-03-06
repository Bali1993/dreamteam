package szlab4hazi;

import java.util.Map;

//A Field 2 dimenzi�s t�mb�t jeleniti meg, k�pekkel
public class View{
	//teh�t mindenk�pp �t kell vennie majd a Model oszt�ly Field t�mbj�t
	//(vagy el�g ha csak haszn�lja)
	
	private Map<String, String> Pictures;
	//vagy legyen HashMap?
	
	public View(){
		//feladat1:
		//Map felt�lt�se
		//adott Elements name-hez milyen k�p, azaz k�pn�v (pl. wall -> wall.jpg) tartozik
		
		//feladat2:
		//v�gig megy a Field t�mb minden elem�n
		//lek�rdezi az Elements name v�ltoz�j�t
		//�s az alapj�n a hozz� megfelel� k�pet megjelen�ti
	}
	
	
	//megjelen�t�s�rt felel�s, csak akkor ha v�ltoz�s t�rt�nik, adott cell�t rajzolja �jra
	//a Controller ezt fogja mindig h�vogatni
	//-> akkor igy lesz k�zvetlen kapcsolat a Controller �s View k�z�tt is, az �br�n eddig nem jel�lt�k az 1. doksiba
	public void render(int x, int y){
		//A k�t koordinata alapjan lek�rdezi adott Elements-nek a nev�t, 
		//�s az alapj�n a megfelel� k�pet rendeli adott indexhez �s jelen�ti meg
		//ez�rt �rdemes sztem egy Map-ban t�rolni az adott n�v-hez milyen k�p tartozik
		
		//fontos: vannak olyan esetek amikor nem el�g a name-t lek�rdezni
		//pl1: wall eset�ben a sima �s speci�lis fal eset�ben is m�s k�pet kell megjelen�teni
		//teh�t szimpl�n csak le kell k�rdezni a special v�ltoz� �rt�k�t is
		//pl2: ugyanez a helyzet a m�rlegn�l is, r� van-e rakva a doboz vagy sem
		//pl3: ajt� nyitva van-e vagy sem
		//pl4: ezredes milyen ir�nyba n�z, vagy �ppen van-e n�la doboz, aszerint m�s k�pet kell kirajzolni
	}
	
	
}