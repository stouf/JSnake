public class Main
{
	static public void main(String[] args)
	{
		if(args.length <=0)
		{
			new Game("");
		}
		else
		{
			new Game(args[0]);
		}
		
		System.gc();
	}
}
