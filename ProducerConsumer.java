class Calculate 
{
	double num;
	boolean check = false;

	synchronized void number(double num)
	{
		try {
			if(check == true)	
				wait();
		}
		catch(InterruptedException ie) {}
		this.num = num;
		System.out.println("Number is " + num);
		check = true;
		notify();
	}

	synchronized void root()
	{
		try {
			if(check == false) 
				wait();		
		}
		catch(InterruptedException ie) {}
		System.out.println("Root is " + Math.sqrt(num));
 		check = false;
		notify();
	}
}

class Produce implements Runnable 
{
	Thread t;
	Calculate calc;

	Produce(Calculate calc)
	{
		this.calc = calc;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		try {
			for(int i = 0; i < 6; i++)
			{
				calc.number((double)i);
				Thread.sleep(300);		
			}
		}
		catch(InterruptedException ie) {}
	}
}

class Consume implements Runnable 
{
	Thread t;
	Calculate calc;

	Consume(Calculate calc)
	{
		this.calc = calc;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		try {
			for(int i = 0; i < 6; i++)
			{
				calc.root();
				Thread.sleep(50); 
			}
		}
		catch(InterruptedException ie) {}
	}
}

class producerConsumer
{
	public static void main(String[]args)
	{
		Calculate calc = new Calculate();

		Produce p = new Produce(calc);
		Consume c = new Consume(calc);
	}
}