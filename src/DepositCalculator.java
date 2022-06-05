import java.util.Scanner;

public class DepositCalculator {
    double calculateCompoundInterest(double initialAmount, double yearlyRate, int depositTerm) {
        double finalAmount = initialAmount * Math.pow((1 + yearlyRate / 12), 12 * depositTerm);
        return roundPercentage(finalAmount, 2);
    }

    double calculateSimpleInterest(double initialAmount, double yearlyRate, int depositTerm) {
        return roundPercentage(initialAmount + initialAmount * yearlyRate * depositTerm, 2);
    }

    double roundPercentage(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    void calculateFutureValue() {
        int principalValue;
        int depositTerm;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях: ");
        principalValue = scanner.nextInt();
        System.out.println("Введите срок вклада в годах: ");
        depositTerm = scanner.nextInt();
        System.out.println("""
                Выберите тип вклада:
                1 - вклад с обычным процентом
                2 - вклад с капитализацией
                """);
        depositType = scanner.nextInt();
        double futureValue = 0;
        if (depositType == 1) {
            futureValue = calculateSimpleInterest(principalValue, 0.06, depositTerm);
        } else if (depositType == 2) {
            futureValue = calculateCompoundInterest(principalValue, 0.06, depositTerm);
        }
        System.out.println("Результат вклада:" + principalValue
                + " за " + depositTerm
                + " лет превратятся в " + futureValue);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateFutureValue();
    }
}