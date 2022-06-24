package modelo;

public class Principiante {

    private int n1;
    private int n2;
    private int i = 0;

    public Principiante() {
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    
    
    
   

    //OPERACIONES 
    public int resta() {
        int r;
        r = (int)(this.n1 - this.n2);
        return r;
    }

    public int suma() {
        int s;
        s = (this.n1 + this.n2);
        return s;
    }
    public int multiplicacion(){
        int m;
        m = (this.n1 * this.n2);
        return m;    
    }
    public int division(){
        int d;
        d = (this.n1 / this.n2);
        return d;
    }

}
