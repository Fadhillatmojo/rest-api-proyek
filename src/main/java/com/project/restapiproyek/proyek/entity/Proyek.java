package com.project.restapiproyek.proyek.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "proyek")
@Getter
@Setter
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_proyek", nullable = false)
    private String namaProyek;

    @Column(nullable = false)
    private String client;

    @Column(name = "tgl_mulai")
    private LocalDateTime tglMulai;

    @Column(name = "tgl_selesai")
    private LocalDateTime tglSelesai;

    @Column(name = "pimpinan_proyek", nullable = false)
    private String pimpinanProyek;

    private String keterangan;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
