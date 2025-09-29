/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author Acer-GK
 */


package main;

import model.Film;
import model.FilmAction;
import model.FilmDrama;
import service.FilmService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilmService service = new FilmService();
        boolean running = true;

        while (running) {
            System.out.println("\n====================================");
            System.out.println("        SISTEM MANAJEMEN FILM");
            System.out.println("====================================");
            System.out.println("1. Tambah Film");
            System.out.println("2. Lihat Film");
            System.out.println("3. Update Film");
            System.out.println("4. Hapus Film");
            System.out.println("5. Keluar");
            System.out.println("====================================");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahFilm(scanner, service);
                    break;

                case 2:
                    service.tampilkanFilm();
                    System.out.print("Lihat detail film? (y/n): ");
                    String detail = scanner.nextLine();
                    if (detail.equalsIgnoreCase("y")) {
                        System.out.print("Masukkan nomor film: ");
                        int idxDetail = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (idxDetail >= 0 && idxDetail < service.getDaftarFilm().size()) {
                            Film f = service.getDaftarFilm().get(idxDetail);
                            System.out.println("\n--- DETAIL FILM ---");
                            f.tampilkanDetail();
                        } else {
                            System.out.println("Nomor film tidak valid.");
                        }
                    }
                    break;

                case 3:
                    service.tampilkanFilm();
                    System.out.print("Nomor film yang ingin diupdate: ");
                    int idxUpdate = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (idxUpdate >= 0 && idxUpdate < service.getDaftarFilm().size()) {
                        tambahFilm(scanner, service, idxUpdate);
                    } else {
                        System.out.println("Nomor tidak valid!");
                    }
                    break;

                case 4:
                    service.tampilkanFilm();
                    System.out.print("Nomor film yang ingin dihapus: ");
                    int idxHapus = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (service.hapusFilm(idxHapus)) {
                        System.out.println("Film berhasil dihapus!");
                    } else {
                        System.out.println("Nomor tidak valid!");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }

    private static void tambahFilm(Scanner scanner, FilmService service) {
        tambahFilm(scanner, service, -1);
    }

    private static void tambahFilm(Scanner scanner, FilmService service, int updateIndex) {
        System.out.println("\nPilih Jenis Film:");
        System.out.println("1. Film Action");
        System.out.println("2. Film Drama");
        System.out.print("Masukkan pilihan: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Tahun Rilis: ");
        int tahun = scanner.nextInt();
        System.out.print("Rating: ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Status: ");
        String status = scanner.nextLine();

        Film filmBaru = null;

        if (jenis == 1) {
            // pilih tingkat kekerasan
            System.out.println("Pilih Tingkat Kekerasan: 1.Ringan  2.Sedang  3.Tinggi");
            int tk = scanner.nextInt();
            scanner.nextLine();
            String tingkatKekerasan = switch (tk) {
                case 1 -> "Ringan";
                case 2 -> "Sedang";
                case 3 -> "Tinggi";
                default -> "Ringan";
            };

            // pilih efek visual
            System.out.println("Pilih Efek Visual Utama: 1.CGI  2.Practical  3.Mixed");
            int ev = scanner.nextInt();
            scanner.nextLine();
            String efekVisualUtama = switch (ev) {
                case 1 -> "CGI";
                case 2 -> "Practical";
                case 3 -> "Mixed";
                default -> "CGI";
            };

            filmBaru = new FilmAction(judul, genre, tahun, rating, status, tingkatKekerasan, efekVisualUtama);

        } else if (jenis == 2) {
            System.out.print("Tema Cerita: ");
            String temaCerita = scanner.nextLine();

            // pilih tokoh utama
            System.out.println("Pilih Tokoh Utama: 1.Pria  2.Wanita");
            int tu = scanner.nextInt();
            scanner.nextLine();
            String tokohUtama = (tu == 2) ? "Wanita" : "Pria";

            filmBaru = new FilmDrama(judul, genre, tahun, rating, status, temaCerita, tokohUtama);

        } else {
            System.out.println("Pilihan jenis film tidak valid!");
            return;
        }

        if (updateIndex >= 0) {
            service.updateFilm(updateIndex, filmBaru);
            System.out.println("Film berhasil diperbarui!");
        } else {
            service.tambahFilm(filmBaru);
        }
    }
}
