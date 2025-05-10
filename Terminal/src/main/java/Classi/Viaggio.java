package Classi;
import java.util.Date;

public class Viaggio 
{
    private int idViaggio;
    private int idNave;
    private Date dataPartenza;
    private Date dataArribamento;
    private Porto portoPartenza;
    private Porto portoArrivo;

    public Viaggio() {
    }

    public Viaggio(int idViaggio, int nave, Date dataPartenza, Date dataArribamento, Porto portoPartenza, Porto portoArrivo) {
        this.idViaggio = idViaggio;
        this.idNave = nave;
        this.dataPartenza = dataPartenza;
        this.dataArribamento = dataArribamento;
        this.portoPartenza = portoPartenza;
        this.portoArrivo = portoArrivo;
    }

    public int getIdViaggio() {
        return idViaggio;
    }

    public void setIdViaggio(int idViaggio) {
        this.idViaggio = idViaggio;
    }

    public int getNave() {
        return idNave;
    }

    public void setNave(int nave) {
        this.idNave = nave;
    }

    public Date getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(Date dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public Date getDataArribamento() {
        return dataArribamento;
    }

    public void setDataArribamento(Date dataArribamento) {
        this.dataArribamento = dataArribamento;
    }

    public Porto getPortoPartenza() {
        return portoPartenza;
    }

    public void setPortoPartenza(Porto portoPartenza) {
        this.portoPartenza = portoPartenza;
    }

    public Porto getPortoArrivo() {
        return portoArrivo;
    }

    public void setPortoArrivo(Porto portoArrivo) {
        this.portoArrivo = portoArrivo;
    }
}