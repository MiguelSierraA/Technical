package com.company.controller;

import com.company.entity.Sector;
import com.company.entity.Tuser;
import com.company.service.service.ClientNotFoundException;
import com.company.service.service.SectorService;
import com.company.service.service.TuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TuserController {

	@Autowired
	private TuserService tuserService;

	private final Logger LOGGER =
			LoggerFactory.getLogger(TuserController.class);

	@PostMapping("/tuser")
	public Tuser saveTuser(@RequestBody Tuser tuser) {
		LOGGER.info("Inside saveSector of SectorController");
		return tuserService.saveTuser(tuser);
	}

	@GetMapping("/tuser")
	public List<Tuser> fetchTuserList() {
		LOGGER.info("Inside fetchTuserList of TuserController");
		return tuserService.fetchTuserList();
	}

	@GetMapping("/tuser/{id}")
	public Tuser fetchTuserById(@PathVariable("id") Integer id_user)
			throws ClientNotFoundException {
		return tuserService.fetchTuserById(id_user);
	}

	@DeleteMapping("/tuser/{id}")
	public String deleteTuserById(@PathVariable("id") Integer id_user) {
		tuserService.deleteTuserById(id_user);
		return "User deleted Successfully!!";
	}

	@PutMapping("/tuser/{id}")
	public Tuser updateTuser(@PathVariable("id") Integer id_user,
									   @RequestBody Tuser tuser) {
		return tuserService.updateTuser(id_user,tuser);
	}

}