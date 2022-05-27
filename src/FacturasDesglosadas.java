import java.util.Arrays;

public class FacturasDesglosadas extends Factura {

    private String [] codFactura=new String[4];
    private double importeFacturaSinIva;
    private double importeFacturaConIva;
    private double importeBonificacion;


    public FacturasDesglosadas(String cif, String nombreEmpresa, String fechaEnvio, String codEnvio,
                               String[] codFactura, double importeFacturaSinIva, double importeFacturaConIva) {
        super(cif, nombreEmpresa, fechaEnvio, codEnvio);
        this.codFactura = codFactura;
        this.importeFacturaSinIva = importeFacturaSinIva;
        this.importeFacturaConIva = importeFacturaConIva;
        this.importeBonificacion=bonificacion();
    }

    public FacturasDesglosadas(String cif, String nombreEmpresa, String fechaEnvio, String codEnvio, String[] codFactura,
                               double importeFacturaSinIva, double importeFacturaConIva, double importeBonificacion) {
        super(cif, nombreEmpresa, fechaEnvio, codEnvio);
        this.codFactura = codFactura;
        this.importeFacturaSinIva = importeFacturaSinIva;
        this.importeFacturaConIva = importeFacturaConIva;
        this.importeBonificacion=bonificacion();
    }

    public String[] getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String[] codFactura) {
        this.codFactura = codFactura;
    }

    public double getImporteFacturaSinIva() {
        return importeFacturaSinIva;
    }

    public void setImporteFacturaSinIva(double importeFacturaSinIva) {
        this.importeFacturaSinIva = importeFacturaSinIva;
    }

    public double getImporteFacturaConIva() {
        return importeFacturaConIva;
    }

    public void setImporteFacturaConIva(double importeFacturaConIva) {
        this.importeFacturaConIva = importeFacturaConIva;
    }

    /**
     * a este geter le paso el metodo creado para que saque por consola el importe
     * @return
     */
    public double getImporteBonificacion() {
            return importeBonificacion;
    }

    public void setImporteBonificacion(double importeBonificacion) {
        this.importeBonificacion = importeBonificacion;
    }

    /**
     * Creo el metodo toString
     * @return
     */

    @Override
    public String toString() {
        return "FacturasDesglosadas{" +
                "codFactura=" + Arrays.toString(codFactura) +
                ", importeFacturaSinIva=" + importeFacturaSinIva +
                ", importeFacturaConIva=" + importeFacturaConIva +
                ", importeBonificacion=" + importeBonificacion +
                '}';
    }
    /**
     * Metodo para poder hallar los pagos que tienen bonificacion dependiendo de las compras realizadas
     */
    public double bonificacion() {

        double importe = 0;
        if (importeFacturaConIva < 1000) {
            importe = importeFacturaConIva;
        } else if (importeFacturaConIva >= 1000 && importeFacturaConIva <= 3000) {
            importe = importeFacturaConIva -(importeFacturaConIva * 0.1);
        } else if (importeFacturaConIva > 3000) {
            importe = importeFacturaConIva - (importeFacturaConIva * 0.15);
        }
        return importe;
    }
}
