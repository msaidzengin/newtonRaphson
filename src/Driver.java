public class Driver{
	public static void main(String[] args){
	
		
		Function a = new Function("3x^3-x-1");
		System.out.println("f(2)="+a.evaluate(2));

		Derivative c = new Derivative();
		System.out.println(c.findDerivative(a).getS());
		
		System.out.println(a.getCoef(3));
		System.out.println(a.getCoef(1));
		System.out.println(a.getCoef(2));
		
				
		Derivative b = new Derivative();
		System.out.println("f'(2)="+b.findDerivative(a).evaluate(2));
		
		
		
		Function y = new Function("12x^23-81x^13+1x^5 -8x +9");
		
		NewtonRaphson z = new NewtonRaphson();
		System.out.println("ans="+z.findRoot(y,2));

		
		
	}
	
}
