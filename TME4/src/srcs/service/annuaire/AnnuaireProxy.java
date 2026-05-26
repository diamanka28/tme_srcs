package srcs.service.annuaire;

import srcs.service.ClientProxy;

public class AnnuaireProxy extends ClientProxy implements Annuaire {

	public AnnuaireProxy(String nom, int po) {
		super(nom, po);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String lookup(String nom) {
		// TODO Auto-generated method stub
		return (String) invokeService("lookup", new Object[] {nom}) ;
	}

	@Override
	public void bind(String nom, String valeur) {
		// TODO Auto-generated method stub
		invokeService("bind", new Object[] {nom, valeur});
	}

	@Override
	public void unbind(String nom) {
		// TODO Auto-generated method stub
		invokeService("unbind", new Object[] {nom});
	}
}
