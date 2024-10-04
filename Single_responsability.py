# Single responsability. The very first of the principles. It stands that a class
# should always have one and only one reason to be.

# BAD CODE:

class PaymentManager:
    def __init__(self, order:dict={}, payment_method:str):
        self.data_order = order
        self.payment_method = payment_method

    def proccess_payment(self)-> any:
        # Payment logic here
        pass


    def save_to_database(self)-> None:
        # Database operations logic here
        pass
# Here we can see that the class above doesn't implement just a method.



# GOOD implementation. Single responsability classes:
class PaymentManager:
      def __init__(self, order:dict={}, payment_method:str):
         self.data_order = order
         self.payment_method = payment_method
     
      def proccess_payment(self)-> any:
          # Payment logic here
          pass


class DataStore:
      def save_to_database(self)-> None:
          # Database operations logic here
          pass


'''Here we refactor the code and split the PaymentManager class into other class that manages the 
database saving data'''
      

