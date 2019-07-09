
package Proyecto2;

public class Interfaz <E extends Comparable <E>> extends javax.swing.JFrame {
    
    private Arbol<E> arbol;
    private Nodo<E> nodo;
    private boolean ganador;

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

    public Interfaz(Arbol<E> arbol) {
        super();
        this.setArbol(arbol);
        this.getArbol().construir("src//proyecto2//memoria.txt");
        this.nodo = arbol.getN();
        this.ganador = false;
    }
    
    public String recorrer(boolean b) {
        if (this.nodo.getNo() == null && this.nodo.getSi() == null) {
            System.out.println("Entre a nodo raiz");
            if (b == false) {
                this.getArbol().agregar(a, b, nodo, WIDTH);
                this.ganador = true;
                return null;
            } else {
                
            }
        }
    }
    
    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
