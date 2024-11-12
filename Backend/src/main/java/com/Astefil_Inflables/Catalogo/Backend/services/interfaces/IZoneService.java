package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import com.Astefil_Inflables.Catalogo.Backend.models.Zone;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IZoneService {
    List<Zone> getAllZones();
    Zone getZoneById(Long id);
    Zone createZone(String name, Number latitude, Number longitude);
    Zone updateZone(Long id, String name, Number latitude, Number longitude);
    void deleteZone(Long id);
}
