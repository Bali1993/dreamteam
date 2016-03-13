package game.stargate;

import java.util.LinkedList;

import ntrfc.stargate.Entity;

public class Collision {
	/*
	 * colonelt helyzetét(amibõl rectanglet csinál) összehasonlítha a listában lévõ összes elemének rectanglejével
	 * ha ütközés akkor true 
	 * intersects függvény beépített, ellenõrzi h 2 rectangle ütközik-e
	 */
		
	public static int C_Col(Colonel e, LinkedList<Entity> ll){
		for(int i=0; i < ll.size(); ++i)
		{
			if(e.getRec().intersects(ll.get(i).getRec()))
				return i;   //index of element in list
		}
		return 0;			//0 if no collision
	}
	
	public static int C_Bul(Bullet b, LinkedList<Entity> ll){
		return 0;
	}
}
