package clases;

public class ClaseHija_Retiro extends ClasePadre_Abstracta {  // se usó herencia

    @Override // sobreescribir el metodo abstracto
    public void Transacciones() {
        System.out.println("¿Cuanto desea retirar?");
        retiro(); // metodo heredado de la clase padre

        if (retiro <= getSaldo()) { // El cliente puede retirar su saldo completo o menos 
            transacciones = getSaldo();  // cambiando el valor de la variable transacciones
            setSaldo(transacciones - retiro); // cambiando el valor de saldo con la palabra set
            System.out.println("****************************************************");
            System.out.println("Retiraste: " + retiro);
            System.out.println("Su saldo actual es: " + getSaldo());
            System.out.println("****************************************************");
        } else {
            System.out.println("****************************************************");
            System.out.println("Saldo insuficiente");
            System.out.println("****************************************************");
        }
    }

}
