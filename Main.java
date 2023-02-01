import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a data da primeira vacinação (dd/MM/yyyy):");
        LocalDate primeiraVacinacao = LocalDate.parse(scanner.nextLine(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Verifica se a data da primeira vacinação é um sábado ou domingo
        if (primeiraVacinacao.getDayOfWeek().toString().equals("SATURDAY")) {
            primeiraVacinacao = primeiraVacinacao.minusDays(1);
            System.out.println("Data alterada para um dia antes: " + primeiraVacinacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else if (primeiraVacinacao.getDayOfWeek().toString().equals("SUNDAY")) {
            primeiraVacinacao = primeiraVacinacao.plusDays(1);
            System.out.println("Data alterada para a próxima semana: " + primeiraVacinacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }

        // Loop para calcular as próximas 3 doses
        for (int i = 1; i <= 3; i++) {
            primeiraVacinacao = primeiraVacinacao.plusMonths(3);
            if (primeiraVacinacao.getDayOfWeek().toString().equals("SATURDAY")) {
                primeiraVacinacao = primeiraVacinacao.minusDays(1);
            } else if (primeiraVacinacao.getDayOfWeek().toString().equals("SUNDAY")) {
                primeiraVacinacao = primeiraVacinacao.plusDays(1);
            }
            System.out.println("Data da próxima dose: " + primeiraVacinacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
}
