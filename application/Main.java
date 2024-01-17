package interfaces.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Entre os dados do contrato:");

        System.out.print("Numero: ");
        int number = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");

        try {
            Date date = dateFormat.parse(sc.next());
        } catch (ParseException e) {
            System.err.println("Formato incorreto!: " + e.getMessage());
        }

        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int installments = sc.nextInt();

        System.out.println("Parcelas:");

        sc.close();
    }
}
