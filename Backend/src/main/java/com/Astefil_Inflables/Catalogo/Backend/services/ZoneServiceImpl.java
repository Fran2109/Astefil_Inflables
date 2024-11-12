package com.Astefil_Inflables.Catalogo.Backend.services;

import com.Astefil_Inflables.Catalogo.Backend.exceptions.ItemNotFoundException;
import com.Astefil_Inflables.Catalogo.Backend.exceptions.NotAllowedException;
import com.Astefil_Inflables.Catalogo.Backend.models.Zone;
import com.Astefil_Inflables.Catalogo.Backend.repositories.ZoneRepository;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZoneServiceImpl implements IZoneService {
    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Zone> getAllZones() {
        return (List<Zone>) this.zoneRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Zone getZoneById(Long id) {
        return this.zoneRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Zone with id: '"+ id +"'not found"));
    }

    @Override
    @Transactional
    public Zone createZone(String name, Number latitude, Number longitude) {
        List<Zone> zones = this.getAllZones();
        for(Zone Zone : zones){
            if(Zone.getName().equals(name)){
                throw new NotAllowedException("Zone with name: '"+ name +"' already exists");
            }
        }
        Zone newZone = new Zone(name, latitude, longitude);
        return this.zoneRepository.save(newZone);
    }

    @Override
    @Transactional
    public Zone updateZone(Long id, String name, Number latitude, Number longitude) {
        Zone zone = this.getZoneById(id);
        zone.setName(name);
        zone.setLatitude(latitude);
        zone.setLongitude(longitude);
        return this.zoneRepository.save(zone);
    }

    @Override
    @Transactional
    public void deleteZone(Long id) {
        Zone zone = this.getZoneById(id);
        this.zoneRepository.delete(zone);
    }
}