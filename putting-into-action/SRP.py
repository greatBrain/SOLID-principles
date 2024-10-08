''' 
Exercise: 
We have an employee management system in a company. 
Currently, a class called EmployeeManager handles new employee registration, report generation, 
and salary calculation. 

Refactor the design so that each of these responsibilities are in separate classes (for example, 
EmployeeRegister, SalaryCalculator, and ReportGenerator). Each class should have a single responsibility.
'''


# Wrong code:

class EmployeeManager:
    def __init__(self, emp_name:str, emp_last_name:str, emp_identification:str):
        self.emp_name:str = emp_name
        self.emp_last_name:str = emp_last_name
        self.emp_identification:str = emp_identification

        self.employees:dict = dict()


    def add_employee(self, employee:dict) -> bool:
        if self.emp_name not in self.employees:
           self.employees.update({"name":self.emp_name})  

        return True

    def get_employees(self) -> dict:
        return self.employees


    def get_employee_salary(self) -> float:
        return 


    ''' etc, etc....'''



# Good code: we separate into classes and give just a responsability for each class.
class Database:      
      # Logic 

class EmployeeRegister:
      # Logic 

class SalaryManager:
      # Logic 

class ReportManager:
      # Logic
