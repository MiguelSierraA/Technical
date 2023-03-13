package com.company.service.seviceImpl;

import com.company.entity.Sector;
import com.company.entity.Tuser;
import com.company.repository.SectorRepository;
import com.company.repository.TuserRepository;
import com.company.service.service.ClientNotFoundException;
import com.company.service.service.SectorService;
import com.company.service.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TuserServiceImpl implements TuserService {

    @Autowired
    public TuserRepository tuserRepository;

    @Override
    public Tuser saveTuser(Tuser tuser) {

        return tuserRepository.save(tuser);
    }

    @Override
    public List<Tuser> fetchTuserList() {

        return tuserRepository.findAll();
    }

    @Override
    public Tuser fetchTuserById(Integer id_user) throws ClientNotFoundException {
        Optional<Tuser> tuser =
                tuserRepository.findById(id_user);

        if(!tuser.isPresent()) {
            throw new ClientNotFoundException("Sector Not Available");
        }

        return  tuser.get();
    }

    @Override
    public void deleteTuserById(Integer id_user) {
        tuserRepository.deleteById(id_user);

    }

    @Override
    public Tuser updateTuser(Integer id_user, Tuser tuser) {
        Tuser cliDB = tuserRepository.findById(id_user).get();

        if(Objects.nonNull(tuser.getName()) &&
                !"".equalsIgnoreCase(tuser.getName())) {
            cliDB.setName(tuser.getName());
        }

        if(Objects.nonNull(tuser.getLast_name()) &&
                !"".equalsIgnoreCase(tuser.getLast_name())) {
            cliDB.setLast_name(tuser.getLast_name());
        }

        if(Objects.nonNull(tuser.getEmail()) &&
                !"".equalsIgnoreCase(tuser.getEmail())) {
            cliDB.setEmail(tuser.getEmail());
        }

        if(Objects.nonNull(tuser.getPass()) &&
                !"".equalsIgnoreCase(tuser.getPass())) {
            cliDB.setPass(tuser.getPass());
        }


        return tuserRepository.save(cliDB);
    }
}
