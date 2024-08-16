package com.project.restapiproyek.lokasi.repository;

import com.project.restapiproyek.lokasi.entity.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}
