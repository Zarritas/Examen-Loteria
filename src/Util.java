import org.jetbrains.annotations.NotNull;

import java.time.Instant;

public class Util {
    private Util() {
    }
    public static void mostrarTiempo(@NotNull String mensaje) {
        System.out.printf("[%s] %s\n", Instant.now(), mensaje);
    }
}
