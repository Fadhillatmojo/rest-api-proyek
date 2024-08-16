package com.project.restapiproyek.lokasi.service;

import com.project.restapiproyek.lokasi.entity.Lokasi;
import com.project.restapiproyek.lokasi.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    // Get All lokasi
    public List<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    // ini fungsi find ID nanti bisa dipake di update atau delete atau bisa juga buat show misal ada show
    public Lokasi findById(int id) {
        Optional<Lokasi> lokasi = lokasiRepository.findById(id);

        if (lokasi.isEmpty()) {
            throw new RuntimeException("Lokasi Tidak Ditemukan!");
        }

        return lokasi.get();
    }

    // ini post request
    public Lokasi saveLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    // ini update request
    public Lokasi updateLokasi(int id, Lokasi lokasi) {
        // pertama cari dulu ada gak id nya lokasi di database

        Lokasi existingLokasi = findById(id);
        existingLokasi.setNamaLokasi(lokasi.getNamaLokasi());
        existingLokasi.setKota(lokasi.getKota());
        existingLokasi.setProvinsi(lokasi.getProvinsi());
        existingLokasi.setNegara(lokasi.getNegara());

        return lokasiRepository.save(existingLokasi);
    }

    // ini Delete
    public String deleteLokasi(int id) {
        // pertama cari dulu ada gak id nya lokasi di database
        lokasiRepository.delete(findById(id));

        return "Lokasi Sukses Dihapus!";
    }
}
