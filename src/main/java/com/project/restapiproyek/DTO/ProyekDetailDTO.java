package com.project.restapiproyek.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class ProyekDetailDTO {
    private Integer id;
    private String namaProyek;
    private String pimpinanProyek;
    private String client;
    private LocalDate tglMulai;
    private LocalDate tglSelesai;
    private String keterangan;
    private Set<LokasiDTO> lokasiSet;

    // Getters and Setters
}
