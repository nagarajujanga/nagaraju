
// STATIC SYNCHRONIZED BLOCK ---  INNER THREAD COMMUNICATION


class AndhraBank 
{
	int balance=15000;
	public static void withdrawl(int withdrawlAmount)
	{
		synchronized(AndhraBank.class)
		{
	
		if(balance<withdrawl)
		{
			System.out.println("\t \n Your account balance is lessthan the withdrwal amount");
			System.out.println("\t \n Available balance is:"   +balance + ".Please deposit the money");
			
		}
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}	

    	}
	}
}

		public static void deposit(int DepositAmount) 
		{
			synchronized(AndhraBank.class)
			{
			balance=balance+DepositAmount;
			System.out.println("\n Available balance is:"+balance);
			notify();
			}
		
	}
}

	class WithdrawlThread extends Thread
	{
		AndhraBank Andb;
		int withdrawlAmount;
		
	public void run()
		{
		Andb.withdrawl(withdrawlAmount);	
		}
		
	}
class DepositThread extends Thread
	{
		AndhraBank Andb;
		int DepositAmount;
		
	public void run()
		{
		Andb.deposit(DepositAmount);	
		}
	}

	class InnerThreadCommDemo2
	{
	
	public static void main(String[] args) 
	{
		
			withdrwalthread.start();
			depositthread.start();

	}
}
