import java.util.ArrayList;
import java.util.Scanner;

class Complain {
    int id;
    String nama;
    String judul;
    String deskripsi;
    String kategori;
    String status;

    Complain (int id, String nama, String judul, String deskripsi, String kategori,  String status) {
        this.id = id;
        this.nama = nama;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.status = "Dikirim";
    }
}
public class App {
    
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Complain> complains = new ArrayList<>();

    static int nextId = 1;
    public static void main(String[] args) {
        int pilihan;

        do{
            System.out.println("=== Complain Online ===");
            System.out.println("1. Buat Pengaduan");
            System.out.println("2. Lihat Pengaduan");
            System.out.println("3. Cari Pengaduan");
            System.out.println("4. Update Pengaduan");
            System.out.println("5. Statistik Pengaduan");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahPengaduan();
                    break;
                case 2:
                    lihatPengaduan();
                    break;
                case 3:
                    cariPengaduan();
                    break;
                case 4:
                    updatePengaduan();
                    break;
                case 5:
                    statistikPengaduan();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);
    }

    static void tambahPengaduan() {
        System.out.println("===== Buat Pengaduan =====");

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan judul pengaduan: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan deskripsi pengaduan: ");
        String deskripsi = scanner.nextLine();

        System.out.print("Masukkan kategori pengaduan: ");
        String kategori = scanner.nextLine();

        Complain complain = new Complain(nextId++, nama, judul, deskripsi, kategori, "Dikirim");

        complains.add(complain);
        
        System.out.println("Pengaduan berhasil ditambahkan.");
        System.out.println("ID Pengaduan: " + nextId);

        nextId++;        
    }
    
    static void lihatPengaduan() {
        System.out.println("===== Lihat Pengaduan =====");
        if (complains.isEmpty()) {
            System.out.println("Belum ada pengaduan yang dibuat.");
        } else {
            for (Complain complain : complains) {
                System.out.println("ID: " + complain.id);
                System.out.println("Nama: " + complain.nama);
                System.out.println("Judul: " + complain.judul);
                System.out.println("Deskripsi: " + complain.deskripsi);
                System.out.println("Kategori: " + complain.kategori);
                System.out.println("Status: " + complain.status);
                System.out.println("-------------------------");
            }
        }
    }

    static void cariPengaduan() {
        System.out.println("===== Cari Pengaduan =====");
        System.out.print("Masukkan ID pengaduan: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (Complain complain : complains) {
            if (complain.id == id) {
                System.out.println("ID: " + complain.id);
                System.out.println("Nama: " + complain.nama);
                System.out.println("Judul: " + complain.judul);
                System.out.println("Deskripsi: " + complain.deskripsi);
                System.out.println("Kategori: " + complain.kategori);
                System.out.println("Status: " + complain.status);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pengaduan dengan ID " + id + " tidak ditemukan.");
        }
    }

    static void updatePengaduan() {
        System.out.println("===== Update Pengaduan =====");
        System.out.print("Masukkan ID pengaduan yang ingin diupdate: ");
        int id = scanner.nextInt();
        int statusBaru;
        scanner.nextLine(); 

        boolean found = false;
        for (Complain complain : complains) {
            if (complain.id == id) {
                System.out.println("=== Masukan Status Baru ===");
                System.out.println("1. Dikirim");
                System.out.println("2. Diproses");
                System.out.println("3. Selesai");
                System.out.println("4. Di tolak");
                statusBaru  = scanner.nextInt();
                scanner.nextLine(); 

                switch(statusBaru) {
                    case 1:
                        complain.status = "Dikirim";
                        break;
                    case 2:
                        complain.status = "Diproses";
                        break;
                    case 3:
                        complain.status = "Selesai";
                        break;
                    case 4:
                        complain.status = "Di tolak";
                        break;
                    default:
                        System.out.println("Status tidak valid. Status tidak diperbarui.");
                        return;
                }

                System.out.println("Status pengaduan berhasil diperbarui.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pengaduan dengan ID " + id + " tidak ditemukan.");
        }
    }

    static void statistikPengaduan() {
        int dikirim = 0;
        int diproses = 0;
        int selesai = 0;
        int ditolak = 0;

        for (Complain complain : complains) {
            switch (complain.status) {
                case "Dikirim":
                    dikirim++;
                    break;
                case "Diproses":
                    diproses++;
                    break;
                case "Selesai":
                    selesai++;
                    break;
                case "Di tolak":
                    ditolak++;
                    break;
            }
        }
        
        System.out.println("===== Statistik Pengaduan =====");
        int totalPengaduan = complains.size();
        System.out.println("Total Pengaduan: " + totalPengaduan);
        System.out.println("Dikirim: " + dikirim);
        System.out.println("Diproses: " + diproses);
        System.out.println("Selesai: " + selesai);
        System.out.println("Di tolak: " + ditolak);
    }
}
