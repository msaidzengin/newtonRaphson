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
	
		int[][] terms = new int[20][2];
		int counter = 0;
		String whoseTerm="-5";
		String termCoefs="";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c >= '0' && c <= '9'){
			
				if(whoseTerm.equals("-5"))
					termCoefs = termCoefs + c;
				else{
					whoseTerm = whoseTerm + (c - '0');
				}
			} else if(c == 'x'){
				if(termCoefs.equals(""))
					termCoefs = "1";
				if(termCoefs.equals("-"))
					termCoefs = "-1";
				whoseTerm = "1";
			} else if(c == '^'){
				whoseTerm = "";
			} else if(c == '*' || c == ' '){
			
			} else if(c == '+'){
				updateCoefs(termCoefs, whoseTerm, terms, counter);
				counter++;
				whoseTerm = "-5";
				termCoefs = "";
			} else if(c == '-'){
				updateCoefs(termCoefs, whoseTerm, terms, counter);
				counter++;
				whoseTerm = "-5";
				termCoefs = "-";
			}
		}
		updateCoefs(termCoefs, whoseTerm, terms, counter);
		counter++;
	
		return terms;
	}

	private void updateCoefs(String katsayi, String whoseTerm, int[][] arr, int counter) {
		if(whoseTerm.equals("-5"))
			whoseTerm="0";
			
		if(!katsayi.equals("")){			
			arr[counter][0] = Integer.parseInt(whoseTerm);
			arr[counter][1] = Integer.parseInt(katsayi);
		}
	}
}
