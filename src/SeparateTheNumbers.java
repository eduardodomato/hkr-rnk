
public class SeparateTheNumbers {

    public static void separateNumbers(String s) {


        String subString = "";
        boolean isValid = false;

        for (int i = 1; i <= s.length()/2; i++ ){
            subString = s.substring(0,i); // Genero la primer semilla de cada largo, largo 1, largo 2...
            String validString = subString; //Arranco a generar el String ideal basado en la semilla
            Long num = Long.parseLong(subString); //Convierto la semilla en Long

            while (validString.length()<s.length()){ //Inflaremos el string ideal hasta que alcance el tamaño del parametro

                validString += Long.toString(++num); //Como ya inicialize la semilla,
                                                        // ahora PRE-Incremento para ir generando
                                                        // numero tras numero y lo apendo al string
            }
            if(s.equals(validString)){
                isValid = true;
                break;
            }
            //Si con este tamaño de semilla no lo encontre, sigo al siguiente tamaño
        }
        System.out.println(isValid?"YES "+subString :"NO");

    }

    public static void separateNumbersOptimized(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String seed = s.substring(0, i);
            long num = Long.parseLong(seed);
            StringBuilder valid = new StringBuilder(seed);

            while (valid.length() < s.length()) {
                valid.append(++num);
            }

            if (valid.toString().equals(s)) {
                System.out.println("YES " + seed);
                return;
            }
        }
        System.out.println("NO");
    }




}
