package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import com.Astefil_Inflables.Catalogo.Backend.models.Zone;

import java.util.List;

public interface IZoneService {
    List<Zone> getAllZones();
    Zone getZoneById(Long id);
    Zone createZone(String name);
    Zone updateZone(Long id, String name);
    void deleteZone(Long id);
}
