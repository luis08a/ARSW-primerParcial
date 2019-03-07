package edu.eci.arsw.GuidFinderAPI.controller;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.GuidFinderAPI.model.Guid;
import edu.eci.arsw.GuidFinderAPI.services.Services;

@RestController
@RequestMapping("/uiid")
public class GuidFinderController {
	@Autowired
	Services s;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> getAllGuid() {
		try {
	        List<Guid> data = s.getAllGuid();
	        return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        Logger.getLogger(GuidFinderController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
	    }  
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> RegisterGuid(@RequestBody String guid) {
	try {
		s.registerAllGuid(guid);
		return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception ex) {
    	Logger.getLogger(GuidFinderController.class.getName()).log(Level.SEVERE, null, ex);
        return new ResponseEntity<>("Error bla bla bla",HttpStatus.FORBIDDEN);            
    }
	}
}
