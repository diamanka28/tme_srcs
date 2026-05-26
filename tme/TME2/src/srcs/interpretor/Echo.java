package srcs.interpretor;

import java.io.PrintStream;
import java.util.List;

public class Echo implements Command {

    private final List<String> args;

    public Echo(List<String> arguments) {
        if (!arguments.get(0).equals("echo")) {
            throw new IllegalArgumentException("Commande invalide");
        }
        this.args = arguments;
    }

    @Override
    public void execute(PrintStream out) {
        //on affiche les arguments APRÈS le nom de la commande
        for (int i = 1; i < args.size(); i++) {
            out.print(args.get(i));
            if (i < args.size() - 1) {
                out.print(" ");
            }
        }
        out.println();
    }
}
