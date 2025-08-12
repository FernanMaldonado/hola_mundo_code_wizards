import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public final Random random = new Random();

    public static void main(String[] args) {
        int Opcion;
        do {
            System.out.println("Elija una opcion por ");
            System.out.println("1 PAR O IMPAR");
            System.out.println("2 Primo o no Primo");
            System.out.println("3 Adivinanza");
            System.out.println("4 Lista de Tareas");
            System.out.println("5 Conversor de Temperaturas");
            System.out.println("6 Conexion de la Base de Datos");
            System.out.println("0 Salir del Programa");
            Opcion = sc.nextInt();

            switch (Opcion) {
                case 1:
                    ParImpar();
                    break;
                case 2:
                    NumerosPrimos();
                    break;
                case 3:
                    Adivinanza();
                    break;
                case 4:

                    break;
                case 5:
                    Temperatura();
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Gracias, Adios");
                    break;
                default:
                    System.out.println("Ingrese un numero Valido de entr 1 - 6");
                    break;
            }

        } while (Opcion != 0);
    }


    public static void ParImpar() {
        System.out.println("Ingrese un numero para determinar si es par o no ");
        int A = sc.nextInt();

        if (A % 2 == 0) {
            System.out.println("Su numero es Par");
        } else if (A % 2 == 1) {
            System.out.println("Su numero es imPar");
        } else {
            System.out.println("Su numero es invalido");
        }
    }

    public static void Adivinanza() {
        Random random = new Random();
        int A = random.nextInt(10 + 1);
        System.out.println("Elije un numero entre el 1 a 10, si adivinas el que estoy pensando");
        int B = sc.nextInt();

        if (A == B) {
            System.out.println("Haz adivinado el numero que haz pensado es " + B + "El que he pensado yo es " + A);
        } else {
            System.out.println("Opss no es el numero que estaba pensando " + A);
        }


    }

    public static void NumerosPrimos() {
        System.out.println("Ingrese un numero para determinar si es primo o no ");
        Boolean primo = true;
        int A = sc.nextInt();

        if (A <= 1) {
            primo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(A); i++)
                if (A % i == 0) {
                    primo = false;
                    break;
                }
        }

        if (primo) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
    }

    public static void Temperatura() {
        System.out.println("Ingrese los grados en Farenheigth");
        double F = sc.nextInt();
        double C = (F - 32) * 5 / 9;

        System.out.println("Su temperatura es en grados Celsius es " + C);
    }
}