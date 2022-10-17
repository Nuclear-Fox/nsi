package com.mycompany.nsi.model;

import java.util.ArrayList;

public class NSIList {
    private ArrayList<NSIModel> list = new ArrayList<NSIModel>();
    
    public NSIList() {
        
    }
    
    public NSIList(ArrayList<NSIModel> list) {
        this.list = list;
    }
    
    public ArrayList<NSIModel> getList() {
        return list;
    }
    
    public void setList(ArrayList<NSIModel> list) {
        this.list = list;
    }
    
    public void addElement(NSIModel note) {
        this.list.add(note);
    }
    
    public void removeElement(NSIModel note) {
        this.list.remove(note);
    }
    
    @Override
    public String toString() {
        return "List { list = " + list + " }";
    }
}
