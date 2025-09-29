package model;

public class FilmAction extends Film {
    private String tingkatKekerasan; // pilihan: Ringan / Sedang / Tinggi
    private String efekVisualUtama;  // pilihan: CGI / Practical Effect / Mixed

    public FilmAction(String judul, String genre, int tahunRilis, double rating, String status,
                      String tingkatKekerasan, String efekVisualUtama) {
        super(judul, genre, tahunRilis, rating, status);
        this.tingkatKekerasan = tingkatKekerasan;
        this.efekVisualUtama = efekVisualUtama;
    }

    public String getTingkatKekerasan() { return tingkatKekerasan; }
    public void setTingkatKekerasan(String tingkatKekerasan) { this.tingkatKekerasan = tingkatKekerasan; }

    public String getEfekVisualUtama() { return efekVisualUtama; }
    public void setEfekVisualUtama(String efekVisualUtama) { this.efekVisualUtama = efekVisualUtama; }

    @Override
    public void tampilkanDetail() {
        System.out.println("Film Action: " + getJudul());
        System.out.println("Genre: " + getGenre() + " | Tahun: " + getTahunRilis());
        System.out.println("Rating: " + getRating() + " | Status: " + getStatus());
        System.out.println("Tingkat Kekerasan: " + tingkatKekerasan);
        System.out.println("Efek Visual Utama: " + efekVisualUtama);
    }
}
