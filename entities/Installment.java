package interfaces.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate dueDate;
    private final Double amount;
    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  dueDate.format(dateFormat) + " - " + String.format("%.2f", amount);
    }
}
