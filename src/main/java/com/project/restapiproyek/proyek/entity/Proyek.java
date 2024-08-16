package com.project.restapiproyek.proyek.entity;

import com.project.restapiproyek.lokasi.entity.Lokasi;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

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
    private LocalDate tglMulai;

    @Column(name = "tgl_selesai")
    private LocalDate tglSelesai;

    @Column(name = "pimpinan_proyek", nullable = false)
    private String pimpinanProyek;

    private String keterangan;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "proyek_lokasi",
            joinColumns = @JoinColumn(name = "proyek_id"),
            inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<Lokasi> lokasi;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
