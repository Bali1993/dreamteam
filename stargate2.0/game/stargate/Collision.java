package game.stargate;

import java.util.LinkedList;

import ntrfc.stargate.Entity;

public class Collision {
	/*
	 * colonelt helyzetét(amibõl rectanglet csinál) összehasonlítha a listában lévõ összes elemének rectanglejével
	 * ha ütközés akkor true 
	 * intersects függvény beépített, ellenõrzi h 2 rectangle ütközik-e
	 */
		
	public static boolean Coll(Colonel c, LinkedList<Entity> ll){
		for(int i=0; i < ll.size(); ++i)
		{
			if(c.getRec().intersects(ll.get(i).getRec()))
				return true;
		}
		return false;
	}
}
