package interfaces.application;

import interfaces.entities.ContractService;
import interfaces.entities.OnlinePaymentService;
import interfaces.entities.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre os dados do contrato:");

        System.out.print("Numero: ");
        int number = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");

        LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int installments = sc.nextInt();

        System.out.println("Parcelas:");

        OnlinePaymentService paymentService = new PaypalService();

        ContractService service = new ContractService(paymentService);

        sc.close();
    }
}
