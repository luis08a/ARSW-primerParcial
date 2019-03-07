package edu.eci.arsw.GuidFinderDesktop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuidFinderDesktopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GuidFinderDesktopApplication.class, args);
		
		try {
			GuidFinder finder= new GuidFinder();
			
			System.out.println(finder.countGuids(UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		KeyListener kl = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getWhen()-System.currentTimeMillis()>10000)resume();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getWhen()-System.currentTimeMillis()>10000)pause();
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		};
		
	}
	public static void resume() {
		MyThread.getLock().notifyAll();
	}
	public static void pause() {
		MyThread.inactive();
	}

}
