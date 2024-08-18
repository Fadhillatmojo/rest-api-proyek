# REST API Proyek management Backend

Ini adalah proyek REST API yang dibangun dengan Spring Boot dan PostgreSQL. Proyek ini menyediakan layanan API untuk manajemen proyek dan lokasi.

## Prerequisites

Sebelum memulai, pastikan Anda memiliki hal berikut:

1. **Java JDK**: Pastikan Java JDK 11 atau lebih baru terinstal di sistem Anda.
2. **Maven**: Proyek ini menggunakan Maven sebagai alat manajemen proyek dan dependensi.
3. **PostgreSQL**: Pastikan PostgreSQL terinstal dan berjalan di sistem Anda.

## Clone Repositori

Clone repositori proyek dari GitHub:

```bash
git clone https://github.com/Fadhillatmojo/rest-api-proyek
```

**Konfigurasi Proyek**
Masuk ke Direktori Proyek:

```bash
cd rest-api-proyek
```
# Instalasi Dependensi:
Proyek ini menggunakan Maven untuk mengelola dependensi. Jalankan perintah berikut untuk menginstal dependensi yang diperlukan:

```bash
mvn install
```

# Konfigurasi Basis Data:
Edit file src/main/resources/application.properties untuk mengonfigurasi koneksi ke database PostgreSQL Anda. Sesuaikan pengaturan berikut sesuai dengan lingkungan pengembangan Anda:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/nama_database
spring.datasource.username=nama_pengguna
spring.datasource.password=katasandi
spring.jpa.hibernate.ddl-auto=update
```
Pastikan untuk mengganti nama_database, nama_pengguna, dan katasandi dengan nilai yang sesuai.

Menjalankan Proyek
Untuk menjalankan aplikasi Spring Boot, gunakan perintah berikut:

```bash
mvn spring-boot:run
```
Aplikasi akan berjalan di http://localhost:8080 secara default. Anda dapat mengakses endpoint API melalui URL ini.

Endpoint API
GET /api/lokasi: Mendapatkan daftar lokasi.
POST /api/lokasi: Menambahkan lokasi baru.
PUT /api/lokasi?id=: Memperbarui lokasi berdasarkan ID.
DELETE /api/lokasi?id=: Menghapus lokasi berdasarkan ID.
GET /api/findLokasiById?id=: Mendapatkan data lokasi berdasarkan ID.

GET /api/proyek: Mendapatkan proyek baru beserta lokasinya.
POST /api/proyek: Menambahkan proyek baru.
PUT /api/proyek?id=: Memperbarui proyek berdasarkan ID.
DELETE /api/proyek?id=: Menghapus proyek berdasarkan ID.
GET /api/findProyekById?id=: Mendapatkan data proyek berdasarkan ID.
