package interfaces.application;

import interfaces.entities.Contract;
import interfaces.entities.Installment;
import interfaces.services.ContractService;
import interfaces.services.OnlinePaymentService;
import interfaces.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(date, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int months = sc.nextInt();

        OnlinePaymentService paymentService = new PaypalService();

        ContractService contractService = new ContractService(paymentService);

        contractService.processContract(contract, months);

        System.out.println("Parcelas:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment.toString());
        }

        sc.close();
    }
}
