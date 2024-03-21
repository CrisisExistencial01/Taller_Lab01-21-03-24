import java.util.Random;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        double[][] sismos = new double[24][7];
        System.out.println("Monitoreo Sismográfico");
        ingresarDatos(sismos);
        System.out.println(buscarPorMagnitud(sismos));
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
}