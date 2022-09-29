package application;

import model.entities.Reservation3;
import model.entities.Reservation2;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args)  {
        //ESSA É A SOLUÇÃO BOA PARA O PROBLEMA USANDO EXCEPTIONS
        // Lembrar que o Date now pega a data recente do computador
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Numero do quarto:");
            int numero = sc.nextInt();
            System.out.println("Data do Check-in (dd/MM/yyyy):");
            Date checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy):");
            Date checkout = sdf.parse(sc.next());

            Reservation3 reservation3 = new Reservation3(numero, checkin, checkout);
            System.out.println("DADOS DA RESERVA: " + reservation3);
            System.out.println("");
            System.out.println("Insira os dados para atualizar a reserva");
            System.out.println("Data do Check-in (dd/MM/yyyy):");
            checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy):");
            checkout = sdf.parse(sc.next());

            reservation3.updateDates(checkin, checkout);
            System.out.println("Reserva:" + reservation3);
        }
        catch (ParseException e){
            System.out.println("DATA INVALIDA");
        }
        catch (DomainExceptions e){
            System.out.println("ERRO AO FAZER A RESERVA" +e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("ERRO INESPERADO");
        }






            sc.close();
        }


    }

