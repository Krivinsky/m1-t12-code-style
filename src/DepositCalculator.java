import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int period) {
       double pay = amount * Math.pow ((1 + yearRate / 12), 12 * period);
          return rnd(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return rnd(amount + amount * yearRate * depositPeriod, 2);
    }

    double rnd(double value,int places) {
       double scaLe = Math.pow(10, places);
       return Math.round(value * scaLe) / scaLe;
    }

    void calculateAmount() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outVar = 0;
        if (action == 1) {
            outVar = calculateSimplePercent(amount,0.06, period);
        }
        else if (action == 2) {
            outVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }
    public static void main(String[] args){
        new DepositCalculator().calculateAmount();
    }
}
