package edu.eci.arsw.GuidFinderAPI.services;

import java.util.List;

import edu.eci.arsw.GuidFinderAPI.model.Guid;

public interface Services {
	public List<Guid> getAllGuid();
	
	public void registerAllGuid(String guid);
}
