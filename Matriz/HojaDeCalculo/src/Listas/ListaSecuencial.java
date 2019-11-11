package Listas;

public class ListaSecuencial implements InterfaceLista {

    private Nodo lista;
    private int size;

    public ListaSecuencial() {
        size = 0;
    }

    public void add(int index, Object o) {
        if(index < 0  || index > size) {
            throw new IllegalArgumentException("add: index < 0  || index > size");
        }
        Nodo nuevo = new Nodo(o); //crear el nuevo nodo.
        if(isEmpty()) { //Lista vacia.
            lista = nuevo;
        }
        else {
            if(index == 0) {
                nuevo.setSig(lista);
                lista = nuevo; // Insertar al comienzo
            }
            else {
                if(index == size) { //Insertar al final.
                    nodo(size-1).setSig(nuevo);
                }
                else {
                    Nodo actual = nodo(index-1);
                    nuevo.setSig(actual.getSig());
                    actual.setSig(nuevo); // Insertar a medio.
                }
            }
        }
        size++;
    }

    public void remove(int index) {
        if(index < 0  || index > (size - 1)) {
            throw new IllegalArgumentException("remove: index < 0  || index > (size - 1)");
        }
        if(index == 0) {
            lista = lista.getSig(); //Eliminar a comienzo.
        }
        else {
            if(index == size-1) {
                nodo(size-2).setSig(null); //Eliminar al final (size>1).
            }
            else {
                Nodo anterior = nodo(index-1);
                anterior.setSig(anterior.getSig().getSig()); //Inserta por el medio.
            }
        }
        size--;
    }

    public int indexOf(Object o) {
        int i;
        Nodo actual = lista;
        for(i=0; actual!=null && i<size; actual=actual.getSig(), i++) {
            if(o.toString().equals(actual.toString())) {
                break;
            }
        }
        return i==size ? -1 : i;
    }

    public Object get(int index) {
        if(index < 0  || index > (size - 1)) {
            throw new IllegalArgumentException("get: index < 0  || index > (size - 1)");
        }
        return nodo(index).getElemento();
    }

    public void clear() {
        lista = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        boolean sw = false;
        for(Nodo actual=lista; actual!=null; actual=actual.getSig()) {
            if(sw != false) {
                sb.append("," + actual);
            }
            else {
                sb.append(actual + "");
                sw = true;
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private Nodo nodo(int index) {
        if(index < 0  || index >= size) {
            throw new IllegalArgumentException("remove: index < 0  || index >= size");
        }
        Nodo actual = lista;
        for(int i=0; i<index; i++) {
            actual=actual.getSig();
        }
        return actual;
    }
}
