class BankAccount:
    def __init__(self, balance=0):
        self.balance = balance
    
    # Simulating method overloading for the deposit method
    def deposit(self, *amounts):
        if len(amounts) == 1 and isinstance(amounts[0], (int, float)):
            # Deposit a single amount
            self.balance += amounts[0]
            print(f"Deposited {amounts[0]} dollars. Current balance: {self.balance}")
        elif len(amounts) > 1:
            # Deposit multiple amounts (e.g., a list of deposits)
            total_deposit = sum(amounts)
            self.balance += total_deposit
            print(f"Deposited {total_deposit} dollars (total of {len(amounts)} deposits). Current balance: {self.balance}")
        else:
            print("No amount provided to deposit.")

    def get_balance(self):
        return self.balance

# Example usage:
if __name__ == "__main__":
    # Create a bank account with an initial balance of 100
    account = BankAccount(100)

    # Deposit a single amount
    account.deposit(50)

    # Deposit multiple amounts at once (using a tuple)
    account.deposit(20, 30, 10)

    # Deposit with no amount (this should handle the case where no amount is provided)
    account.deposit()

    # Print the final balance
    print(f"Final balance: {account.get_balance()}")
