package sv.edu.udb.www.utils;

import java.util.regex.Pattern;

public class ExpresionesUtil {

    private static final String[] regex = {

        "^[A-Z][a-z ñ]{2,24}\\s[A-Z][a-z ñ]{2,24}$", //Nombres
        "^\\d{8}\\-\\d$", //Dui
        "^\\d{3,6}(\\.\\d{2})?$", //Salario
        "^\\d{4}\\-\\d{4}$", //Telefono
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" //Correo Electronico

    };

    private static final Pattern[] patterns = new Pattern[regex.length];

    static{

        for(int i = 0; i < regex.length; i++){ patterns[i] = Pattern.compile(regex[i]); }

    }

    public static boolean validacion(int patternIndex, String input) {

        if (patternIndex - 1 < 0 || patternIndex - 1 >= patterns.length) { throw new IllegalArgumentException("Índice de patrón fuera de rango."); }
        return patterns[patternIndex - 1].matcher(input).matches();

    }

}
