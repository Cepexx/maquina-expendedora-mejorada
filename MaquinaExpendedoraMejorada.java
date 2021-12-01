public class MaquinaExpendedoraMejorada {
    
    //Numero de billetes vendidos
    private int billetesVendidos;
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Permite crear m�quinas premiadas
    private boolean maquinaPremiada;
    // Establece el n�mero m�ximo de billetes a vender
    private int maximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int numeroMaximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        maquinaPremiada = premio;
        maximoBilletes = numeroMaximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (maximoBilletes > billetesVendidos) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        } else {
            System.out.println("ERROR, todos los billetes vendidos");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if (maximoBilletes > billetesVendidos) {
            int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                if (maquinaPremiada == true && billetesVendidos % 3 == 0) {
                    System.out.println("Descuento de " + (precioBillete * 10) /100 + "� para compras en comercios asociados");
                }
        
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos++ ;
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
                        
            }
        } else {
            System.out.println("ERROR, todos los billetes vendidos");
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
    
    /**
     * Retira todo el dinero de la m�quina
     */
    public int retirarDinero() {
        int dineroRetirado = 0;
        if (balanceClienteActual != 0) {
            dineroRetirado = -1;
            System.out.println ("No se puede retirar el dinero, hay una operaci�n en curso");
           
        } else {
            dineroRetirado = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        return dineroRetirado;
    }
    /*
     *Dice el n�mero de billetes vendidos 
     */
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }
    /*
     * Imprime el n�mero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println (billetesVendidos);
    }
}
