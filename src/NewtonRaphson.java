public class NewtonRaphson{

	NewtonRaphson() {}  //default constructor.

	public double findRott(Function f, double startingpoint){
	
		Derivative b = new Derivative();
		
		double ilkTerim = f.evaluate(startingpoint);
		double ikinciTerim = b.findDerivative(f).evaluate(startingpoint);
		double x1 = startingpoint - ( ilkTerim / ikinciTerim );
		
		/*
		System.out.println("f("+startingpoint+")="+ ilkTerim );
		System.out.println("f'("+startingpoint+")="+ ikinciTerim );
		System.out.println("x1="+x1 +"\n");
		*/	
		
		boolean kontrol = Math.abs(x1 - startingpoint) >= 0.009;
		
		if (kontrol)
			return findRott(f,x1);
		else
			return x1;
	}
}
