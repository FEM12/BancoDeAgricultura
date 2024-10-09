package sv.edu.udb.www.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConversorFecha {

    public static String convertirFecha(String fecha){

        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");

        try {

            java.util.Date date = formatoEntrada.parse(fecha);
            return formatoSalida.format(date);
        }
        catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage()); return "Vacío";
        }

    }

}
