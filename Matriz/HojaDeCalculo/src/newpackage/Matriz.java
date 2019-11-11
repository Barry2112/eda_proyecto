package newpackage;
import Listas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Matriz {
    
    private ListaCircula tabla;
    private int f, c;
    
    public Matriz(int f, int c) {
        this.f = f;
        this.c = c;
        tabla = new ListaCircula();
        for (int i=0; i<f; i++) {
            ListaCircula temp = new ListaCircula();
            for (int j=0; j<c; j++) {
                int M=-100;
                int N=100;
                int randomValue = (int) Math.floor(Math.random()*(N-M+1)+M);
                JTextField obj=new JTextField();
                obj.setText(randomValue+"");
                obj.addActionListener(new ActionListener(){
                    @Override   
                    public void actionPerformed(ActionEvent ae) {
                    obj.setText(obj.getText());
                    }
                });
                temp.add(temp.length(), obj);
            }
            tabla.add(tabla.length(), temp);
        }
        
    }
    
    public Matriz(ListaCircula list, int f, int c) {
        if(list.length() != (f*c)) {
            throw new IllegalArgumentException("La lista debe tener un tamaño igual a (fila x columna) de la matriz.");
        }
        this.f = f;
        this.c = c;
        for (int i = 0, k = 0; i < f; i++) {
            ListaCircula temp = new ListaCircula();
            for (int j = 0; j < c; j++, k++) {
                temp.add(temp.length(), list.get(k));
            }
            tabla.add(tabla.length(), temp);
        }
    }
    
    public Object get(int f, int c) {
        if (f < 0 || f >= this.f || c < 0 ||c >= this.c) {
            throw new IllegalArgumentException("Uno de los indices esta fuera de rango.");
        }
        return ((ListaCircula)tabla.get(f)).get(c);
    }
    
    public void set(int f, int c, Object value) {
        if (f < 0 || f >= this.f || c < 0 ||c >= this.c) {
            throw new IllegalArgumentException("Uno de los indices esta fuera de rango.");
        }
        ((ListaCircula)tabla.get(f)).remove(c);
        ((ListaCircula)tabla.get(f)).add(c, value);
    }
    public int sizeRow() {
        return f;
    }
    public int sizeColumn() {
        return c;
    }
    
    public int cantidadElementos(){
        return f*c;
    }
    
    public Matriz getSelectedMatrix(int i1, int j1, int i2, int j2) {
        if (i1 > i2 || j1 > j2) {
            throw new IllegalArgumentException("Seleccione un rango de tal manera que forme la diagonal principal de una matriz.");
        }
        Matriz aux = new Matriz(i2-i1+1, j2-j1+1);
        for (int i = i1, a = 0; i <= i2; i++, a++) {
            for (int j = j1, b = 0; j <= j2; j++, b++) {
                aux.set(a, b, get(i, j));
            }
        }
        return aux;
    }
}
