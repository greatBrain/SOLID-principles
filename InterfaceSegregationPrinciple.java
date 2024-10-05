/* 
 Interface Segregation Principle (ISP) states that "clients should not be forced to depend on interfaces they do not use." That is, it is better to have small, specific interfaces rather than one large, general interface that forces classes to implement methods they do not need.

Key Idea: Instead of creating one giant interface that has many methods, it is better to split it into several smaller, focused interfaces, so that classes implementing these interfaces only have to comply with the methods that are actually useful to them.

Practical Example: Imagine you are developing a card payment system. If you had an interface called PaymentProcessor with methods to process different types of payments, such as:
  */

public interface PaymentProcessor
{
	void processCreditCardPayment();
    void processDebitCardPayment();
    void processMobilePayment();
}

/*
 Now, let's say you have a CreditCardProcessor class that only needs to process credit card payments. This class would be forced to implement methods that it doesn't use, which makes no sense:
 */

public class CreditCardProcessor implements PaymentProcessor 
{
    @Override
    public void processCreditCardPayment()
	{
        System.out.println("Processing credit card payment");
    }

    @Override
    public void processDebitCardPayment()
	{
        // No need
    }

    @Override
    public void processMobilePayment()
	{
        // No need
    }
}

/*
problem
=======

The Credit Card Processor class implements methods that it does not use, which is wasteful and confusing. 
*/

/*
ISP Solution
============

Instead of having one big interface with unnecessary methods, you can split it into several smaller, more specific interfaces:
 */


public interface CreditCardPaymentProcessor
{
    void processCreditCardPayment();
}

public interface DebitCardPaymentProcessor
{
    void processDebitCardPayment();
}

public interface MobilePaymentProcessor
{
    void processMobilePayment();
}

/*
 Now, the Credit Card Processor class only implements the interface it needs:
 */

public class CreditCardProcessor implements CreditCardPaymentProcessor
{
	@Override
	public void processCreditCardPayment()
	{
		System.out.println("Processing credit card payment... Wait a few!");
	}
}

/*
Advantages
==========

Fewer unnecessary methods: 
Classes only implement what they actually use.

Flexibility: Small interfaces allow each class to focus only on its task, making it easier to maintain and extend.

Reduced coupling: Classes are not tied to an interface that does not fit their purpose. 
*/

/*
Wraping up....

Consider a file handling application. Instead of having a huge interface like FileHandler with methods for reading, writing, and compressing files, you could have smaller interfaces like Readable, Writable, and Compressible. A class that only needs to read files would implement Readable and not have to deal with writing or compressing methods.

*/
