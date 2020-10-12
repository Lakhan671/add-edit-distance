package com.innowatts.controller;
import java.util.WeakHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.innowatts.services.AddEditDistanceService;

@RestController
@RequestMapping(value = "/api")
public class AddEditDistanceController {
	@Autowired
	private AddEditDistanceService addEditDistanceService;
	@PostMapping(value = "/add")
	public ResponseEntity<Object> add(@RequestBody WeakHashMap<String,String> request) {
		
		return new ResponseEntity<>(
				addEditDistanceService.concatenate(request), 
			      HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/edit-distance")
	public ResponseEntity<Object> editDistance(@RequestBody WeakHashMap<String,String> request) {
		return new ResponseEntity<>(
				addEditDistanceService.editDistance(request), 
			      HttpStatus.OK);	
	}

}
