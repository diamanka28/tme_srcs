package srcs.service.calculatrice;

import java.io.Serializable;

public interface Calculatrice {

	public int add(int a, int b);
	public int sous(int a, int b);
	public int mult(int a, int b);
	public ResDiv div(int a, int b);
	
	public static class ResDiv implements Serializable{
		private static final long serialVersionUID = 1L;
		private final int reste;
		private final int quotient;
		
		public ResDiv(int quo, int r) {
			this.quotient = quo;
			this.reste = r;
		}
		
		public int getReste() {
			return this.reste;
		}
		
		public int getQuotient() {
			return this.quotient;
		}
	}
}
