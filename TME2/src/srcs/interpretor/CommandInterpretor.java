package srcs.interpretor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CommandInterpretor {

	private final Map<String, Class<? extends Command>> commands;
	
	@SuppressWarnings("unchecked")
	public CommandInterpretor(String fichier) throws Exception {
	    // 1) constructeur par défaut
	    this();

	    try (ObjectInputStream ois =
	             new ObjectInputStream(new FileInputStream(fichier))) {

	        // 2) commandes internes
	        Map<String, Class<? extends Command>> internes =
	            (Map<String, Class<? extends Command>>) ois.readObject();

	        commands.putAll(internes);

	        // 3) commandes externes
	        Map<String, String[]> externes =
	            (Map<String, String[]>) ois.readObject();

	        for (Map.Entry<String, String[]> e : externes.entrySet()) {
	            String nomCommande = e.getKey();
	            String chemin = e.getValue()[0];
	            String nomClasse = e.getValue()[1];

	            File f = new File(chemin);
	            URL url = f.toURI().toURL();

	            URLClassLoader loader = new URLClassLoader(
	                new URL[] { url },
	                this.getClass().getClassLoader()
	            );

	            Class<?> cl = loader.loadClass(nomClasse);
	            Class<? extends Command> clcmd = cl.asSubclass(Command.class);

	            commands.put(nomCommande, clcmd);
	            loader.close();
	        }

	    } catch (Exception e) {
	        throw new IllegalArgumentException("Erreur lors du chargement", e);
	    }
	}

	public CommandInterpretor() {
		commands =new HashMap<String, Class<? extends Command>>();
		commands.put("echo", Echo.class);
		commands.put("cat", Cat.class);
		//classe interne
		commands.put("deploy", Deploy.class);
		commands.put("undeploy", Undeploy.class);
		commands.put("save", Save.class);
	}

	public Class<? extends Command> getClassOf(String commande){
		return this.commands.get(commande);
	}
	public Map<String, Class<? extends Command>> getCommands() {
		return this.commands;
	}
	
	//classe interne Deploy
	public class Deploy implements Command{
		private final String cmd;
		private final String chemin_class, nom_class;
		
		public Deploy(List<String> args) {
			if(args.size() != 4 || !args.get(0).equals("deploy")) {
				throw new IllegalArgumentException("Nombre d'argument incorrect");
			}
			this.cmd = args.get(1);
			this.chemin_class = args.get(2);
			this.nom_class = args.get(3);
		}

		@Override
		public void execute(PrintStream out) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			if(commands.containsKey(cmd)) {
				throw new IllegalArgumentException("la commande existe déja");
			}
			try {
				Path p = Path.of(this.chemin_class);
				File f = p.toFile();
				if(!f.exists() || !f.isDirectory()) {
					throw new IllegalArgumentException("Chemin inexistant");
				}
				// file à url
				URL url = f.toURI().toURL();
				// la classe classloader
				
				URLClassLoader loader = new URLClassLoader(new URL[] {url});
				//charger la classe
				Class<?> cl = loader.loadClass(this.nom_class);
				// est ce une classe Command
				Class<? extends Command> clcmd = cl.asSubclass(Command.class);
				
				//ajouter 
				commands.put(cmd, clcmd);
			
				loader.close();
			}catch(Exception e) {
				throw new IllegalArgumentException("Erreur d'ajout");
			}
		}
	}
	//classe interne Undeploy
	public class Undeploy implements Command{
		private final String cmd;
		public Undeploy(List<String> comm) {
			if(comm.size() != 2 || !comm.get(0).equals("undeploy")) {
				throw new IllegalArgumentException();
			}
			this.cmd = comm.get(1);
		}
	
		@Override
		public void execute(PrintStream out) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			if(!commands.containsKey(this.cmd)) {
				throw new IllegalArgumentException("commande inexistante");
			}
			
			commands.remove(this.cmd);
		}
	}
	
	//classe interne Save
	public class Save implements Command{

		private final String fichier;
		//constructeur
		public Save(List<String> args) {
			if(args.size() != 2 || !args.get(0).equals("save")) {
				throw new IllegalArgumentException();
			}
			
			this.fichier = args.get(1);
		}
		
		@Override
		public void execute(PrintStream out) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			try (ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(this.fichier))){
				
				// commandes internes
				Map<String, Class<? extends Command>> internes = new HashMap<>();
				// commandes externes
				Map<String, String[]> externes = new HashMap<>();
				
				for (Map.Entry<String, Class<? extends Command>> e :
	                CommandInterpretor.this.commands.entrySet()) {

		            Class<? extends Command> cl = e.getValue();
	
		            // commande interne : classe membre de CommandInterpretor
		            if (cl.isMemberClass()
		                && cl.getEnclosingClass() == CommandInterpretor.class) {
	
		                internes.put(e.getKey(), cl);
	
		            } else {
		                // commande externe
		                ClassLoader loader = cl.getClassLoader();
	
		                if (loader instanceof URLClassLoader) {
		                    URLClassLoader urlLoader = (URLClassLoader) loader;
		                    URL[] urls = urlLoader.getURLs();
	
		                    externes.put(
		                        e.getKey(),
		                        new String[] {
		                            urls[0].getFile(),   // chemin du dossier / jar
		                            cl.getName()         // nom absolu de la classe
		                        }
		                    );
		                    urlLoader.close();
		                }
		            }
		        }
				oos.writeObject(internes);
				oos.writeObject(externes);
			
			}catch (IOException e) {
				throw new IllegalArgumentException("Erreur Sauvegarde", e);
			}
		}
	}
	
	public void perform(String cmd, PrintStream out) throws Exception{
		List<String> mots = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(cmd, " ");
		
		while (st.hasMoreTokens()) {
		    mots.add(st.nextToken());
		}
		//commande vide
		if(mots.isEmpty()) return;
		//recuperer le premier string de la commande
		String cmd1 = mots.get(0);
		if(!commands.containsKey(cmd1)) throw new CommandNotFoundException();
		
		Class<? extends Command> classe = commands.get(cmd1);
		if(classe.getEnclosingClass() == CommandInterpretor.class) {
			Command exec = classe.getConstructor(CommandInterpretor.class,List.class).newInstance(this,mots);

			exec.execute(out);
		}else {
			Class<? extends Command> cls = classe.asSubclass(Command.class);
			Command exec = cls.getConstructor(List.class).newInstance(mots);
			
			exec.execute(out);
		}
	}
}
