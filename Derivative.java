public class Derivative{

	Derivative() {}  //default constructor.

	public Function findDerivative(Function f){
	
		Function yeni = new Function(f.getS());
		
		int[][] sonuc = parcala(yeni.getS());   //parcala metodu ile us ve katsayilari ayirip arraye gonderdik.
		
		for(int i=0; i<sonuc.length; i++)       //yeni katsayi = katsayi x us islemini yaptik.
			sonuc[i][1] = sonuc[i][1] * sonuc[i][0];
		
		for(int i=0; i<sonuc.length; i++)   //burada ussu bir azaltiyoruz.
			if(sonuc[i][0] != 0)
				sonuc[i][0] = sonuc[i][0] - 1;
							
		
		String polinom="";   //bu for dongusu return edecegimiz function'in stringini olusturuyor. 
		for(int i=0; i<sonuc.length-1; i++)
			if(sonuc[i][0] == 0 && sonuc[i][1] == 0){}
			
			else if(sonuc[i][0] == 0 && sonuc[i][1] > 0)
				polinom = polinom + "+" + sonuc[i][1];
			
			else if(sonuc[i][0] == 0 && sonuc[i][1] < 0 )
				polinom = polinom + sonuc[i][1];
				
			else if(sonuc[i+1][1]<0)
				polinom = polinom + sonuc[i][1] + "x^"+sonuc[i][0];
			else
				polinom = polinom + sonuc[i][1] + "x^"+sonuc[i][0]+"+";
				
			//arraydeki elemanlarin hepsini yanyana ekledik.
	
		
		if(polinom.endsWith("+"))  //string duzenleme islemi.
			polinom = polinom.substring(0,polinom.length()-1);
				
		if(polinom.indexOf("^1") >= 0)
			polinom = polinom.replace("^1","");
			
		if(polinom.indexOf("+-") >=0)
			polinom = polinom.replace("+-","-");
			
		if(polinom.indexOf("++") >=0)
			polinom = polinom.replace("++","+");
			
		
		yeni.setS(polinom);		
		return yeni;
	}
	
	private int[][] parcala(String s) {
	
		int[][] terimler = new int[20][2];   //polinomda 20 farkli katsayi olabilir. dizi boyutunu arttirabiliriz
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
