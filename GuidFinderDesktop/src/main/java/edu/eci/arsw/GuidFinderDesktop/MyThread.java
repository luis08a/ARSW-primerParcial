package edu.eci.arsw.GuidFinderDesktop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
	private List<UUID> guids;
	private UUID guidToFind;
	private static final AtomicInteger count =new AtomicInteger(0);
	private static final Object obj = new Object();
	private static boolean active=true;
	
	public MyThread(List<UUID> guids, UUID guidToFind) {
		this.guids=guids;
		this.guidToFind=guidToFind;
	}
	
	public void run() {
		boolean alive=true;
		while(alive) {
			synchronized (obj) {
				while(!active) {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for (UUID uuid : guids) {
					if(uuid.equals(guidToFind))
							{
						int actual = count.get();
						count.compareAndSet(actual, actual+1);
							}
					
				}
				alive=false;
			}
			
	}
	}
	public static int getOcurrences() {
		return count.get();
	}
	
	public static void inactive() {
		active=false;
	}
	public static Object getLock() {
		return obj;
	}
}
