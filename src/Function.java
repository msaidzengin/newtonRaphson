import java.util.Scanner;
public class Function{
	private String s;
	Function() {
		s = "";
	}			
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
		int[][] polynom = seperate();  
		double answer=0; 
		for(int i=0; i < polynom.length; i++)
			answer = answer + polynom[i][1] * Math.pow(x,polynom[i][0]);
		return answer;
	}
	public int getCoef(int power) {
		int[][] polynom = seperate();
		int ans=0;
		for(int i=0; i<polynom.length;i++)
			if(polynom[i][0] == power)
				ans = ans + polynom[i][1];
		return ans;
	}
	private int[][] seperate() {
		int[][] terimler = new int[20][2];
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
