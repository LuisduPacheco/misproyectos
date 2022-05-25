package clases;

import java.util.Scanner;

public abstract class ClasePadre_Abstracta { // se agregó la palabra abstract para poder usar poliformismo

    //ATRIBUTOS
    protected int transacciones, retiro, deposito;
    private static int saldo;  // podrá utilizarse en otra clase sin crear un objeto
    Scanner entrada = new Scanner(System.in);

    //Metodo operaciones 
    public void Operaciones() {
        //Variables locales
        int bandera = 0;
        int seleccion = 0; // Para capturar las opciones ingresadas por el usuario

        do {
            do {
                System.out.println("Por favor seleccione una opción: ");
                System.out.println("    1. Consulta de saldo.");
                System.out.println("    2. Retiro de efectivo.");
                System.out.println("    3. Depósito de efectivo.");
                System.out.println("    4. Salir");
                seleccion = entrada.nextInt();

                //Condicionales para validar una opción correcta
                if (seleccion >= 1 && seleccion <= 4) {
                    bandera = 1; // Con esto dejará de ejecutarse el menú de opciones
                } else {
                    System.out.println("********************************************");
                    System.out.println("Opción incorrecta, intentelo de nuevo.");
                    System.out.println("********************************************");
                }
            } while (bandera == 0); //Fin del bucle para el menú principal

            //Condicionales para validar cada una de las opciones correctas
            if (seleccion == 1) {
                ClasePadre_Abstracta mensajero = new ClaseHija_Consulta();
                mensajero.Transacciones(); // se ejecutará la sobreescritura del metodo Transacciones
                
            } else if (seleccion == 2) {
                ClasePadre_Abstracta mensajero = new ClaseHija_Retiro();
                mensajero.Transacciones();
                
            } else if (seleccion == 3) {
                ClasePadre_Abstracta mensajero = new ClaseHija_Deposito();
                mensajero.Transacciones();
            } else if (seleccion == 4) {
                System.out.println("************************************************");
                System.out.println("Gracias, vuelva pronto.");
                System.out.println("************************************************");
                bandera = 2; // para cerrar el bucle do while y salir del programa
            }
        } while (bandera != 2);

    }

    //Metodo para solicitar el retiro 
    public void retiro() {
        this.retiro = entrada.nextInt();
    }

    //Método para solicitar el deposito
    public void deposito() {
        this.deposito = entrada.nextInt();
    }

    //Metodo abstracto, se usará el polimorfismo
    public abstract void Transacciones();
    
    //metodos getter y setter

    public static int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}
