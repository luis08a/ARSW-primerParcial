package edu.eci.arsw.GuidFinderAPI.services.sevicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.GuidFinderAPI.model.Guid;
import edu.eci.arsw.GuidFinderAPI.persistence.Persistence;
import edu.eci.arsw.GuidFinderAPI.services.Services;

public class ServicesFake implements Services{
	@Autowired
	Persistence p;
	
	public List<Guid> getAllGuid() {
		return p.getAllGuid();
	}
	
	
	@Override
	public void registerAllGuid(String guid) {
		// TODO Auto-generated method stub
		
	}
}
