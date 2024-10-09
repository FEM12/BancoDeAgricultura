package sv.edu.udb.www.utils;

import java.util.regex.Pattern;

public class ExpresionesUtil {

    private static final String[] regex = {

        "^[A-Z][a-z ñ]{2,24}\\s[A-Z][a-z ñ]{2,24}$", //Nombres
        "^(Masculino|Femenino)$", //Genero
        "^\\d{8}\\-\\d$", //DUI
        "^\\d{2}\\/\\d{2}\\/\\d{4}$", //Fecha
        "^(Soltero/a|Casado/a|Divorciado/a|Viudo/a|Unido/a)$", //Estado Civil
        "^\\d{3,6}(\\.\\d{2})?$", //Ingreso Mensual
        "^\\d{4}\\-\\d{4}$", //Telefono
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", //Correo Electronico
        "^(Cliente|Prestamista)$" //Clasificacion de cliente

    };

    private static final Pattern[] patterns = new Pattern[regex.length];

    static{

        for(int i = 0; i < regex.length; i++){ patterns[i] = Pattern.compile(regex[i]); }

    }

    public static boolean validacion(int patternIndex, String input) {

        patternIndex -= 1;

        if (patternIndex < 0 || patternIndex >= patterns.length) { throw new IllegalArgumentException("Índice de patrón fuera de rango."); }
        return patterns[patternIndex].matcher(input).matches();

    }

    public static void main(String[] args) {

        //Prueba de validaciones

        System.out.println("Nombre: " + validacion(1, "Victor Francisco"));
        System.out.println("Apellido: " + validacion(1, "Marroquin Ramirez"));
        System.out.println("Genero: " + validacion(2, "Femenino"));
        System.out.println("DUI: " + validacion(3, "06631775-8"));
        System.out.println("Fecha: " + validacion(4, "2004-01-08"));
        System.out.println("Estado Civil: " + validacion(5, "Soltero/a"));
        System.out.println("Ingreso Mensual: " + validacion(6, "365"));
        System.out.println("Telefono: " + validacion(7, "7946-2301"));
        System.out.println("Correo Electronico: " + validacion(8, "MR210507@alumno.udb.edu.sv"));
        System.out.println("Clasificación de cliente: " + validacion(9, "Prestamista"));

    }

}
