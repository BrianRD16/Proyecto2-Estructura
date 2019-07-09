
package Proyecto2;

public class Nodo <E extends Comparable<E>> {
    
    private String pregunta;
    private String posicion;
    private Nodo<E> si;
    private Nodo<E> no;
    
    public Nodo() {
        this.pregunta = null;
        this.posicion = null;
        this.si = null;
        this.no = null;
    }
    
    public Nodo(String pregunta, String posicion, Nodo<E> si, Nodo<E> no) {
        super();
        this.pregunta = pregunta;
        this.posicion = posicion;
        this.si = si;
        this.no = no;
    }
    
    public Nodo(String pregunta, String posicion) {
        super();
        this.pregunta = pregunta;
        this.posicion = posicion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getPosicion() {
        return posicion;
    }

    public Nodo getSi() {
        return si;
    }

    public Nodo getNo() {
        return no;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setSi(Nodo si) {
        this.si = si;
    }

    public void setNo(Nodo no) {
        this.no = no;
    }
    
    @Override
    public String toString() {
        if (si == null && no == null) {
            return "," + posicion + "@" + pregunta;
        } else if (si == null && no != null) {
            return "," + posicion + "@" + pregunta + no;
        } else if (si != null && no == null) {
            return "," + posicion + "@" + pregunta + si;
        }
        return "," + posicion + "@" + pregunta + si + no;
    }
}
