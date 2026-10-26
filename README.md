# Tugas Praktik 1 - Perancangan Kelas dan Objek

**Nama:** Arthur Steavent Hamonangan Simanjuntak  
**NIM:** 1003260053  
**Mata Kuliah:** IF104 Pemrograman Berorientasi Objek

## 1. Penentuan Kasus

Kasus yang digunakan adalah pengelolaan data mahasiswa pada bidang akademik.

Berdasarkan NIM 1003260053:
- Digit terakhir NIM adalah 3, sehingga domain yang digunakan adalah Akademik.
- Digit ke-4 dan ke-5 adalah 32, sehingga nilai dasar biaya kuliah adalah 32.000.
- Empat digit terakhir NIM adalah 0053, sehingga nama class utama adalah `Mahasiswa0053`.

Program ini menggunakan dua data mahasiswa dengan nama, NIM, dan biaya kuliah yang berbeda.

## 2. Struktur Folder

File dalam tugas ini dibagi menjadi beberapa bagian:

- `src/java/Main.java` — program Java.
- `src/cpp/main.cpp` — program C++.
- `output/java-output.txt` — contoh hasil program Java.
- `output/cpp-output.txt` — contoh hasil program C++.

## 3. Cara Menjalankan Program

### Java

Pastikan Java sudah terpasang. Cek melalui Terminal:

```bash
java -version
javac -version
```

Kemudian jalankan perintah berikut dari folder utama tugas:

```bash
mkdir -p build/java
javac -d build/java src/java/Main.java
java -cp build/java Main
```

### C++

Pastikan compiler C++ sudah tersedia:

```bash
g++ --version
```

Kompilasi dan jalankan program dengan perintah berikut:

```bash
mkdir -p build/cpp
g++ -std=c++17 src/cpp/main.cpp -o build/cpp/main
./build/cpp/main
```

Jika program berhasil dijalankan, hasilnya akan muncul di Terminal.

## 4. Penjelasan Singkat Program

Program ini dibuat untuk menerapkan konsep dasar pemrograman berorientasi objek.

Class `Mahasiswa0053` digunakan untuk menyimpan data mahasiswa, seperti nama, NIM, dan biaya kuliah. Class `Akademik0053` digunakan untuk mengelola data mahasiswa.

Di dalam program terdapat constructor, getter, setter, dan method untuk menghitung biaya kuliah setelah diskon serta total biaya kuliah seluruh mahasiswa.

Data disimpan dalam dua object mahasiswa agar perbedaan data dan hasil perhitungan bisa dilihat.

