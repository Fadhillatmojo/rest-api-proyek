package com.project.restapiproyek.proyekLokasi.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class ProyekLokasiId implements Serializable {

    private Integer proyekId;
    private Integer lokasiId;

    public ProyekLokasiId() {}

    public ProyekLokasiId(Integer proyekId, Integer lokasiId) {
        this.proyekId = proyekId;
        this.lokasiId = lokasiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyekLokasiId that = (ProyekLokasiId) o;
        return Objects.equals(proyekId, that.proyekId) &&
                Objects.equals(lokasiId, that.lokasiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyekId, lokasiId);
    }
}
