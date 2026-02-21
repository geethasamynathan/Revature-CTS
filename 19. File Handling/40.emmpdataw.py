class Employee:
    def __init__(self, emp_id, name, designation):
        self.emp_id = emp_id
        self.name = name
        self.designation = designation
    
    def __str__(self):
        return f"ID: {self.emp_id}, Name: {self.name}, Designation: {self.designation}"

    @staticmethod
    def get_employee_info():
        emp_id = input("Enter Employee ID: ")
        name = input("Enter Employee Name: ")
        designation = input("Enter Employee Designation: ")
        return Employee(emp_id, name, designation)


def main():
    employees = []

    # Get employee data from the user (two employees)
    for i in range(2):
        print(f"\nEnter details for Employee {i + 1}:")
        employee = Employee.get_employee_info()
        employees.append(employee)
    
    # Writing employee data to a file
    with open("employee_data.txt", "w") as file:
        file.write("Employee Data\n")
        file.write("-" * 50 + "\n")
        for employee in employees:
            file.write(str(employee) + "\n")

    print("\nEmployee data has been written to 'employee_data.txt'.")


# Run the main function
if __name__ == "__main__":
    main()
