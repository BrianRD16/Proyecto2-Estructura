
package Proyecto2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Juego <E extends Comparable <E>> extends JFrame implements ActionListener {
    
    private Arbol<E> arbol;
    private Nodo<E> nodo;
    private JButton si, no, salir;
    private boolean ganador;

    public Juego(Arbol<E> arbol) {
        super();
        this.setArbol(arbol);
        this.getArbol().construir("src//Repositorio//memoria.txt");
        this.nodo = arbol.getN();
        this.ganador = false;
        
        this.setUndecorated(true);
        this.setFocusable(true);
        this.setVisible(true);
        this.setSize(450, 180);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.setLocationRelativeTo(null);
        
        this.si = new JButton("Si");
        this.si.setBounds(30, this.getHeight() - 40, 130, 30);
        this.add(this.si);
        this.si.addActionListener(this);
        this.si.setVisible(true);
        
        this.no = new JButton("No");
        this.no.setBounds(170, this.getHeight() - 40, 130, 30);
        this.add(this.no);
        this.no.addActionListener(this);
        this.no.setVisible(true);
        
        this.salir = new JButton("Salir");
        this.salir.setBounds(350, this.getHeight() - 40, 90, 30);
        this.add(this.salir);
        this.salir.addActionListener(this);
        this.salir.setVisible(true);
    }

    public Arbol<E> getArbol() {
        return arbol;
    }

    public Nodo<E> getNodo() {
        return nodo;
    }

    public boolean isGanador() {
        return ganador;
    }

    public Arbol<E> getRoot() {
        return getArbol();
    }

    public void setArbol(Arbol<E> arbol) {
        this.arbol = arbol;
    }

    public void setNodo(Nodo<E> nodo) {
        this.nodo = nodo;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public void setRoot(Arbol<E> arbol) {
        this.setArbol(arbol);
    }
    
    public String recorrer(boolean bool) {
        if (this.nodo.getNo() == null && this.nodo.getSi() == null) {
            if (bool == false) {
                this.getArbol().agregar(new JOptionPane().showInputDialog("No se! :( Cual es el animal? ") + " ",new JOptionPane().showInputDialog("Cual seria la pregunta de si/no que tendria que hacer?") + " ",this.nodo,2);
                this.ganador = true;
                return null;
            } else {
                this.ganador = true;
                return "Adivine!";
            }
        } else {
            if (bool == true) {
                if (this.nodo.getSi() == null && this.nodo.getNo() != null) {
                    this.getArbol().agregar(new JOptionPane().showInputDialog("No se! :( Cual es el animal? ") + " ",new JOptionPane().showInputDialog("Cual seria la pregunta de si/no que tendria que hacer?") + " ",this.nodo,1);
                    this.ganador = true;
                    return this.nodo.getPregunta();
                } else {
                    this.nodo = this.nodo.getSi();
                }
            } else {
                if (this.nodo.getNo() == null && this.nodo.getSi() != null) {
                    this.getArbol().agregar(new JOptionPane().showInputDialog("No se! :( Cual es el animal? ") + " ",new JOptionPane().showInputDialog("Cual seria la pregunta de si/no que tendria que hacer?") + " ",this.nodo,0);
                    this.ganador = true;
                    return this.nodo.getPregunta();
                } else {
                    this.nodo = this.nodo.getNo();
                }
            }
        }
        return this.nodo.getPregunta();
    }

    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        Font fuente = new Font("arial", Font.BOLD, 17);
        g.setFont(fuente);
        g.setColor(Color.BLACK);
        this.mensaje(g);
    }
    
    public void mensaje(Graphics g) {
        int x = 30, y = 70, k = 47, w = 0, z = this.nodo.getPregunta().length();
        for(int i = 0; i < this.nodo.getPregunta().length(); i++){
            g.drawString(this.nodo.getPregunta().substring(w, i), x, y);
            if (i >= k) {
                y += 19;
                k += 47;
                w += 47;
            }
        }
    }
    
    public static void main(String[] args) {
        Juego<String> j = new Juego<String>(new Arbol<String>());
        boolean bandera = false;
        while(bandera == false){
            if (j.ganador == true) {
                j.arbol.guardar();
                if (new JOptionPane("Deseas volver a jugar?").showConfirmDialog(null, "Desea volver a jugar?") == 0) {
                    j.setVisible(false);
                    j = new Juego<String>(new Arbol<String>());
                } else {
                    bandera = true;
                    System.exit(0);
                }
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.no){
            this.recorrer(false);
            this.repaint();
        }
        else if(e.getSource() == this.si){
            this.recorrer(true);
            this.repaint();
        }
        else if(e.getSource() == this.salir){
            this.ganador = true;
            System.exit(0);
        }
    }
    
}
