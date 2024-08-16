package com.project.restapiproyek.proyek.service;

import com.project.restapiproyek.DTO.ProyekDTO;
import com.project.restapiproyek.lokasi.entity.Lokasi;
import com.project.restapiproyek.lokasi.repository.LokasiRepository;
import com.project.restapiproyek.proyek.entity.Proyek;
import com.project.restapiproyek.proyek.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProyekService {
    @Autowired
    private ProyekRepository proyekRepository;
    @Autowired
    private LokasiRepository lokasiRepository;

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
    public Proyek saveProyek(ProyekDTO proyekDTO) {
        Proyek proyek = new Proyek();
        proyek.setNamaProyek(proyekDTO.getNamaProyek());
        proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
        proyek.setClient(proyekDTO.getClient());
        proyek.setTglMulai(proyekDTO.getTglMulai());
        proyek.setTglSelesai(proyekDTO.getTglSelesai());
        proyek.setKeterangan(proyekDTO.getKeterangan());

        Set<Lokasi> lokasiSet = new HashSet<>();
        for (Integer lokasiId : proyekDTO.getLokasiIds()) {
            Lokasi lokasi = lokasiRepository.findById(lokasiId)
                    .orElseThrow(() -> new RuntimeException("Lokasi not found with id: " + lokasiId));
            lokasiSet.add(lokasi);
        }

        proyek.setLokasi(lokasiSet);
        return proyekRepository.save(proyek);

    }
//    public Proyek saveProyek(Proyek proyek) {
//        return proyekRepository.save(proyek);
//    }

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
