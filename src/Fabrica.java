import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    public static List<Infante> generarInfantes(Bombo bombo, Combinacion combinacion) {
        String[] apodos = {"AMANDA", "BEATRIZ", "CARLOS", "DANIELA", "EDUARDO"};
        ArrayList<Infante> infantes = new ArrayList<>(apodos.length);
        for (String infante: apodos)
            infantes.add(new Infante(infante, bombo, combinacion));
        return infantes;
    }

    public static Bombo generarBombo(int numBolas) {
        Bombo bombo = new Bombo();
        for (int i = 0; i < numBolas; i++)
            bombo.meter(new Bola(i));
        return bombo;
    }

    public static Combinacion generarCombinacion() {
        return new Combinacion();
    }
}
