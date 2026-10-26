import java.util.ArrayList;
import java.util.List;

class Mahasiswa0053 {
    private String nama;
    private String nim;
    private double biayaKuliah;

    public Mahasiswa0053(String nama, String nim, double biayaKuliah) {
        setNama(nama);
        setNim(nim);
        setBiayaKuliah(biayaKuliah);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong.");
        }
        this.nim = nim;
    }

    public double getBiayaKuliah() {
        return biayaKuliah;
    }

    public void setBiayaKuliah(double biayaKuliah) {
        if (biayaKuliah < 0) {
            throw new IllegalArgumentException("Biaya kuliah tidak boleh negatif.");
        }
        this.biayaKuliah = biayaKuliah;
    }

    public double hitungBiayaSetelahDiskon(double diskonPersen) {
        if (diskonPersen < 0 || diskonPersen > 100) {
            throw new IllegalArgumentException("Diskon harus antara 0 sampai 100 persen.");
        }
        return biayaKuliah - (biayaKuliah * diskonPersen / 100);
    }

    public void tampilkanInfo() {
        System.out.printf("Nama: %s%nNIM: %s%nBiaya kuliah: Rp%.0f%n",
                nama, nim, biayaKuliah);
    }
}

class Akademik0053 {
    private String namaProgramStudi;
    private List<Mahasiswa0053> daftarMahasiswa;

    public Akademik0053(String namaProgramStudi) {
        setNamaProgramStudi(namaProgramStudi);
        daftarMahasiswa = new ArrayList<>();
    }

    public String getNamaProgramStudi() {
        return namaProgramStudi;
    }

    public void setNamaProgramStudi(String namaProgramStudi) {
        if (namaProgramStudi == null || namaProgramStudi.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama program studi tidak boleh kosong.");
        }
        this.namaProgramStudi = namaProgramStudi;
    }

    public List<Mahasiswa0053> getDaftarMahasiswa() {
        return new ArrayList<>(daftarMahasiswa);
    }

    public void setDaftarMahasiswa(List<Mahasiswa0053> daftarMahasiswa) {
        if (daftarMahasiswa == null) {
            throw new IllegalArgumentException("Daftar mahasiswa tidak boleh null.");
        }
        for (Mahasiswa0053 mahasiswa : daftarMahasiswa) {
            if (mahasiswa == null) {
                throw new IllegalArgumentException("Daftar tidak boleh berisi mahasiswa null.");
            }
        }
        this.daftarMahasiswa = new ArrayList<>(daftarMahasiswa);
    }

    public void tambahMahasiswa(Mahasiswa0053 mahasiswa) {
        if (mahasiswa == null) {
            throw new IllegalArgumentException("Mahasiswa tidak boleh null.");
        }
        daftarMahasiswa.add(mahasiswa);
    }

    public double hitungTotalBiayaKuliah() {
        double total = 0;
        for (Mahasiswa0053 mahasiswa : daftarMahasiswa) {
            total += mahasiswa.getBiayaKuliah();
        }
        return total;
    }

    public void tampilkanLaporan() {
        System.out.println("Program Studi: " + namaProgramStudi);
        System.out.println("================================");
        for (Mahasiswa0053 mahasiswa : daftarMahasiswa) {
            mahasiswa.tampilkanInfo();
            System.out.println("--------------------------------");
        }
        System.out.printf("Total biaya kuliah: Rp%.0f%n", hitungTotalBiayaKuliah());
    }
}

public class Main {
    public static void main(String[] args) {
        Akademik0053 akademik = new Akademik0053("Teknik Informatika");

        Mahasiswa0053 mahasiswa1 = new Mahasiswa0053("Andi", "1003260053", 32000);
        Mahasiswa0053 mahasiswa2 = new Mahasiswa0053("Siti", "1003260054", 45000);

        akademik.tambahMahasiswa(mahasiswa1);
        akademik.tambahMahasiswa(mahasiswa2);

        akademik.tampilkanLaporan();

        System.out.printf("Biaya mahasiswa pertama setelah diskon 10%%: Rp%.0f%n",
                mahasiswa1.hitungBiayaSetelahDiskon(10));
    }
}
