import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {
    public static void main(String[] args) {
        Bombo bombo = Fabrica.generarBombo(10);
        Combinacion combinacion = Fabrica.generarCombinacion();
        List<Infante> infantes = Fabrica.generarInfantes(bombo, combinacion);

        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (Infante infante:infantes)
            ex.execute(infante);

        ex.shutdown();
        synchronized (combinacion) {
            while (!combinacion.estaCompleta()) {
                try {
                    combinacion.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Util.mostrarTiempo(combinacion+" 10€ en Amazon crack");
    }


}
