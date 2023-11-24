import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinacion {
    private final int NUMERO_BOLAS;
    private List<Bola> bolas;

    public Combinacion() {
        NUMERO_BOLAS = 5;
        this.bolas = new ArrayList<>(NUMERO_BOLAS);
    }

    public void agregar(@NotNull Bola bola) {
        bolas.add(bola);
    }

    public boolean estaCompleta(){
        return bolas.size()==NUMERO_BOLAS;
    }

    @Override
    public String toString() {
        return Arrays.toString(bolas.toArray());
    }
}
