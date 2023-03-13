package com.company.service.seviceImpl;

import com.company.entity.Client;
import com.company.entity.Sector;
import com.company.repository.ClientRepository;
import com.company.repository.SectorRepository;
import com.company.service.service.ClientNotFoundException;
import com.company.service.service.ClientService;
import com.company.service.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    public SectorRepository sectorRepository;

    @Override
    public Sector saveSector(Sector sector) {

        return sectorRepository.save(sector);
    }

    @Override
    public List<Sector> fetchSectorList() {

        return sectorRepository.findAll();
    }

    @Override
    public Sector fetchSectorById(Integer id_sector) throws ClientNotFoundException {
        Optional<Sector> sector =
                sectorRepository.findById(id_sector);

        if(!sector.isPresent()) {
            throw new ClientNotFoundException("Sector Not Available");
        }

        return  sector.get();
    }

    @Override
    public void deleteSectorById(Integer id_sector) {
        sectorRepository.deleteById(id_sector);

    }

    @Override
    public Sector updateSector(Integer id_sector, Sector sector) {
        Sector cliDB = sectorRepository.findById(id_sector).get();

        if(Objects.nonNull(sector.getSector_name()) &&
                !"".equalsIgnoreCase(sector.getSector_name())) {
            cliDB.setSector_name(sector.getSector_name());
        }
        return sectorRepository.save(cliDB);
    }
}
