''' 
This principle states that:

- High-level classes should not depend on low-level classes.
- Both should depend on abstractions.
- Abstractions should not depend on details, but details should depend on abstractions.

Let's see an Wrong design, without using DIP (Dependency Inversion Principle): '''


''' 
We are developing a notifications application. You have a NotificationService class that sends notifications via email. 
But what if in the future you want to send notifications via SMS, or some other way?
'''

class EmailSender:
    def send_email(self, message: str):
        print(f"Sending email: {message}")

class NotificationService:
    def __init__(self):
        self.email_sender = EmailSender()  # Low level class dependency

    def notify(self, message: str):
        self.email_sender.send_email(message)  # Just email notifications


service = NotificationService()
service.notify("Hello SOLID!")

''' 
The problem is that NotificationService depends directly on EmailSender. If you need to send SMS messages in the future, you will have to modify the NotificationService class to support this new functionality.

Solution applying DIP:

To apply the Dependency Inversion Principle, we extract an interface or 
abstraction for the message sending behavior and make NotificationService dependent on that abstraction, 
not on the concrete implementation. This allows us to easily interchange different ways of sending notifications.
'''

# Interface
from abc import ABC, abstractmethod

class MessageSender(ABC):
     
     @abstractmethod
     def sender(self, message:str):
         pass


# Implement low level classes:
class EmailSender(MessageSender):
      def send(self, message:str):
          print(f"Sending email: {message}")


class SMSSender(MessageSender):
      def send(self, message: str):
          print(f"Sending SMS: {message}")



# High-level class
class NotificationService:
      def __init__(self, sender: MessageSender):
          self.sender = sender # Depending from abstraction, not details.

      def notify(self, message: str):
          self.sender.send(message)


''' 
We can now pass any MessageSender implementation to NotificationService, and the system will work without needing to modify thehigh-level class code.
'''

# Sending by email
email_service = NotificationService(EmailSender())
email_service.notify("Hello by Email!")

# Sending by SMS
sms_service = NotificationService(SMSSender())
sms_service.notify("Hello by SMS!")
