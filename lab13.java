import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.stream.*;

public class lab13
{
	private ArrayList<Integer> temp;
	lab13()
	{
		temp = new ArrayList<Integer>();
	}

	public void readData(String filename)
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			
			while((inn = input.readLine()) != null)
			{
				temp.add(Integer.parseInt(inn));
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public long getTotalCount()
	{
		return (temp.stream()).count();
	}
	
	public long getOddCount()
	{
		return ((temp.stream()).filter(x -> x % 2 == 1)).count();
	}
	
	public long getEvenCount()
	{
		return ((temp.stream()).filter(x -> x % 2 == 0)).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return (((temp.stream()).filter(x -> x > 5)).distinct()).count();
	}
	
	public Integer[] getResult1()
	{
		return (((temp.stream()).filter(x -> x > 5 && x < 50 && x % 2 == 0)).sorted()).toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return temp.stream().map(x -> (x*x)*3).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return temp.stream().filter(x -> x%2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
