package org.example.controle_blanc.Model;




import java.util.Date;

public class Incident {
    private String reference;
    private Date time;
    private String status;
    private int id_membre;

    public Incident(int id_membre, String reference, String status, Date  time) {
        this.id_membre = id_membre;
        this.reference = reference;
        this.status = status;
        this.time = time;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
