import java.util.Scanner;
public class Function{

	private String s;
	
	/*
	Function() {
		s = "";
	}bos constructer eklemedim, cunku UML diagraminda yoktu
	*/
				
	Function(String s) {
		this.s = s;
	}
	
	public String getS() {
		return s;
	}
	
	public void setS(String prmtS) {
		s = prmtS;
	}
			
	public double evaluate(double x) {
		
		int[][] sonuc = parcala();  //parcala metodu polinomu 1. eleman us, 2. eleman katsayi olacak sekilde ayiriyor.
		double cevap=0;             //sonucu 2 boyutlu arraye atiyorum.
		
		for(int i=0; i < sonuc.length; i++){
			
			cevap = cevap + sonuc[i][1] * Math.pow(x,sonuc[i][0]);   // f(x) isleminin sonucu burada yapiliyor.
		
		}
		
		return cevap;
	}
	
	public int getCoef(int power) {
	
		int[][] sonuc = parcala();
		int cevap=0;
		
		for(int i=0; i<sonuc.length;i++){ //parcala metodu ile tekrar us ve katsayilari arraye atiyoruz.
			if(sonuc[i][0] == power)    //ussun katsayisi return ediliyor. 
				cevap = cevap + sonuc[i][1];
		}
		
		return cevap;
	}

	private int[][] parcala() {
	
		int[][] terimler = new int[20][2];   //polinomda suan 20 farkli katsayi olabilir. dizi boyutunu arttirabiliriz.
		int counter = 0;
		String kiminTerimi="-5";
		String terimKatsayisi="";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c >= '0' && c <= '9'){
			
				if(kiminTerimi.equals("-5"))
					terimKatsayisi = terimKatsayisi + c;
				else{
					kiminTerimi = kiminTerimi + (c - '0');
				}
			} else if(c == 'x'){
				if(terimKatsayisi.equals(""))
					terimKatsayisi = "1";
				if(terimKatsayisi.equals("-"))
					terimKatsayisi = "-1";
				kiminTerimi = "1";
			} else if(c == '^'){
				kiminTerimi = "";
			} else if(c == '*' || c == ' '){
			
			} else if(c == '+'){
				katsayilariGuncelle(terimKatsayisi, kiminTerimi, terimler, counter);
				counter++;
				kiminTerimi = "-5";
				terimKatsayisi = "";
			} else if(c == '-'){
				katsayilariGuncelle(terimKatsayisi, kiminTerimi, terimler, counter);
				counter++;
				kiminTerimi = "-5";
				terimKatsayisi = "-";
			}
		}
		katsayilariGuncelle(terimKatsayisi, kiminTerimi, terimler, counter);
		counter++;
		
		
		return terimler;
	}

	private void katsayilariGuncelle(String katsayi, String kiminTerimi, int[][] dizi, int counter) {
		if(kiminTerimi.equals("-5"))
			kiminTerimi="0";
			
		if(!katsayi.equals("")){			
			dizi[counter][0] = Integer.parseInt(kiminTerimi);
			dizi[counter][1] = Integer.parseInt(katsayi);
		}
	}
}
