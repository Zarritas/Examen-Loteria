import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bombo {
    private List<Bola> bolas;

    public Bombo() {
        this.bolas = new ArrayList<>(10);
    }
    public void meter(@NotNull Bola bola) {
        bolas.add(bola);
    }
    public void girar() {
        Collections.shuffle(bolas);
    }
    public Bola coger() throws IllegalStateException {
        if (estaVacio()) {
            throw new IllegalStateException("No es posible coger una bola porq el bombo está vacío");
        }
        return bolas.removeFirst();
    }
    public boolean estaVacio(){
        return bolas.isEmpty();
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (Bola bola:bolas) {
//            sb.append(bola);
//        }
//        sb.append("]");
//
        return Arrays.toString(bolas.toArray());
    }
}
