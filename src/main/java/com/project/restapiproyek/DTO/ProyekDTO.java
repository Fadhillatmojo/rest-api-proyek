package com.project.restapiproyek.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class ProyekDTO {
    private String namaProyek;

    private String client;

    private LocalDate tglMulai;

    private LocalDate tglSelesai;

    private String pimpinanProyek;

    private String keterangan;

    private Set<Integer> lokasiIds;
}
