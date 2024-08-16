package com.project.restapiproyek.lokasi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.project.restapiproyek.proyek.entity.Proyek;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="lokasi")
@Getter
@Setter
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_lokasi", nullable = false)
    private String namaLokasi;

    @Column(nullable = false)
    private String negara;

    @Column(nullable = false)
    private String provinsi;

    @Column(nullable = false)
    private String kota;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "lokasi")
    @JsonIgnore
    private Set<Proyek> proyek;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
