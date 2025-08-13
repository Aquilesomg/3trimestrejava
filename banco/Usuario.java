package banco;
public class Usuario {
    private int id;
    private String nombre;
    private double saldo;
    private int pin;
    private int cuenta;

    public Usuario(int id, String nombre, double saldo, int pin, int cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        this.pin = pin;
        this.cuenta = cuenta;
    }
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
    
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public double getSaldo() {
            return saldo;
        }
        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
    
        public int getPin() {
            return pin;
        }
        public void setPin(int pin) {
            this.pin = pin;
        }
    
        public int getnumeroCuenta() {
            return cuenta;
        }
        public void setnumeroCuenta(int cuenta) {
            this.cuenta = cuenta;
    }
}
