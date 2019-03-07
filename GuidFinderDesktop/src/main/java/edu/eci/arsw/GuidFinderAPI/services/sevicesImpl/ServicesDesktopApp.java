package edu.eci.arsw.GuidFinderAPI.services.sevicesImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.GuidFinderAPI.model.Guid;
import edu.eci.arsw.GuidFinderAPI.persistence.Persistence;
import edu.eci.arsw.GuidFinderAPI.services.Services;
import edu.eci.arsw.GuidFinderDesktop.GuidFinder;

@Service
public class ServicesDesktopApp implements Services{
	@Autowired
	Persistence p;
	
	public ServicesDesktopApp() {
		findUUID();
	}
	
	@Override
	public List<Guid> getAllGuid() {
		return p.getAllGuid();
	}

	@Override
	public void registerAllGuid(String guid) {
		try {
			GuidFinder finder = new GuidFinder();
			double count = finder.countGuids(UUID.fromString(guid));
			String fecha = LocalDate.now().toString();
			p.registerGuid(new Guid(fecha,guid,count));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void findUUID() {
		GuidFinder finder;
		try {
			finder = new GuidFinder();
			double count = finder.countGuids(UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3"));
			String fecha = LocalDate.now().toString();
			p.registerGuid(new Guid(fecha,"d0692660-c39a-4d73-9496-d9df0c4ebdf3",count));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
