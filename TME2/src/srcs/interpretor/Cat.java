package srcs.interpretor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Cat implements Command {

    private final Path fichier;

    public Cat(List<String> args) {
        if (args.size() != 2 || !args.get(0).equals("cat")) {
            throw new IllegalArgumentException("Commande cat invalide");
        }

        Path p = Path.of(args.get(1));
        if (!Files.isRegularFile(p)) {
            throw new IllegalArgumentException("Fichier invalide");
        }

        this.fichier = p;
    }

    @Override
    public void execute(PrintStream out) {
        try (FileInputStream file = new FileInputStream(fichier.toFile())) {
            int read;
            while ((read = file.read()) != -1) {
                out.write(read);
            }
        } catch (IOException e) {
            // selon l'énoncé : soit on ignore, soit on remonte
            throw new RuntimeException(e);
        }
    }
}
