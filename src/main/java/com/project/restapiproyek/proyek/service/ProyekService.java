package com.project.restapiproyek.proyek.service;

import com.project.restapiproyek.proyek.entity.Proyek;
import com.project.restapiproyek.proyek.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {
    @Autowired
    private ProyekRepository proyekRepository;

    // Get All Proyek
    public List<Proyek> getAllProyekWithLokasi() {
        return proyekRepository.findAll();
    }

    // ini fungsi find ID nanti bisa dipake di update atau delete atau bisa juga buat show misal ada show
    public Proyek findById(int id) {
        Optional<Proyek> proyek = proyekRepository.findById(id);

        if (proyek.isEmpty()) {
            throw new RuntimeException("Proyek Tidak Ditemukan!");
        }

        return proyek.get();
    }

    // ini post request
    public Proyek saveProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    // ini update request
    public Proyek updateProyek(int id, Proyek proyek) {
        // pertama cari dulu ada gak id nya proyek di database

        Proyek existingProyek = findById(id);
        existingProyek.setNamaProyek(proyek.getNamaProyek());
        existingProyek.setPimpinanProyek(proyek.getPimpinanProyek());
        existingProyek.setClient(proyek.getClient());
        existingProyek.setTglMulai(proyek.getTglMulai());
        existingProyek.setTglSelesai(proyek.getTglSelesai());
        existingProyek.setKeterangan(proyek.getKeterangan());

        return proyekRepository.save(existingProyek);
    }

    // ini Delete
    public String deleteProyek(int id) {
        // pertama cari dulu ada gak id nya proyek di database
        proyekRepository.delete(findById(id));

        return "Proyek Sukses Dihapus!";
    }
}
