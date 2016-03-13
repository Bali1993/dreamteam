package game.stargate;

import java.util.LinkedList;

import ntrfc.stargate.Entity;

public class Collision {
	/*
	 * colonelt helyzet�t(amib�l rectanglet csin�l) �sszehasonl�tha a list�ban l�v� �sszes elem�nek rectanglej�vel
	 * ha �tk�z�s akkor true 
	 * intersects f�ggv�ny be�p�tett, ellen�rzi h 2 rectangle �tk�zik-e
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
