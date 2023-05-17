public class LoanEMICalculator2 {
    public static void main(String[] args) {
        double principal = 100000;
        double fixedPayout = 10000;
        double interestRate = 20.003;

        double monthlyInterestRate = (interestRate / 100) / 12;

        double balance = principal;
        double loanPaidPercentage = 7.08;
        double loanPaidToDate = (loanPaidPercentage / 100) * principal;
        int month = 1;  // Start from month 1

        System.out.println("Month\tPrincipal\tInterest\tTotal Payment\t\tBalance\t\tLoan Paid to Date (%)");
        while (month <= 12) {
            double interest = balance * monthlyInterestRate;
            double principalPayment = Math.min(fixedPayout - interest, balance);
            balance -= principalPayment;
            loanPaidToDate += principalPayment;
            loanPaidPercentage = (loanPaidToDate / principal) * 100;

            if (loanPaidPercentage > 100) {
                loanPaidPercentage = 100;  // Limit the loan paid percentage to 100
            }

            balance += balance * monthlyInterestRate; // Add interest to the next balance
            
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f%%\n", month, principalPayment, interest, fixedPayout, balance, loanPaidPercentage);
            month++;
        }
    }
}
