package edu.eci.arsw.GuidFinderAPI.persistence.percistenceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.eci.arsw.GuidFinderAPI.model.Guid;
import edu.eci.arsw.GuidFinderAPI.persistence.Persistence;
import edu.eci.arsw.GuidFinderDesktop.GuidFinder;

@Service
public class VolatilePersistence implements Persistence{
	private List<Guid> guids;
	

	@Override
	public List<Guid> getAllGuid() {
		if(guids==null) {
			guids = new ArrayList<Guid>();
			GuidFinder finder;
			try {
				finder = new GuidFinder();
				//double count = finder.countGuids(UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3"));
				String fecha = LocalDate.now().toString();
				Guid g = new Guid(fecha,"d0692660-c39a-4d73-9496-d9df0c4ebdf3",finder.countGuids(UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3")));
				guids.add(g);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return guids;
	}

	@Override
	public void registerGuid(Guid guid) {
		if(guids==null) {
			guids = new ArrayList<Guid>();
			GuidFinder finder;
			try {
				finder = new GuidFinder();
				//double count = finder.countGuids(UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3"));
				String fecha = LocalDate.now().toString();
				Guid g = new Guid(fecha,"d0692660-c39a-4d73-9496-d9df0c4ebdf3",finder.countGuids(UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3")));
				guids.add(g);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		guids.add(guid);
	}

}
