import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalBiaya = 0;

        System.out.println("Input Jenis Kendaraan");
        String kendaraan = input.nextLine().toLowerCase();

        System.out.println("Input Lama parkir (per-jam)");
        int lamaParkir = input.nextInt();

        if (kendaraan.equals("motor")) {
            if (lamaParkir <= 2){
                totalBiaya = 2000;
            } else {
                totalBiaya = 2000 + (lamaParkir - 2) * 1000;
            }

            if (totalBiaya > 10000) {
                totalBiaya = 10000;
            }

            
        } else if (kendaraan.equals("mobil")) {
            if (lamaParkir <= 2) {
                totalBiaya = 5000;
            } else {
                totalBiaya = 5000 + (lamaParkir - 2) * 2000;
            }

            if (totalBiaya > 25000) {
                totalBiaya = 25000;
            }
        } else {
            System.out.println("Tidak termasuk kategori");
            input.close();
            return;
        }

        System.out.println("- " + kendaraan + ", " + lamaParkir + ", " + totalBiaya);


    }
}