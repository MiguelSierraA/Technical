package com.company.service.service;

import com.company.entity.Client;
import com.company.entity.Sector;

import java.util.List;

public interface SectorService {

    public Sector saveSector (Sector sector);

    public List<Sector> fetchSectorList();

    Sector fetchSectorById(Integer id_sector) throws ClientNotFoundException;

    public void deleteSectorById(Integer id_sector);

    public Sector updateSector(Integer id_sector, Sector sector);

}
