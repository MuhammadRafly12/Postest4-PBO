/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer-GK
 */

public class FilmDrama extends Film {
    private String temaCerita;    // contoh: Keluarga / Percintaan / Hukum / dll
    private String tokohUtama;    // pilihan: Pria / Wanita

    public FilmDrama(String judul, String genre, int tahunRilis, double rating, String status,
                     String temaCerita, String tokohUtama) {
        super(judul, genre, tahunRilis, rating, status);
        this.temaCerita = temaCerita;
        this.tokohUtama = tokohUtama;
    }

    public String getTemaCerita() { return temaCerita; }
    public void setTemaCerita(String temaCerita) { this.temaCerita = temaCerita; }

    public String getTokohUtama() { return tokohUtama; }
    public void setTokohUtama(String tokohUtama) { this.tokohUtama = tokohUtama; }

    @Override
    public void tampilkanDetail() {
        System.out.println("Film Drama: " + getJudul());
        System.out.println("Genre: " + getGenre() + " | Tahun: " + getTahunRilis());
        System.out.println("Rating: " + getRating() + " | Status: " + getStatus());
        System.out.println("Tema Cerita: " + temaCerita);
        System.out.println("Tokoh Utama: " + tokohUtama);
    }
}
