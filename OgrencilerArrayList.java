import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OgrencilerArrayList {

	static ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
	static Scanner input = new Scanner(System.in);
	static File ogrenciDosyasi = new File("Ogrenciler.txt");
	static FileWriter fileWrite;
	static int secim;

	public static int menu() {
		System.out.println("\n----MENÜ----" + "\n1-Ekleme" + "\n2-Silme" + "\n3-Deðiþtirme" + "\n4-Listeleme"
				+ "\n5-Arama" + "\n6-Dosyaya Kaydet" + "\n7-Çýkýþ");
		System.out.print("\nSeçiminiz : ");
		return input.nextInt();
	}

	public static void ekleme() {
		input.nextLine();
		System.out.print("\nÖðrenci Adý: ");
		String ad = input.nextLine();
		System.out.print("Öðrenci Soyadý: ");
		String soyad = input.nextLine();
		System.out.print("Öðrenci No: ");
		int ogrenciNo = input.nextInt();
		ogrenciler.add(new Ogrenci(ad, soyad, ogrenciNo));
		System.out.println(ad + " " + soyad + " eklendi.");
	}

	public static void silme() {
		listeleme();
		System.out.print("\nSilinecek Öðrenci (id): ");
		ogrenciler.remove(input.nextInt() - 1);
		System.out.println("Silindi.");
	}

	public static void degistirme() {
		listeleme();
		System.out.print("\nDeðiþtirilecek Öðrenci (id): ");
		int degistirId = input.nextInt();
		Ogrenci ogrenci = ogrenciler.get(degistirId - 1);

		input.nextLine();
		System.out.print("\nYeni Ad: ");
		String ad = input.nextLine();
		System.out.print("Yeni Soyad: ");
		String soyad = input.nextLine();
		System.out.print("Yeni No: ");
		int ogrenciNo = input.nextInt();

		ogrenci.setAd(ad);
		ogrenci.setSoyad(soyad);
		ogrenci.setOgrenciNo(ogrenciNo);
		System.out.println("Deðiþtirildi.");
	}

	public static void listeleme() {
		System.out.println("Id\t Adý  \t      Soyadý\t     Numarasý");
		System.out.println("____\t ____  \t      ______\t     ________");
		int id = 1;
		for (Ogrenci ogrenci : ogrenciler) {
			System.out.println(id + "\t " + format(ogrenci.getAd(), 13) + " " + format(ogrenci.getSoyad(), 15)
					+ ogrenci.getOgrenciNo());
			id++;
		}
	}

	public static String format(String s, int n) {
		return String.format("%-" + n + "s", s);
	}

	public static void arama() {
		input.nextLine();
		System.out.print("\nAranacak Öðrenci: ");
		String aranacak = input.nextLine();
		int bulunan = 0;
		for (Ogrenci ogrenci : ogrenciler) {
			if (ogrenci.getAd().equals(aranacak) || ogrenci.getSoyad().equals(aranacak)) {
				System.out.println("\n" + ogrenci);
				bulunan++;
			}
		}
		if (bulunan == 0) {
			System.out.println("Bulunamadý.");
		}
	}

	public static void dosyayaKaydet() throws IOException {
		fileWrite = new FileWriter("Ogrenciler.txt");
		for (Ogrenci ogrenci : ogrenciler) {
			fileWrite.write(ogrenci.getAd() + " " + ogrenci.getSoyad() + " " + ogrenci.getOgrenciNo() + "\r\n");
		}
		fileWrite.close();
		System.out.println("\nDosyaya kaydedildi.");
	}

	public static void dosyayiOku() throws FileNotFoundException {
		String ad, soyad;
		int ogrenciNo;
		String[] satir;
		if (ogrenciDosyasi.exists()) {
			Scanner reader = new Scanner(ogrenciDosyasi);
			while (reader.hasNextLine()) {
				satir = reader.nextLine().split(" ");
				if (satir.length == 3) {
					ad = satir[0];
					soyad = satir[1];
					ogrenciNo = Integer.parseInt(satir[2]);
					ogrenciler.add(new Ogrenci(ad, soyad, ogrenciNo));
				} else if (satir.length == 4) {
					ad = satir[0] + " " + satir[1];
					soyad = satir[2];
					ogrenciNo = Integer.parseInt(satir[3]);
					ogrenciler.add(new Ogrenci(ad, soyad, ogrenciNo));
				}
			}
			reader.close();
		}
	}

	public static void main(String[] args) throws IOException {

		dosyayiOku();
		do {
			secim = menu();
			switch (secim) {
			case 1:
				ekleme();
				break;
			case 2:
				silme();
				break;
			case 3:
				degistirme();
				break;
			case 4:
				listeleme();
				break;
			case 5:
				arama();
				break;
			case 6:
				dosyayaKaydet();
				break;
			}

		} while (secim != 7);
		System.out.println("\nGüle güle...");
	}

}
