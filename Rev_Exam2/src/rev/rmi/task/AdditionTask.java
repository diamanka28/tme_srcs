package rev.rmi.task;

public class AdditionTask implements Task<Double>{

	private static final long serialVersionUID = 1L;
	
	private final double a;
	private final double b;
	
	public AdditionTask(double a, double b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public Double execute() {
		// TODO Auto-generated method stub
		return this.a + this.b;
	}

}
