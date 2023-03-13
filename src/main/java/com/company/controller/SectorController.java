package com.company.controller;

import com.company.entity.Client;
import com.company.entity.Sector;
import com.company.service.service.ClientNotFoundException;
import com.company.service.service.ClientService;
import com.company.service.service.SectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SectorController {

	@Autowired
	private SectorService sectorService;

	private final Logger LOGGER =
			LoggerFactory.getLogger(SectorController.class);

	@PostMapping("/sector")
	public Sector saveSector(@RequestBody Sector sector) {
		LOGGER.info("Inside saveSector of SectorController");
		return sectorService.saveSector(sector);
	}

	@GetMapping("/sector")
	public List<Sector> fetchSectorList() {
		LOGGER.info("Inside fetchClientList of SectorController");
		return sectorService.fetchSectorList();
	}

	@GetMapping("/sector/{id}")
	public Sector fetchSectorById(@PathVariable("id") Integer id_sector)
			throws ClientNotFoundException {
		return sectorService.fetchSectorById(id_sector);
	}

	@DeleteMapping("/sector/{id}")
	public String deleteSectorById(@PathVariable("id") Integer id_sector) {
		sectorService.deleteSectorById(id_sector);
		return "Sector deleted Successfully!!";
	}

	@PutMapping("/sector/{id}")
	public Sector updateSector(@PathVariable("id") Integer id_sector,
									   @RequestBody Sector sector) {
		return sectorService.updateSector(id_sector,sector);
	}

}