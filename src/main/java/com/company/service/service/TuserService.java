package com.company.service.service;

import com.company.entity.Sector;
import com.company.entity.Tuser;

import java.util.List;

public interface TuserService {

    public Tuser saveTuser (Tuser tuser);

    public List<Tuser> fetchTuserList();

    Tuser fetchTuserById(Integer id_sector) throws ClientNotFoundException;

    public void deleteTuserById(Integer id_user);

    public Tuser updateTuser(Integer id_user, Tuser tuser);

}
