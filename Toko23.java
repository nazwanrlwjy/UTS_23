import java.util.Scanner;

public class Toko23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Anda: ");
        String namaPelanggan = scanner.nextLine();

        boolean isMember = false;
        double totalHargaSebelumDiskon = 0;
        double totalDiskon = 0;
        int totalItemBarang = 0;

        while (true) {
            System.out.print("Apakah Anda member (y/n)? ");
            String memberStatus = scanner.next();
            if (memberStatus.equalsIgnoreCase("y")) {
                isMember = true;
            }

            System.out.print("Masukkan nama produk yang Anda beli: ");
            String namaProduk = scanner.next();
            System.out.print("Masukkan kuantitas produk yang Anda beli: ");
            int kuantitas = scanner.nextInt();
            System.out.print("Masukkan harga satuan produk: ");
            double hargaSatuan = scanner.nextDouble();
            System.out.print("Apakah ada diskon untuk produk ini (y/n)? ");
            String adaDiskon = scanner.next();
            double diskon = 0;

            if (adaDiskon.equalsIgnoreCase("y")) {
                System.out.print("Masukkan persentase diskon: ");
                double persentaseDiskon = scanner.nextDouble();
                diskon = hargaSatuan * persentaseDiskon / 100;
            }

            double totalHargaProduk = (hargaSatuan - diskon) * kuantitas;
            totalHargaSebelumDiskon += totalHargaProduk;
            totalDiskon += diskon;
            totalItemBarang += kuantitas;

            System.out.print("Apakah Anda ingin menambahkan produk lagi (y/n)? ");
            String tambahProduk = scanner.next();
            if (!tambahProduk.equalsIgnoreCase("y")) {
                break;
            }
        }

        
        if (isMember && totalHargaSebelumDiskon >= 200000) {
            totalDiskon += 0.1 * totalHargaSebelumDiskon;
        } else if (isMember) {
            totalDiskon += 0.05 * totalHargaSebelumDiskon;
        }

        
        double totalAkhir = totalHargaSebelumDiskon - totalDiskon;

      
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Tipe Pelanggan: " + (isMember ? "Member" : "Bukan Member"));
        System.out.println("Total Item Barang: " + totalItemBarang);
        System.out.println("Total Harga Sebelum Diskon: " + totalHargaSebelumDiskon);
        System.out.println("Total Diskon: " + totalDiskon);
        System.out.println("Total Akhir: " + totalAkhir);
    }
}