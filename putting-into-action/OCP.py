# Open/closed principle. 
# Code must be open for extension but closed for modification. 

# Example of a bad code. Let's say we have a little notification system, like this:

class Notification:
      def __init__(self, message:str):
          self.message = message


      def notify_by_sms(self):
          return "Notifying by sms... {}".format(self.message)


      '''So, if we want to add another notification service, we have to modify this class
      and the OCP wouldn't exist.'''



# Refactoring to a better implementation:
# ======================================

class Notification:      
      def notify(self, message):
          raise NotImplementedError("Subclass must implement this method!")


# SMS notification:
class SMSNotification(Notification):
      def notify(self, message):
          print("Sending a SMS message... {}".format(message))


# Mail notification Service:
class MailNotification(Notification):
      def notify(self, message):
          print("Sending an email.... {}".format(message))



# Notification client:
def send_notification_to_user(notificationMethod:object, message: str):
    notificationMethod.notify(message)



# Notifying using SMS
sms = SMSNotification()

#MAIL
mail = MailNotification()



send_notification_to_user(mail, "")
