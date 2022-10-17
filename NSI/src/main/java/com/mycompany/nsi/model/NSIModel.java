package com.mycompany.nsi.model;

public class NSIModel {
    private int vp_inv;
    private String prm_gr;
    private int prm_x;
    private String prm_fname;
    private String vp_zn;
    private String nsi_fname;
    
    public NSIModel() {
    }
    
    public NSIModel(int vp_inv, String prm_gr, int prm_x, String prm_fname, String vp_zn, String nsi_fname) {
        this.vp_inv = vp_inv;
        this.prm_gr = prm_gr;
        this.prm_x = prm_x;
        this.prm_fname = prm_fname;
        this.vp_zn = vp_zn;
        this.nsi_fname = nsi_fname;
        
    }
    
    public int getVp_inv() {
        return vp_inv;
    }
    
    public void setVp_inv(int vp_inv) {
        this.vp_inv = vp_inv;
    }
    
    public String getPrm_gr() {
        return prm_gr;
    }
    
    public void setPrm_gr(String prm_gr) {
        this.prm_gr = prm_gr;
    }
    
    public int getPrm_x() {
        return prm_x;
    }
    
    public void setPrm_x(int prm_x) {
        this.prm_x = prm_x;
    }
    
    public String getPrm_fname() {
        return prm_fname;
    }
    
    public void setPrm_fname(String prm_fname) {
        this.prm_fname = prm_fname;
    }
    
    public String getVp_zn() {
        return vp_zn;
    }
    
    public void setVp_zn(String vp_zn) {
        this.vp_zn = vp_zn;
    }
    
    public String getNsi_fname() {
        return nsi_fname;
    }
    
    public void setNsi_fname(String nsi_fname) {
        this.nsi_fname = nsi_fname;
    }
    
    @Override
    public String toString() {
        return "Model{ vp_inv = " + vp_inv + "prm_gr = " + prm_gr + "prm_x = " + prm_x + "prm_fname = " + prm_fname + "vp_zn = " + vp_zn + "nsi_fname = " + nsi_fname + " }";
    }
}
