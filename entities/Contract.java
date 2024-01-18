package interfaces.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private LocalDate date;
    private final Double totalValue;
    private final List<Installment> installments = new ArrayList<>();
    public Contract(LocalDate date, Double totalValue) {
        this.date = date;
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void addInstallments(Installment installment) {
        installments.add(installment);
    }

    public List<Installment> getInstallments() {
        return installments;
    }

}

