package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuidFinder {
	
	private static UUID[] guids; 
	private final int NThreads=4;
	private List<MyThread> threads; 
	public GuidFinder() throws Exception {
		getGuids();
	}
	
	public static UUID[] getGuids() throws Exception 
	{
	
		if(guids==null){
			System.out.println("es nulo");
		FileInputStream fi;
		
			fi = new FileInputStream(new File("guids.eci"));
		
		ObjectInputStream oi = new ObjectInputStream(fi);

		
		guids= (UUID[]) oi.readObject();
	
		oi.close();
		fi.close();
		}
		return guids;		
	}
	
	public int countGuids(UUID guidToFind) 
	{
		threads=new ArrayList<MyThread>();
		int segmentSize = guids.length/NThreads;
		for(int i=0; i<NThreads;i++) {
			List<UUID> uuids = new ArrayList<UUID>();
			for(int j=i;j<i+segmentSize;j++) {
				uuids.add(guids[j]);
			}
			MyThread t=new MyThread(uuids,guidToFind);
			threads.add(t);
			t.start();
		}
		for(MyThread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return MyThread.getOcurrences().get();
		
	}


}
