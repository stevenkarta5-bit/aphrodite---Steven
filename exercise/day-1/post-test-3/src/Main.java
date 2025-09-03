import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String status;
        double potongan = 0.0;

        System.out.println("Masukan nama Karyawan: ");
        String nama = input.nextLine();

        System.out.println("Masukan jam masuk (format dalam satuan hhmm, cnth: 1245 = 12:45): ");
        int clockIn = input.nextInt();

        System.out.println("Masukan gaji harian: ");
        double gajiHarian = input.nextDouble();

        if(clockIn <= 800) {
            status = "Tepat waktu";
            potongan = 0.0;
        } else if (clockIn >= 801 && clockIn <= 815 ) {
            status = "Terlambat ringan";
            potongan = 0.01 * gajiHarian;
        } else if (clockIn >= 816 && clockIn <= 830) {
            status = "Terlambat Sedang";
            potongan = 0.03 * gajiHarian;
        } else {
            status = "Terlamat Berat";
            potongan = 0.05 * gajiHarian;
        }

        double gajiBersih = gajiHarian - potongan;

        System.out.println("- " + nama + ", " + status + ", " + potongan + ", " + gajiBersih);


    }
}