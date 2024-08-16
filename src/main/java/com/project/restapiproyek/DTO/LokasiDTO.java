package com.project.restapiproyek.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LokasiDTO {
    private Integer id;

    private String namaLokasi;

    private String negara;

    private String provinsi;

    private String kota;

    private LocalDateTime createdAt;
}
