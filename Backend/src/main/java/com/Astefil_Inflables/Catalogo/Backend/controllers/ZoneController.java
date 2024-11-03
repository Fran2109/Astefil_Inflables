package com.Astefil_Inflables.Catalogo.Backend.controllers;

import com.Astefil_Inflables.Catalogo.Backend.dto.Zone.ZoneDTO;
import com.Astefil_Inflables.Catalogo.Backend.models.Zone;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IZoneService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/api/zone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ZoneController {
    @Autowired
    private IZoneService zoneService;

    @GetMapping(path="")
    public List<Zone> getAllZones(){
        return zoneService.getAllZones();
    }

    @GetMapping(path="/{id}")
    public Zone getZoneById(@PathVariable Long id){
        return zoneService.getZoneById(id);
    }

    @PostMapping(path = "")
    public Zone createZone(@Valid @RequestBody @NotNull ZoneDTO zone) {
        return this.zoneService.createZone(zone.getName());
    }

    @PutMapping(path = "/{id}")
    public Zone updateZone(@PathVariable Long id, @Valid @RequestBody @NotNull ZoneDTO zone) {
        return this.zoneService.updateZone(id, zone.getName());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteZone(@PathVariable Long id) {
        this.zoneService.deleteZone(id);
        return ResponseEntity.ok().build();
    }
}
