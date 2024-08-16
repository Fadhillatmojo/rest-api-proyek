package com.project.restapiproyek.proyek.controller;

import com.project.restapiproyek.DTO.ProyekDTO;
import com.project.restapiproyek.DTO.ProyekDetailDTO;
import com.project.restapiproyek.proyek.entity.Proyek;
import com.project.restapiproyek.proyek.repository.ProyekRepository;
import com.project.restapiproyek.proyek.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<ProyekDetailDTO> findProyekById(@RequestParam int id) {
        try {
            ProyekDetailDTO proyekDetailDTO = proyekService.findProyekById(id);
            return ResponseEntity.ok(proyekDetailDTO); // Return 200 OK with ProyekDTO in response body
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 Not Found if the project doesn't exist
        }
    }

    // post proyek endpoint
    @PostMapping("/proyek")
    public Proyek save(@RequestBody ProyekDTO proyekDTO) {
        return proyekService.saveProyek(proyekDTO);
    }

    // update proyek endpoint
    @PutMapping("/proyek")
    public ResponseEntity<Proyek> updateProyek(@RequestParam Integer id, @RequestBody ProyekDTO proyekDTO) {
        try {
            Proyek updatedProyek = proyekService.updateProyek(id, proyekDTO);
            return ResponseEntity.ok(updatedProyek);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
//
//    public Proyek update(@RequestParam int id, @RequestBody Proyek proyek) {
//        return proyekService.updateProyek(id, proyek);
//    }

    // delete proyek endpoint
    @DeleteMapping("/proyek")
//    public String delete(@RequestParam int id) {
//        return proyekService.deleteProyek(id);
//    }
    public String delete(@RequestParam Integer id) {
        try {
            return proyekService.deleteProyek(id); // Return 204 No Content on successful deletion
        } catch (RuntimeException e) {
            return "Proyek Not Found"; // Return 404 Not Found if the project doesn't exist
        }
    }
}
