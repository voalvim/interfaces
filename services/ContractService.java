package interfaces.services;

import interfaces.entities.Contract;
import interfaces.entities.Installment;


public class ContractService {
    private final OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double monthlyInstallment = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            double interest = paymentService.interest(monthlyInstallment, i);
            double fee = paymentService.paymentFee(interest + monthlyInstallment);
            double total = interest + fee + monthlyInstallment;
            contract.addInstallments(new Installment(contract.getDate().plusMonths(i),total));
        }
    }
}
