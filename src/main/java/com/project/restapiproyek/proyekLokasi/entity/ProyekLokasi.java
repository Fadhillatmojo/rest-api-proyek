package com.project.restapiproyek.proyekLokasi.entity;

import com.project.restapiproyek.lokasi.entity.Lokasi;
import com.project.restapiproyek.proyek.entity.Proyek;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyek_lokasi")
@Getter
@Setter
public class ProyekLokasi {

    @EmbeddedId
    private ProyekLokasiId id;

    @ManyToOne
    @MapsId("proyekId") // Maps proyekId attribute in embedded id
    @JoinColumn(name = "proyek_id", nullable = false)
    private Proyek proyek;

    @ManyToOne
    @MapsId("lokasiId") // Maps lokasiId attribute in embedded id
    @JoinColumn(name = "lokasi_id", nullable = false)
    private Lokasi lokasi;

    // Constructors, getters, setters
    public ProyekLokasi() {}

    public ProyekLokasi(Proyek proyek, Lokasi lokasi) {
        this.proyek = proyek;
        this.lokasi = lokasi;
        this.id = new ProyekLokasiId(proyek.getId(), lokasi.getId());
    }
}
