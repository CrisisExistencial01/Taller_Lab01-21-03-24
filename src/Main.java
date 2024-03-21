public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        double[][] sismos = new double[24][7];
        System.out.println("Monitoreo Sismográfico");
        ingresarDatos(sismos);
        System.out.printf("Maximo: %.1f", buscarPorMagnitud(sismos));
        System.out.println("");
        System.out.println("Cantidad mayores a 5.0: " + contar(sismos, 5.0));
        for(int i = 0; i < contar(sismos, 7.0); i++){
            enviarSMS();
        }

    }
    public static double generarRandomDouble(){
        double MIN = 0.0;
        double MAX = 9.9;
        return MIN + (Math.random() * (MAX - MIN - 0.1));
    }
    public static void ingresarDatos(double[][] sismos){
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 7; j++) sismos[i][j] = generarRandomDouble();
        }
        System.out.println("Datos Ingresados :D");
    }
    public static double buscarPorMagnitud(double[][] matrix){
        double max = 0.0;
        for(int hora = 0; hora < 24; hora++){
            for(int dia = 0; dia < 7; dia++){
                double valor_actual = matrix[hora][dia];
                if( valor_actual > max){
                    max = valor_actual;
                }
            }
        }
        return max;
    }
    public static boolean validarMagnitud(double magnitud, double condicion){

        if(magnitud > 7.7){
            return true;
        }
        return false;
    }
    public static void enviarSMS(){
        System.out.println("ALERTA: SISMO DE MAGNITUD ALTA !!!");
    }
    public static int contar(double[][] sismos, double condicion) {
        int cantidad = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 7; j++) {
                if(validarMagnitud(sismos[i][j], condicion)){
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

}