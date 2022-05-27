import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class LecturaYEscrituraFicheros_Metodos {

    /**
     * Delcaramos los distintos tipos de las clases de ficheros que vamos a usar para la lectura como para la
     * escritura de los ficheros
     */
    static File file = null;
    static FileReader fileReader = null;
    static BufferedReader bufferedReader = null;
    static FileInputStream fileInputStream = null;
    static ObjectInputStream objectInputStream = null;
    static FileOutputStream fileOutputStream = null;
    static ObjectOutputStream objectOutputStream = null;

    static TreeSet<FacturasDesglosadas> listafacturasTreeset;
    static String[] listaCodFactura;
    static Scanner sc;

    /**
     * Creamos un metodo que nos permita leer el fichero dado
     */
    public static TreeSet<FacturasDesglosadas> leerFacturaDesordenada() {

        listaCodFactura = new String[4];
        listafacturasTreeset = new TreeSet<>();

        /**
         * Declaramos los atributos que vamos a recoger del fichero para poder usarlos en la lectura del fichero
         * introducimos todos los datos en array clase set para que se ordenen y evitar que se repitan
         */

        String cif = null;
        String nombreEmpresa = null;
        String fechaEnvio = null;
        String codEnvio = null;

        String codigoFactura = null;
        double facturaTotSinIva = 0;
        double FacturaTotalConIva = 0;

        String codigoFactura2 = null;
        double facturaSinIva = 0;
        double factuaConIva = 0;

        String codigoFactura3 = null;
        double facturaSinIva3 = 0;
        double factuaConIva3 = 0;

        String codigoFactura4 = null;
        double facturaSinIva4 = 0;
        double factuaConIva4 = 0;

        try {
            file = new File("facturasDuplicadas.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
        /**
         * introducimos los datos del fichero en las variables creadas, leemos con la clase Scanner y lo introducimos
         */
            while ((linea = bufferedReader.readLine()) != null) {

                // Declaro la clase Scanner y le introduzco dentro el valor de la linea lida, para que saque dato a dato el valor de cada elemento

                sc = new Scanner(linea);

                if (sc.hasNext()) {
                    cif = sc.next();
                }
                if (sc.hasNext()) {
                    nombreEmpresa = sc.next();
                }
                if (sc.hasNext()) {
                    fechaEnvio = sc.next();
                }
                if (sc.hasNext()) {
                    codEnvio = sc.next();
                }

                for (int i = 0; i < 4; i++) {
                    if (sc.hasNext()) {
                        listaCodFactura[i] = sc.next();
                        if (sc.hasNextDouble()) {

                            facturaTotSinIva += sc.nextDouble();
                            if (sc.hasNextDouble()) {
                                factuaConIva = sc.nextDouble();
                                FacturaTotalConIva += factuaConIva;
                            }
                        }
                    }
                }


             /*   }
                if (sc.hasNextDouble()) {
                    facturaSinIva1 = sc.nextDouble();
                }
                if (sc.hasNextDouble()) {
                    factuaConIva1 = sc.nextDouble();
                }
                if (sc.hasNext()) {
                    codigoFactura2 = sc.next();
                }
                if (sc.hasNextDouble()) {
                    facturaSinIva2 = sc.nextDouble();
                }
                if (sc.hasNextDouble()) {
                    factuaConIva2 = sc.nextDouble();
                }
                if (sc.hasNext()) {
                    codigoFactura3 = sc.next();
                }
                if (sc.hasNextDouble()) {
                    facturaSinIva3 = sc.nextDouble();
                }
                if (sc.hasNextDouble()) {
                    factuaConIva3 = sc.nextDouble();
                }
                if (sc.hasNext()) {
                    codigoFactura4 = sc.next();
                }
                if (sc.hasNextDouble()) {
                    facturaSinIva4 = sc.nextDouble();
                }
                if (sc.hasNextDouble()) {
                    factuaConIva4 = sc.nextDouble();
                }*/


                //antes de meter el valor de las facturas con iva y sin Iva las sumo para meterle el total a la clase Factura
              /*  double totalSinIva = facturaSinIva1 + facturaSinIva2 + facturaSinIva3 + facturaSinIva4;
                double totalConIva = factuaConIva1 + factuaConIva2 + factuaConIva3 + factuaConIva4;*/

                /**
                 * Como no se me ocurre como meterlo si no asi, asignamos cada posicion el valor de la misma en el array
                 */

             /*   listaCodFactura[0] = codigoFactura1;
                listaCodFactura[1] = codigoFactura2;
                listaCodFactura[2] = codigoFactura3;
                listaCodFactura[3] = codigoFactura4;*/

                //lo introducimos en el TreeSet
                listafacturasTreeset.add(new FacturasDesglosadas(cif, nombreEmpresa, fechaEnvio, codEnvio, listaCodFactura, facturaTotSinIva, FacturaTotalConIva));

            }


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error general");
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
            }

        }
        System.out.println(listafacturasTreeset.size());
        return listafacturasTreeset;

    }

    public static void escribirFicheroOrdenado() {

        try {

            file = new File("FicheroOrdenado.bin");
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

           /* for (int i = 0; i < listafacturasTreeset.size(); i++) {
                objectOutputStream.writeObject(listafacturasTreeset);
            }*/

            for (FacturasDesglosadas e:listafacturasTreeset
                 ) {
                System.out.println(e);
            }
            System.out.println("salgo");
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error general");
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("error al cerrar el fichero");
            }
        }
    }

    public static void mostrarDatosPorConsola() {

        try {

            file = new File("FicheroOrdenado.bin");
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object aux = objectInputStream.readObject();

            while (aux != null) {
                System.out.println(aux);
                aux = objectInputStream.readObject();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error general");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en tiempo de compilacion");
        } finally {
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Fin Fichero");
            }
        }

    }



}