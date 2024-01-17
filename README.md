************************************
ACERCA DEL AUTOR
************************************

David M.

elarreglador@protonmail.cocm

https://github.com/elarreglador


************************************
ACERCA DE LA LIBRERIA
************************************

Vamos a intentar facilitar las tareas de lectura y escritura de archivos:



escribeTexto(String archivo, boolean sobreescribir, String texto)

    Escribe en archivo el texto indicado.

    Si sobreescribir == true machaca todo el archivo con el nuevo contenido
    Si sobreescribir == false agrega el texto al final del archivo



cuentaLineas(String archivo)

   Cuenta el numero de lineas de texto que contiene un archivo y las devuelve como un entero.



leeLinea(String archivo, int linea)
   
   Devuelve un String con el contenido de la linea indicada



sobreescribeObjeto(String archivo, Object objeto)

   Guarda un unico objeto en el archivo binario indicado sobreescribiendo cualquier otra cosa que exista en el archivo.



