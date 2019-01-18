public class Derivative{

	Derivative() {}

	public Function findDerivative(Function f){
		Function func = new Function(f.getS());
		int[][] ans = seperate(func.getS());
		
		for(int i=0; i<ans.length; i++)
			ans[i][1] = ans[i][1] * ans[i][0];
		
		for(int i=0; i<ans.length; i++)
			if(ans[i][0] != 0)
				ans[i][0] = ans[i][0] - 1;
							
		
		String polynom = "";
		for(int i=0; i<ans.length-1; i++)
			if(ans[i][0] == 0 && ans[i][1] == 0){}
			
			else if(ans[i][0] == 0 && ans[i][1] > 0)
				polynom = polynom + "+" + ans[i][1];
			
			else if(ans[i][0] == 0 && ans[i][1] < 0 )
				polynom = polynom + ans[i][1];
				
			else if(ans[i+1][1]<0)
				polynom = polynom + ans[i][1] + "x^"+ans[i][0];
			else
				polynom = polynom + ans[i][1] + "x^"+ans[i][0]+"+";
					
		
		if(polynom.endsWith("+"))
			polynom = polynom.substring(0,polynom.length()-1);
				
		if(polynom.indexOf("^1") >= 0)
			polynom = polynom.replace("^1","");
			
		if(polynom.indexOf("+-") >=0)
			polynom = polynom.replace("+-","-");
			
		if(polynom.indexOf("++") >=0)
			polynom = polynom.replace("++","+");
			
		
		func.setS(polynom);		
		return func;
	}
	
	private int[][] seperate(String s) {
	
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
