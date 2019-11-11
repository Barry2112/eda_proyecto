/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listas;

/**
 *
 * @author Lorena Antonella
 */
public class ListaCircula implements InterfaceLista{
    private Nodo ultimo;
    private int size;
    
    public ListaCircula(){
      size=0;
    }
    public void add (int index, Object x){
        if(index<0 || index>size){
        throw new IllegalArgumentException("add:index<0||index>size");
        }
    Nodo nuevo=new Nodo(x);
    if(size==0){
        ultimo=nuevo;
        nuevo.setSig(nuevo);
    }else if(index==0){
        nuevo.setSig(ultimo.getSig());
        ultimo.setSig(nuevo);
        
    }else if(index==size){
        nuevo.setSig(ultimo.getSig());
        ultimo.setSig(nuevo);
        ultimo=nuevo;
    }else{
        Nodo anterior= nodo(index-1);
        nuevo.setSig(anterior.getSig());
        anterior.setSig(nuevo);
    }
    size++;
    }
    
    public void remove(int index){
        if(index<0||index>(size-1)){
            throw new IllegalArgumentException("remove:index<0||index>(size-1)");
        }
        if(index==0){
            if(size==0){
                clear();
                return;
            }else{
                ultimo.setSig(ultimo.getSig().getSig());
            }
        }else if(index==(size-1)){
            Nodo anterior =nodo(index-1);
            anterior.setSig(ultimo.getSig());
            ultimo=anterior;   
        }else {
            Nodo anterior = nodo(index-1);
            anterior.setSig(anterior.getSig().getSig());
        }
        size--; 
    }
    
    public int indexOf(Object x){
        int i;
        Nodo actual=ultimo.getSig();
        for(i=0;i<size;actual=actual.getSig(),i++){
            if(x.toString().equals(actual.toString())){
                break;
            }
        }
        return i==size?-1:i;   
    }
    
    public Object get(int index){
//        if(index<0||index>(size-1)){
//            throw new IllegalArgumentException("get:index<0||index>size-1");
//        }
        return nodo(index).getElemento();

    }
    public void clear(){
        size=0;
      
    }
    public boolean isEmpty(){
        return size==0;

    }
    public int length(){
        return size;
     
    }
    
    public String toString(){
        Nodo actual;
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        if(!isEmpty()){
            actual=ultimo;            
        do{
            actual=actual.getSig();
            sb.append(actual.getElemento().toString());
            if(actual!=ultimo){
                sb.append(",");
            }
        }
        while(actual!=ultimo);
        }
        sb.append("]");
        return sb.toString();   
   
    }
    
    private Nodo nodo(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("nodo:index<0||index>=size");
        }
        Nodo actual=ultimo.getSig();
        for(int i=0;i<index;actual=actual.getSig(),i++){
            
        }
        return actual;
    }
    
}
