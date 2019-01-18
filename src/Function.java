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
		int[][] terms = new int[20][2];
		int counter = 0;
		String whoseTerm="-5";
		String termCoefficient="";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c >= '0' && c <= '9'){
			
				if(whoseTerm.equals("-5"))
					termCoefficient = termCoefficient + c;
				else{
					whoseTerm = whoseTerm + (c - '0');
				}
			} else if(c == 'x'){
				if(termCoefficient.equals(""))
					termCoefficient = "1";
				if(termCoefficient.equals("-"))
					termCoefficient = "-1";
				whoseTerm = "1";
			} else if(c == '^'){
				whoseTerm = "";
			} else if(c == '*' || c == ' '){
			
			} else if(c == '+'){
				updateCoefs(termCoefficient, whoseTerm, terms, counter);
				counter++;
				whoseTerm = "-5";
				termCoefficient = "";
			} else if(c == '-'){
				updateCoefs(termCoefficient, whoseTerm, terms, counter);
				counter++;
				whoseTerm = "-5";
				termCoefficient = "-";
			}
		}
		updateCoefs(termCoefficient, whoseTerm, terms, counter);
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
