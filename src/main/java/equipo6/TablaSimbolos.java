package equipo6;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TablaSimbolos  {
    private String[] columnas = {"NOMBRE" , "TOKEN" , "TIPO", "VALOR", "LONG" };
    private ArrayList<String> lista = new ArrayList<>();

    public void setLista(ArrayList<String> lista){
        this.lista = lista;
    }

    public int getFilaTamanio() {
        return lista.size()/columnas.length;
    }


    public int getColumnaTamanio() {
        return columnas.length;
    }

    public String[] getNombreColumnas() {
        return columnas;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        int posicion = (rowIndex * 5) + columnIndex;
        if (lista.get(posicion) != null){
            return lista.get(posicion);
        }
        return null;
    }
}
