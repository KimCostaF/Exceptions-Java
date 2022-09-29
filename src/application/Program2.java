package application;

import model.entities.Reservation2;
import model.entities.Reservation2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws ParseException {
        //ESSA É A SOLUÇÃO RUIM PARA O PROBLEMA
        // AQUI VAMOS JOGAR A LÓGICA QUE CHECA SE A DATA É DEPOIS OU ANTES DE "NOW" NO METODO UPDATEDATE

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Numero do quarto:");
        int numero = sc.nextInt();
        System.out.println("Data do Check-in (dd/MM/yyyy):");
        Date checkin = sdf.parse(sc.next());
        System.out.println("Data do Check-out (dd/MM/yyyy):");
        Date checkout = sdf.parse(sc.next());
        if (!checkout.after(checkin)) {
            System.out.println("ERRO AO FAZER A RESERVA: A DATA DE CHECKOUT DEVE SER APÓS A DATA DE " +
                    "CHECKIN");

        } else {
            Reservation2 reservation2 = new Reservation2(numero, checkin, checkout);
            System.out.println("DADOS DA RESERVA: " + reservation2);
            System.out.println("");
            System.out.println("Insira os dados para atualizar a reserva");
            System.out.println("Data do Check-in (dd/MM/yyyy):");
            checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy):");
            checkout = sdf.parse(sc.next());

            String erro = reservation2.updateDates(checkin, checkout);
            if (erro!=null){
                System.out.println("ERRO NA RESERVA:" +erro);

            }else {
                System.out.println("Reserva:" + reservation2);
            }





            sc.close();
        }


    }
}
