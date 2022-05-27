import java.awt.*;
import java.io.Serializable;
import java.util.Comparator;

public class Factura implements Serializable, Comparable {


    private String cif;
    private String nombreEmpresa;
    private  String fechaEnvio;
    private String codEnvio;



    public Factura(String cif, String nombreEmpresa, String fechaEnvio, String codEnvio) {
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaEnvio = fechaEnvio;
        this.codEnvio = codEnvio;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getCodEnvio() {
        return codEnvio;
    }

    public void setCodEnvio(String codEnvio) {
        this.codEnvio = codEnvio;
    }

    @Override
    public String toString() {
        return  "cif " + cif +
                ", nombreEmpresa " + nombreEmpresa +
                ", fechaEnvio " + fechaEnvio +
                ", codEnvio " + codEnvio;
    }


    @Override
    public int compareTo(Object o) {
        int salida=-1;
        if (o instanceof Factura){
            Factura factura=(Factura) o;
            salida=this.cif.compareTo(factura.getCif());
            if (salida == 0) {
                salida=this.fechaEnvio.compareTo(factura.getFechaEnvio());
                if (salida==0) {
                    salida=this.codEnvio.compareTo(factura.getCodEnvio());

                }
            }
        }

        return salida;
    }


}
