//Kadriye YOLAGELDİ - 1220505022
//Sinem TOPBAŞ   -  1220505026

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Bina sınıfından bir örnek oluşturuldu.
        Bina bina1 = new Bina("Menekşe Mahallesi 9129 sokak ", 5);

        // EvSahibi sınıfından bir örnek oluşturuldu ve Bina örneği ile ilişkilendirildi.
        EvSahibi evSahibi1 = new EvSahibi("Selin Durmaz", "Konya\n", bina1);

        // Kiraci sınıfından bir örnek oluşturuldu, EvSahibi örneği ile ilişkilendirildi, ve daire bilgileri eklendi.
        Kiraci kiraci1 = new Kiraci("Hakan Toprak", "Konya \n", evSahibi1, 3, 16);

        // Daire sınıfından iki örnek oluşturuldu.
        Daire daire1 = new Daire("Daire 16", 3, 16);
        Daire daire2 = new Daire("Daire 20", 5, 20);

        // Kiracının oturduğu daireler listesine daire bilgileri eklendi.
        kiraci1.addApartment(daire1);
        kiraci1.addApartment(daire2);

        // Bilgiler ekrana yazdırıldı.
        System.out.println("-----------------");
        kiraci1.bilgileriGoster();
        daire1.bilgileriGoster();

        System.out.println("-----------------");

        // İkinci dairenin bilgileri ekrana yazdırıldı.
        daire2.bilgileriGoster();
        System.out.println("-----------------");

    }
}

// Bina sınıfı: Adres ve kat sayısı bilgilerini içerir.
class Bina {
    String adres;
    int katSayisi;

    public Bina(String adres, int katSayisi) {
        this.adres = adres;
        this.katSayisi = katSayisi;
    }

    // Bina bilgilerini ekrana yazdıran metot.
    public void bilgileriGoster() {
        System.out.println("Binanın Adresi: " + adres);
        System.out.println("Binanın Kat Sayısı: " + katSayisi);

        System.out.println("-----------------");
    }
}

// EvSahibi sınıfı: Ad, şehir ve bina bilgilerini içerir.
class EvSahibi {
    String ad;
    String sehir;
    Bina bina;

    public EvSahibi(String ad, String sehir, Bina bina) {
        this.ad = ad;
        this.sehir = sehir;
        this.bina = bina;
    }

    // Ev sahibi ve bina bilgilerini ekrana yazdıran metot.
    public void bilgileriGoster() {
        System.out.println("Ev Sahibinin Adı: " + ad);
        System.out.println("Ev Sahibinin Bulunduğu Şehir: " + sehir);
        System.out.println("-----------------");
        System.out.println("Ev Sahibinin Binası: ");
        bina.bilgileriGoster();
    }
}

// Kiraci sınıfı: Ad, şehir, oturulan kat ve daire numarası bilgilerini içerir.
class Kiraci {
    String ad;
    String sehir;
    int kat;
    int daireNumarasi;
    EvSahibi evSahibi;
    List<Daire> daireler;

    // Kiracı bilgilerini ve oturulan daire listesini içeren constructor.
    public Kiraci(String ad, String sehir, EvSahibi evSahibi, int kat, int daireNumarasi) {
        this.ad = ad;
        this.sehir = sehir;
        this.evSahibi = evSahibi;
        this.kat = kat;
        this.daireNumarasi = daireNumarasi;
        this.daireler = new ArrayList<>();
    }

    public Kiraci(String ad, String sehir, EvSahibi evSahibi) {
        this.ad = ad;
        this.sehir = sehir;
        this.evSahibi = evSahibi;
        this.daireler = new ArrayList<>();
    }

    // Daire ekleme metodu.
    public void addApartment(Daire daire) {
        daireler.add(daire);
    }

    // Kiracı ve oturulan daire bilgilerini ekrana yazdıran metot.
    public void bilgileriGoster() {
        System.out.println("Kiracı Bilgileri");
        System.out.println("Kiracının Adı: " + ad);
        System.out.println("Kiracının Bulunduğu Şehir: " + sehir);
        System.out.println("Kiracının Oturduğu Kat: " + kat);
        System.out.println("Kiracının Oturduğu Daire: " + daireNumarasi);
        evSahibi.bilgileriGoster();
        System.out.println("Ev Sahibinin Daireleri: ");
    }
}

// Daire sınıfı: Daire adı, kat numarası ve daire numarası bilgilerini içerir.
class Daire implements Comparable<Daire> {
    String ad;
    int kat;
    int daireNumarasi;

    public Daire(String ad, int kat, int daireNumarasi) {
        this.ad = ad;
        this.kat = kat;
        this.daireNumarasi = daireNumarasi;
    }

    // Daire bilgilerini ekrana yazdıran metot.
    public void bilgileriGoster() {
        System.out.println("Daire Adı: " + ad);
        System.out.println("Dairenin Bulunduğu Kat: " + kat);
        System.out.println("Daire Numarası: " + daireNumarasi);
    }

    // Daireleri sıralamak için kullanıldı.
    @Override
    public int compareTo(Daire digerDaire) {
        if (this.kat == digerDaire.kat) {
            return Integer.compare(this.daireNumarasi, digerDaire.daireNumarasi);
        } else {
            return Integer.compare(this.kat, digerDaire.kat);
        }
    }
}