package Classi;

public class Camion 
{
    private int idCamion;
    private String marca;
    private String targa;
    

    public Camion(int idCamion, String marca, String targa) {
        this.idCamion = idCamion;
        this.marca = marca;
        this.targa = targa;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
}