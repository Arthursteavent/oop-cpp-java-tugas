#include <iomanip>
#include <iostream>
#include <stdexcept>
#include <string>
#include <vector>

class Mahasiswa0053 {
private:
    std::string nama;
    std::string nim;
    double biayaKuliah;

public:
    Mahasiswa0053(const std::string& nama, const std::string& nim, double biayaKuliah) {
        setNama(nama);
        setNim(nim);
        setBiayaKuliah(biayaKuliah);
    }

    std::string getNama() const {
        return nama;
    }

    void setNama(const std::string& nama) {
        if (nama.empty()) {
            throw std::invalid_argument("Nama tidak boleh kosong.");
        }
        this->nama = nama;
    }

    std::string getNim() const {
        return nim;
    }

    void setNim(const std::string& nim) {
        if (nim.empty()) {
            throw std::invalid_argument("NIM tidak boleh kosong.");
        }
        this->nim = nim;
    }

    double getBiayaKuliah() const {
        return biayaKuliah;
    }

    void setBiayaKuliah(double biayaKuliah) {
        if (biayaKuliah < 0) {
            throw std::invalid_argument("Biaya kuliah tidak boleh negatif.");
        }
        this->biayaKuliah = biayaKuliah;
    }

    double hitungBiayaSetelahDiskon(double diskonPersen) const {
        if (diskonPersen < 0 || diskonPersen > 100) {
            throw std::invalid_argument("Diskon harus antara 0 sampai 100 persen.");
        }
        return biayaKuliah - (biayaKuliah * diskonPersen / 100);
    }

    void tampilkanInfo() const {
        std::cout << "Nama: " << nama
                  << "\nNIM: " << nim
                  << "\nBiaya kuliah: Rp" << std::fixed << std::setprecision(0)
                  << biayaKuliah << "\n";
    }
};

class Akademik0053 {
private:
    std::string namaProgramStudi;
    std::vector<Mahasiswa0053> daftarMahasiswa;

public:
    explicit Akademik0053(const std::string& namaProgramStudi) {
        setNamaProgramStudi(namaProgramStudi);
    }

    std::string getNamaProgramStudi() const {
        return namaProgramStudi;
    }

    void setNamaProgramStudi(const std::string& namaProgramStudi) {
        if (namaProgramStudi.empty()) {
            throw std::invalid_argument("Nama program studi tidak boleh kosong.");
        }
        this->namaProgramStudi = namaProgramStudi;
    }

    std::vector<Mahasiswa0053> getDaftarMahasiswa() const {
        return daftarMahasiswa;
    }

    void setDaftarMahasiswa(const std::vector<Mahasiswa0053>& daftarMahasiswa) {
        this->daftarMahasiswa = daftarMahasiswa;
    }

    void tambahMahasiswa(const Mahasiswa0053& mahasiswa) {
        daftarMahasiswa.push_back(mahasiswa);
    }

    double hitungTotalBiayaKuliah() const {
        double total = 0;
        for (const Mahasiswa0053& mahasiswa : daftarMahasiswa) {
            total += mahasiswa.getBiayaKuliah();
        }
        return total;
    }

    void tampilkanLaporan() const {
        std::cout << "Program Studi: " << namaProgramStudi << "\n";
        std::cout << "================================\n";
        for (const Mahasiswa0053& mahasiswa : daftarMahasiswa) {
            mahasiswa.tampilkanInfo();
            std::cout << "--------------------------------\n";
        }
        std::cout << "Total biaya kuliah: Rp" << std::fixed
                  << std::setprecision(0) << hitungTotalBiayaKuliah() << "\n";
    }
};

int main() {
    Akademik0053 akademik("Teknik Informatika");

    Mahasiswa0053 mahasiswa1("Andi", "1003260053", 32000);
    Mahasiswa0053 mahasiswa2("Siti", "1003260054", 45000);

    akademik.tambahMahasiswa(mahasiswa1);
    akademik.tambahMahasiswa(mahasiswa2);

    akademik.tampilkanLaporan();

    std::cout << "Biaya mahasiswa pertama setelah diskon 10%: Rp"
              << std::fixed << std::setprecision(0)
              << mahasiswa1.hitungBiayaSetelahDiskon(10) << "\n";

    return 0;
}
