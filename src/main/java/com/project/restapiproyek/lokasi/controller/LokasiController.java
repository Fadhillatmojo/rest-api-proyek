package com.project.restapiproyek.lokasi.controller;

import com.project.restapiproyek.lokasi.entity.Lokasi;
import com.project.restapiproyek.lokasi.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    // get all lokasi endpoint
    @GetMapping("/lokasi")
    private List<Lokasi> findAll() {
        return lokasiService.findAll();
    }

    // get lokasi by ID endpoint
    @GetMapping("/findLokasiById")
    private Lokasi findById(@RequestParam int id) {
        return lokasiService.findById(id);
    }

    // post lokasi endpoint
    @PostMapping("/lokasi")
    public Lokasi save(@RequestBody Lokasi lokasi) {
        return lokasiService.saveLokasi(lokasi);
    }

    // update lokasi endpoint
    @PutMapping("/lokasi")
    public Lokasi update(@RequestParam int id, @RequestBody Lokasi lokasi) {
        return lokasiService.updateLokasi(id, lokasi);
    }

    // delete lokasi endpoint
    @DeleteMapping("/lokasi")
    public String delete(@RequestParam int id) {
        return lokasiService.deleteLokasi(id);
    }
}
