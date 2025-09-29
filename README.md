# Sistem Manajemen Film (Post Test PBO)

Program ini adalah aplikasi console untuk mengelola data film.  
User dapat menambah, melihat, memperbarui, menghapus, dan memberikan ulasan pada film.  
Program mendukung dua jenis film: Film Action dan Film Drama.

## Alur Program
1. Program dimulai dari `Main.java` dan menampilkan menu utama:
   - **1. Tambah Film**  
     Pengguna memilih jenis film (Action atau Drama).  
     Program meminta input atribut umum (judul, genre, tahun rilis, rating, status)  
     dan atribut khusus sesuai jenis film:  
       • Film Action → tingkat kekerasan & efek visual utama (pilihan)  
       • Film Drama → tema cerita & tokoh utama (pria/wanita).  
     Data film baru ditambahkan ke daftar.



   - **2. Lihat Film**  
     Menampilkan daftar semua film dalam bentuk tabel.  
     Pengguna dapat memilih untuk melihat detail film tertentu.  
     Detail ditampilkan dengan memanggil `tampilkanDetail()` (overriding di masing-masing subclass).

<img width="783" height="419" alt="image" src="https://github.com/user-attachments/assets/f303f1cc-e605-4f8f-abd7-82e7c97e00ba" />

   - **3. Update Film**  
     Menampilkan daftar film, pengguna memilih nomor film yang akan diupdate.  
     Program memanggil kembali proses input film (seperti Tambah Film)  
     kemudian mengganti data film lama dengan data baru pada index tersebut.

<img width="851" height="575" alt="image" src="https://github.com/user-attachments/assets/4d10e08a-5687-4c01-a5e9-18c44c87c830" />


   - **4. Hapus Film**  
     Menampilkan daftar film, pengguna memilih nomor film yang akan dihapus.  
     Program menghapus film pada index tersebut dari daftar.

<img width="831" height="228" alt="image" src="https://github.com/user-attachments/assets/f4f096b5-80fe-46d3-b5f8-e08ec26d96e5" />


   - **5. Keluar**  
     Program berhenti.
   - (Opsional) **Beri Ulasan**  
     Pengguna dapat memberi ulasan dan skor pada film yang mengimplementasikan interface `Reviewable`.

<img width="672" height="193" alt="image" src="https://github.com/user-attachments/assets/406e8a2d-f652-4abe-8e9f-7e11b8967069" />


## Struktur Paket
- `main`  
  - `Main.java` (program utama)
- `model`  
  - `Film.java` (abstract class)
  - `FilmAction.java` (subclass Film)
  - `FilmDrama.java` (subclass Film)
  - `Reviewable.java` (interface)
- `service`  
  - `FilmService.java` (CRUD data film)

<img width="256" height="250" alt="image" src="https://github.com/user-attachments/assets/4b5664ab-c2e6-44c9-ae6d-b826331867b4" />


## Penerapan Abstraction
- **Abstract Class**: `Film` di package `model` adalah abstract class yang menjadi dasar bagi `FilmAction` dan `FilmDrama`.
  - Method `tampilkanDetail()` dideklarasikan abstract di `Film` dan dioverride di subclass.
 
<img width="1198" height="441" alt="image" src="https://github.com/user-attachments/assets/96c8c22f-e8c3-43a6-bf0f-edfac6476ee0" />

<img width="958" height="97" alt="image" src="https://github.com/user-attachments/assets/439f7719-bfa4-4f84-bdf1-fbe7cf5f543c" />


- **Interface**: `Reviewable` di package `model` adalah interface yang mengatur fungsi `beriUlasan()` dan `tampilkanUlasan()`.  
  `FilmAction` dan `FilmDrama` mengimplementasikan interface ini.

<img width="700" height="174" alt="image" src="https://github.com/user-attachments/assets/208b8d0b-472f-4354-9a4a-eac5184933a9" />


## Penerapan Polymorphism
- **Overriding**: 
  - Method `tampilkanDetail()` dioverride di `FilmAction` dan `FilmDrama` untuk menampilkan detail sesuai jenis film masing-masing.

<img width="1137" height="265" alt="image" src="https://github.com/user-attachments/assets/2463870d-096d-48ad-b483-48110498dc5d" />

<img width="1156" height="264" alt="image" src="https://github.com/user-attachments/assets/d723742b-4355-4511-8d14-5c4039a87d96" />
 
- **Overloading**:
  - Method `tambahFilm()` di `Main.java` dibuat dua versi:
    - `tambahFilm(Scanner scanner, FilmService service)` (untuk tambah baru)

<img width="999" height="90" alt="image" src="https://github.com/user-attachments/assets/962e5853-56e4-42c5-86f7-64c8a92fe770" />

    
    - `tambahFilm(Scanner scanner, FilmService service, int updateIndex)` (untuk update data film)
   
<img width="1294" height="195" alt="image" src="https://github.com/user-attachments/assets/614649cf-8ce2-4973-9303-be7264742f29" />
