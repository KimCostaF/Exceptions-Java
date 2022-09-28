package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        //ESSA É A SOLUÇÃO MUITO RUIM PARA O PROBLEMA

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Numero do quarto:");
        int numero = sc.nextInt();
        System.out.println("Data do Check-in (dd/MM/yyyy):");
        Date checkin = sdf.parse(sc.next());
        System.out.println("Data do Check-out (dd/MM/yyyy):");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)){
            System.out.println("ERRO AO FAZER A RESERVA: A DATA DE CHECKOUT DEVE SER APÓS A DATA DE " +
                    "CHECKIN");

        }else {
            Reservation reservation = new Reservation(numero,checkin,checkout);
            System.out.println("DADOS DA RESERVA: " +reservation);
            System.out.println("");
            System.out.println("Insira os dados para atualizar a reserva");
            System.out.println("Data do Check-in (dd/MM/yyyy):");
            checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy):");
            checkout = sdf.parse(sc.next());
            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)){
                System.out.println("ERRO AO FAZER A RESERVA: AS DATAS PARA ATUALIZAR A RESERVA DEVEM SER DE DATAS" +
                        " FUTURAS A RESERVA ANTERIOR");
                
            } else if (!checkout.after(checkin)) {
                System.out.println("ERRO AO FAZER A RESERVA: A DATA DE CHECKOUT DEVE SER APÓS A DATA DE " +
                        "CHECKIN");
            }else {
                reservation.updateDates(checkin,checkout);
                System.out.println("Reserva:" +reservation);
            }



        }
        sc.close();

    }
}
