package srcs.service.annuaire;

import java.util.HashMap;
import java.util.Map;

import srcs.service.AppelDistant;
import srcs.service.EtatGlobal;

@EtatGlobal
public class AnnuaireAppelDistant implements AppelDistant, Annuaire {

	private final Map<String, String> annuaire = new HashMap<>();
	
	@Override
	public synchronized String lookup(String nom) {
		// TODO Auto-generated method stub
		return annuaire.getOrDefault(nom, "");
	}

	@Override
	public synchronized void bind(String nom, String valeur) {
		// TODO Auto-generated method stub
		annuaire.put(nom, valeur);
	}

	@Override
	public synchronized void unbind(String nom) {
		// TODO Auto-generated method stub
		annuaire.remove(nom);
	}


}
