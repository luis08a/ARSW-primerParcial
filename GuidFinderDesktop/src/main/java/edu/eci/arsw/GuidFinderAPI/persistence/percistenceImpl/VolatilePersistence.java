package edu.eci.arsw.GuidFinderAPI.persistence.percistenceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.eci.arsw.GuidFinderAPI.model.Guid;
import edu.eci.arsw.GuidFinderAPI.persistence.Persistence;

@Service
public class VolatilePersistence implements Persistence{
	private List<Guid> guids;
	public VolatilePersistence() {
		guids = new ArrayList<Guid>();
	}

	@Override
	public List<Guid> getAllGuid() {
		return guids;
	}

	@Override
	public void registerGuid(Guid guid) {
		guids.add(guid);
	}

}
