package szlab4hazi;

import java.util.Map;

//A Field 2 dimenziós tömböt jeleniti meg, képekkel
public class View{
	//tehát mindenképp át kell vennie majd a Model osztály Field tömbjét
	//(vagy elég ha csak használja)
	
	private Map<String, String> Pictures;
	//vagy legyen HashMap?
	
	public View(){
		//feladat1:
		//Map feltöltése
		//adott Elements name-hez milyen kép, azaz képnév (pl. wall -> wall.jpg) tartozik
		
		//feladat2:
		//végig megy a Field tömb minden elemén
		//lekérdezi az Elements name változóját
		//és az alapján a hozzá megfelelõ képet megjeleníti
	}
	
	
	//megjelenítésért felelõs, csak akkor ha változás történik, adott cellát rajzolja újra
	//a Controller ezt fogja mindig hívogatni
	//-> akkor igy lesz közvetlen kapcsolat a Controller és View között is, az ábrán eddig nem jelöltük az 1. doksiba
	public void render(int x, int y){
		//A két koordinata alapjan lekérdezi adott Elements-nek a nevét, 
		//és az alapján a megfelelõ képet rendeli adott indexhez és jeleníti meg
		//ezért érdemes sztem egy Map-ban tárolni az adott név-hez milyen kép tartozik
		
		//fontos: vannak olyan esetek amikor nem elég a name-t lekérdezni
		//pl1: wall esetében a sima és speciális fal esetében is más képet kell megjeleníteni
		//tehát szimplán csak le kell kérdezni a special változó értékét is
		//pl2: ugyanez a helyzet a mérlegnél is, rá van-e rakva a doboz vagy sem
		//pl3: ajtó nyitva van-e vagy sem
		//pl4: ezredes milyen irányba néz, vagy éppen van-e nála doboz, aszerint más képet kell kirajzolni
	}
	
	
}