import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;

public class Infante implements Runnable {
    private static final int TIEMPO1 = 3;   // segundos
    private static final int TIEMPO2 = 5;   // segundos
    private static final SecureRandom sr = new SecureRandom();

    private String apodo;               // No nulo
    private Bombo bombo;                // No nulo
    private Combinacion combinacion;    // No nulo

    public Infante(@NotNull String apodo, @NotNull Bombo bombo, @NotNull Combinacion combinacion) {
        this.apodo = apodo;
        this.bombo = bombo;
        this.combinacion = combinacion;
    }

    @Override
    public void run() {
        Bola bolaCopia;
        silbar();
        synchronized (bombo) {
            bombo.girar();
            Bola bolaOriginal = bombo.coger();
            bolaCopia = new Bola(bolaOriginal.getNumero());
            bombo.meter(bolaOriginal);
            cantar(bolaCopia);
        }

        synchronized (combinacion) {
            combinacion.agregar(bolaCopia);
            if (combinacion.estaCompleta())
                combinacion.notify();
        }
    }

    private void cantar(@NotNull Bola bola) {
        int tiempo = sr.nextInt(TIEMPO2+1);
        System.out.printf("[%s] BOOOOOOOOOOLAAAAAAAAAAAA %s\n", apodo, bola);
        try {
            Thread.sleep(tiempo*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void silbar() {
        int tiempo = sr.nextInt(TIEMPO1+1);
        System.out.printf("[%s] Voy a silbar dirante %d segundos\n", apodo, tiempo);
        try {
            Thread.sleep(tiempo*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return apodo;
    }
}
