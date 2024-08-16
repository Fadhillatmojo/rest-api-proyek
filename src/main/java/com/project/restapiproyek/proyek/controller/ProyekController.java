package com.project.restapiproyek.proyek.controller;

import com.project.restapiproyek.DTO.ProyekDTO;
import com.project.restapiproyek.proyek.entity.Proyek;
import com.project.restapiproyek.proyek.repository.ProyekRepository;
import com.project.restapiproyek.proyek.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProyekController {
    @Autowired
    private ProyekService proyekService;

    // get all proyek endpoint
    @GetMapping("/proyek")
    private List<Proyek> getAllProyekWithLokasi() {
        return proyekService.getAllProyekWithLokasi();
    }

    // get proyek by ID endpoint
    @GetMapping("/findProyekById")
    private Proyek findById(@RequestParam int id) {
        return proyekService.findById(id);
    }

    // post proyek endpoint
    @PostMapping("/proyek")
    public Proyek save(@RequestBody ProyekDTO proyekDTO) {
        return proyekService.saveProyek(proyekDTO);
    }

    // update proyek endpoint
    @PutMapping("/proyek")
    public Proyek update(@RequestParam int id, @RequestBody Proyek proyek) {
        return proyekService.updateProyek(id, proyek);
    }

    // delete proyek endpoint
    @DeleteMapping("/proyek")
    public String delete(@RequestParam int id) {
        return proyekService.deleteProyek(id);
    }
}
