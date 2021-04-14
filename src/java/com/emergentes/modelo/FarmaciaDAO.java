package com.emergentes.modelo;
import java.util.ArrayList;

public class FarmaciaDAO {
    private int correlativo;
    private ArrayList<Farmacia> alm;

    public FarmaciaDAO() {
        alm = new ArrayList<Farmacia>();
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public ArrayList<Farmacia> getAlm() {
        return alm;
    }

    public void setvacuna(ArrayList<Farmacia> alm) {
        this.alm = alm;
    }
    public void insertar(Farmacia item){
        alm.add(item);
    }
    public void editar(int id, Farmacia item){
        int pos = posicion(id);
        alm.set(pos, item);
    }
    public void eliminar(int id){
        int pos = posicion(id);
        alm.remove(pos);
    }
    public int posicion(int id){
        int i = -1;
        if(alm.size() > 0){
            for(Farmacia item : alm){
                ++i;
                if(item.getId() == id){
                    break;
                }
            }
        }
        return i;
    }
    
}
