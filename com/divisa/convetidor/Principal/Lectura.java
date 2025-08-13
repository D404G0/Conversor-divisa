package com.divisa.convetidor.Principal;
import com.divisa.convetidor.api.Consulta;
import com.divisa.convetidor.api.Divisa;

import java.io.IOException;
import java.util.*;

public class Lectura {
    public static void main(String[] args){
        String base, cotiza;
        float valor;
        Scanner leer = new Scanner(System.in);
        Consulta consulta = new Consulta();

        Menu mostrar = new Menu();
        mostrar.Menu();

        System.out.println("Ingrese la divisa de origen: ");

        try{
            base = leer.nextLine();

            System.out.println("Ingrese la divisa de destino: ");
            cotiza = leer.nextLine();

            System.out.println("ingrse el valor en decimal que desea convertit: ");
            valor = leer.nextFloat();

            Divisa divisa = consulta.conexion(base, cotiza, valor);


            System.out.println(divisa);
            Generador generador = new Generador();
            generador.guardar(divisa);

        }catch (NumberFormatException e){
            System.out.println("Divisa no encontrada: " + e.getMessage());

        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando");
        }
    }
}
