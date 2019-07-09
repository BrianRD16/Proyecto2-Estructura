
package Proyecto2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Arbol <E extends Comparable <E>> {
    
    private Nodo<E> n;

    public Nodo<E> getN() {
        return n;
    }

    public void setN(Nodo<E> n) {
        this.n = n;
    }

    public Arbol() {
        this.n = null;
    }

    public Arbol(Nodo<E> n) {
        super();
        this.n = n;
    }
    
    @Override
    public String toString() {
        return n.toString().substring(1);
    }
    
    public boolean insertar(String algo, String otro) {
        Nodo<E> padre = this.n;
        Nodo<E> actual = padre;
        Nodo<E> nuevo = new Nodo<E>(algo, otro);
        int x = 0;
        boolean lado = false;
        if (this.n == null) {
            this.n = nuevo;
            return true;
        }
        while (actual != null) {
            while (x < otro.length()) {
                padre = actual;
                if (otro.charAt(x) == '-') {
                    if (actual.getNo() == null) {
                        padre.setNo(nuevo);
                        return true;
                    } else {
                        actual = actual.getNo();
                        lado = false;
                    }
                } else {
                    if (actual.getSi() == null) {
                        padre.setSi(nuevo);
                        return true;
                    } else {
                        actual = actual.getSi();
                        lado = true;
                    }
                }
                x++;
            }
        }
        if (!lado) {
            padre.setNo(nuevo);
        } else {
            padre.setSi(nuevo);
        }
        return true;
    }
    
    public void construir(String archivo) {
        try {
            FileReader data = new FileReader(archivo);
            try (BufferedReader leer = new BufferedReader(data)) {
                String linea;
                String frase;
                String via;
                String referencia;
                
                while ((linea = leer.readLine()) != null) {
                    StringTokenizer kenizer = new StringTokenizer(linea, ",");
                    while (kenizer.hasMoreTokens()) {
                        frase = kenizer.nextToken();
                        StringTokenizer otroKenizer = new StringTokenizer(frase, "@");
                        while (otroKenizer.hasMoreTokens()) {
                            via = otroKenizer.nextToken();
                            referencia = otroKenizer.nextToken();
                            this.insertar(referencia, via);
                        }
                    }
                }
            }
        } catch (IOException e) {}
    }
    
    public void guardar() {
        try {
            FileWriter escribir = new FileWriter("src//Repositorio//memoria.txt");
            try (PrintWriter imprimir = new PrintWriter(escribir)) {
                imprimir.println(this.toString());
            }
        } catch (IOException e) {}
    }
    
    public void agregar(String a, String b, Nodo<E> c, int d) {
        switch (d) {
            case 0:
                Nodo<E> nuevo0 = new Nodo<E> (b,c.getPosicion() + "-");
                Nodo<E> renuevo0 = new Nodo<E> (a,nuevo0.getPosicion() + "+");
                nuevo0.setSi(renuevo0);
                c.setSi(nuevo0);
                break;
            case 1:
                Nodo<E> nuevo1 = new Nodo<E> (b, c.getPosicion() + "-");
                Nodo<E> renuevo1 = new Nodo<E> (a, nuevo1.getPosicion() + "+");
                nuevo1.setSi(renuevo1);
                c.setSi(nuevo1);
                break;
            default:
                Nodo<E> nuevo = new Nodo<E> (c.getPregunta(), c.getPosicion() + "-");
                Nodo<E> renuevo = new Nodo<E> (a, c.getPosicion() + "+");
                c.setPregunta(b);
                c.setNo(nuevo);
                c.setSi(renuevo);
                break;
        }
    }
    
}
