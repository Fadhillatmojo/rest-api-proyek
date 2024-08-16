CREATE TABLE lokasi (
    id SERIAL PRIMARY KEY,
    nama_lokasi VARCHAR(255) NOT NULL,
    negara VARCHAR(255) NOT NULL,
    provinsi VARCHAR(255) NOT NULL,
    kota VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE proyek (
    id SERIAL PRIMARY KEY,
    nama_proyek VARCHAR(255) NOT NULL,
    client VARCHAR(255) NOT NULL,
    tgl_mulai TIMESTAMP NOT NULL,
    tgl_selesai TIMESTAMP,
    pimpinan_proyek VARCHAR(255) NOT NULL,
    keterangan TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE proyek_lokasi (
    proyek_id INTEGER NOT NULL,
    lokasi_id INTEGER NOT NULL,
    FOREIGN KEY (proyek_id) REFERENCES proyek(id) ON DELETE CASCADE,
    FOREIGN KEY (lokasi_id) REFERENCES lokasi(id) ON DELETE CASCADE,
	PRIMARY KEY (proyek_id, lokasi_id)
);
