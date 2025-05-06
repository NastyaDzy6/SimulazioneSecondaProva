package Classi;
import java.util.Date;

public class GuidaCamion 
{
    private int idCamionista;
    private String targa;
    private Date dataInizio;
    private Date dataFine;

    public GuidaCamion(int idCamionista, String targa, Date dataInizio, Date dataFine) {
        this.idCamionista = idCamionista;
        this.targa = targa;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
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

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }
}