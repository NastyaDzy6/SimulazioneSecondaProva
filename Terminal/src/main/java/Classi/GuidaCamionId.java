package Classi;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class GuidaCamionId implements Serializable 
{
    private int idCamionista;
    private String targa;
    private Date dataInizio;

    public GuidaCamionId() {
    }

    public GuidaCamionId(int idCamionista, String targa, Date dataInizio) {
        this.idCamionista = idCamionista;
        this.targa = targa;
        this.dataInizio = dataInizio;
    }

    public int getIdCamionista() {
        return idCamionista;
    }

    public void setIdCamionista(int idCamionista) {
        this.idCamionista = idCamionista;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }
}