import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maksHariPinjam = 0;
        int denda = 0;
        String status;
        int totalDenda =0;

        System.out.println("Masukan nama anggota: ");
        String nama = input.nextLine();

        System.out.println("Masukan jenis anggota: ");
        String jenisAnggota = input.nextLine();

        System.out.println("Hari peminjaman yang sudah lewat?");
        int hariPeminjaman = input.nextInt();


        if(jenisAnggota.equals("mahasiswa")) {
            maksHariPinjam = 14;
            denda = 1000;
        } else if (jenisAnggota.equals("dosen")) {
            maksHariPinjam = 21;
            denda = 2000;
        } else if (jenisAnggota.equals("umum")) {
            maksHariPinjam = 7;
            denda = 500;
        } else {
            System.out.println("Tidak termasuk ke list anggota");
            input.close();
            return;
        }

        int totalHariTerlambat = hariPeminjaman - maksHariPinjam;


        if (totalHariTerlambat <= 0){
            status = "Tepat Waktu";
        } else if (totalHariTerlambat <= 30) {
            status = "Terlambat";
            totalDenda = totalHariTerlambat * denda;
        } else {
            status = "Suspensi";
            totalDenda = totalHariTerlambat * denda;
        }

        System.out.println("- " + nama + ", " + status + ", " + totalDenda);


    }
}