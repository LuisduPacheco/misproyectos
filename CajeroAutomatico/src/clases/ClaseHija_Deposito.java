
package clases;


public class ClaseHija_Deposito extends ClasePadre_Abstracta {

    @Override // Para sobreescribir el metodo
    public void Transacciones() {
        
        System.out.println("Cuanto desea depositar?: ");
        deposito();
        
        transacciones = getSaldo(); // asignandole el saldo actual a la variable transacciones
        setSaldo(transacciones + deposito);
        System.out.println("****************************************************");
        System.out.println("Depositaste: " + deposito);
        System.out.println("Su saldo actual es: " + getSaldo());
        System.out.println("****************************************************");        
    }    
}
