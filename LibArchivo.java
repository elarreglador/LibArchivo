import java.io.*;

//ETIQUETAS: #LEE #ESCRIBE #BINARIO #TEXTO

public class LibArchivo {
    
    // AGREGA UNA LINEA DE TEXTO AL ARCHIVO
    // #ESCRIBE #TEXTO
    public static void escribeTexto(String archivo, boolean sobreescribir, String texto) {

        // Abrimos el archivo para escritura
        File archivoF = new File(archivo);
        FileWriter fw = null;
        boolean append = !sobreescribir;
        try {
            fw = new FileWriter(archivoF, append); // append=true para añadir al final del archivo
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
    
        // Escribimos la línea de texto
        try {
            fw.write(texto + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    
        // Cerrar el flujo de escritura
        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo: " + e.getMessage());
        }
    }

    // CUENTA EL NUMERO DE LINEAS DE TEXTO QUE CONTIENE UN ARCHIVO
    // #LEE #TEXTO
    public static int cuentaLineas(String archivo) {

        File archivoF = new File(archivo);
        int retorno = 0;

        try {
            // Abrimos archivo y creamos objeto BufferedReader para leer línea por línea
            FileReader fr = new FileReader(archivoF);
            BufferedReader br = new BufferedReader(fr);

            // Leer el archivo hasta llegar al final
            while (br.readLine() != null) {
                retorno++;
            }

            // Cerrar el flujo de lectura
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Excepción en cuentaLineas@LibArchivo: " + e);
        }

        return retorno;
    }

    // DEVUELVE UN STRING CON EL CONTENIDO DE LA LINEA INDICADA DEL ARCHIVO DE
    // INDICADO
    // #LEE #TEXTO
    public static String leeLinea(String archivo, int linea) {

        File archivoF = new File(archivo);
        String retorno = null;

        try {
            // Abrimos archivo y creamos objeto BufferedReader para leer línea por línea
            FileReader fr = new FileReader(archivoF);
            BufferedReader br = new BufferedReader(fr);

            // Leer el archivo hasta llegar a la línea previa y obtener la indicada
            for (int i = 1; i < linea; i++) {
                br.readLine();
            }
            retorno = br.readLine();

            // Cerrar el flujo de lectura
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Excepción en leeLinea@LibArchivo: " + e);
        }

        return retorno;
    }

    // GUARDA UN UNICO OBJETO EN ARCHIVO INDICADO MACHACANDO CUALQUIER CONTENIDO
    // #ESCRIBE #BINARIO
    public static void sobreescribeObjeto(String archivo, Object objeto) {

        File archivoF = new File(archivo);

        try {
            // CREAMOS FLUJO DE DATOS
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(archivoF));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            // ESCRIBIMOS EL OBJETO
            objectOutputStream.writeObject(objeto);

            // CERRAMOS FLUJO
            bufferedOutputStream.close();
        } catch (Exception e) {
            System.out.println("Excepcion en sobreescribeObjeto@LibArchivo: " + e);
        }

        if (archivoF.exists()) {
            System.out.println("Guardado correcto de objeto.");
        }
    }

}
