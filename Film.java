package model;

public abstract class Film {
    private String judul;
    private String genre;
    private int tahunRilis;
    private double rating;
    private String status;

    public Film(String judul, String genre, int tahunRilis, double rating, String status) {
        this.judul = judul;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.rating = rating;
        this.status = status;
    }

    // Getter & Setter
    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // setiap subclass wajib mengimplementasikan cara menampilkan detailnya
    public abstract void tampilkanDetail();
}
