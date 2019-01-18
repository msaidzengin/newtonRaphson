public class NewtonRaphson{

	NewtonRaphson() {}

	public double findRoot(Function f, double startingpoint){
	
		Derivative b = new Derivative();
		
		double firstTerm = f.evaluate(startingpoint);
		double secondTerm = b.findDerivative(f).evaluate(startingpoint);
		double x1 = startingpoint - ( firstTerm / secondTerm );
			
		boolean control = Math.abs(x1 - startingpoint) >= 0.009;
		
		if (control)
			return findRoot(f,x1);
		else
			return x1;
	}
}
