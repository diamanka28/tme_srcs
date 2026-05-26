package srcs.service.calculatrice;

import srcs.service.ClientProxy;

public class CalculatriceProxy extends ClientProxy implements Calculatrice {

	public CalculatriceProxy(String nom, int po) {
		super(nom, po);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return (int) invokeService("add", new Object[] {a,b});
	}

	@Override
	public int sous(int a, int b) {
		// TODO Auto-generated method stub
		return (int) invokeService("sous", new Object[] {a,b});
	}

	@Override
	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return (int) invokeService("mult", new Object[] {a,b});
	}

	@Override
	public ResDiv div(int a, int b) {
		// TODO Auto-generated method stub
		return (ResDiv) invokeService("div", new Object[] {a,b});
	}

}
