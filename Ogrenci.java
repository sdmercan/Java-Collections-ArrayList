
public class Ogrenci {

	private String ad;
	private String soyad;
	private int ogrenciNo;
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}


	public int getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(int ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}

	public Ogrenci(String ad, String soyad, int ogrenciNo) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.ogrenciNo = ogrenciNo;
	}

	@Override
	public String toString() {
		return "Öðrenci [Ad=" + ad + ", Soyad=" + soyad + ", Öðrenci No=" + ogrenciNo + "]";
	}
	
	
}
