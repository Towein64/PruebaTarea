package bryan.pruebaspring.modelo;

import java.util.Scanner;

public class prueba {
    private int contador = 0;


    public int contarNumero(int numero){
        this.contador++;
        if(numero<10)
            return this.contador;
        else {
            contarNumero(numero / 10);
        }
    return this.contador;
    }

    public int contarNumero2(int numero){
        int contador  =0;
        for (int i=0 ; numero>0;i++){
            numero = numero/10;
            contador++;
        }
        return contador;
    }
    public static void main(String[] args) {
        prueba prueba = new prueba();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa un numero: ");
        var digitos = entrada.nextInt();
        System.out.println("con recursividad: " + prueba.contarNumero(digitos));
        System.out.println("con iteracion:" + prueba.contarNumero2(digitos));
    }
}
