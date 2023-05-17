principal_amounts = [7077, 7284, 7497, 7716, 7941, 8174, 8413, 8659, 8912, 9172, 9440, 9716]
total_amount_per_month = 10000  
months = 12  


print("Month\tPrincipal\tInterest\tTotal Amount\t\tBalance\t\tLoan Paid to Date (%)")

loan_paid = 0
balance = 100000  


for month in range(1, months + 1):
    principal = principal_amounts[month - 1]  

    interest_rate = ((total_amount_per_month - principal) / balance)  
    monthly_interest = balance * interest_rate
    principal_payment = total_amount_per_month - monthly_interest
    balance -= principal_payment
    loan_paid += principal_payment

    loan_paid_percentage = (loan_paid / 100000) * 100  

    print(f"{month}\t{principal:.2f}\t\t{monthly_interest:.2f}\t\t{total_amount_per_month:.2f}\t\t{balance:.2f}\t\t{loan_paid_percentage:.2f}%")
