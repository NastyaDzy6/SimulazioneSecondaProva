package Classi;

public class Camion 
{
    private String marca;
    private String targa;
    

    public Camion(String marca, String targa) {
        this.marca = marca;
        this.targa = targa;
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