package edu.eci.arsw.GuidFinderAPI.persistence;

import java.util.List;

import edu.eci.arsw.GuidFinderAPI.model.Guid;

public interface Persistence {
	public void registerGuid(Guid guid);
	
	public List<Guid> getAllGuid();
}
