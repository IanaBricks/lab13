import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class lab13Test
{
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data";
	String expectedResultsFilename = "lab13_expected_results";

	@BeforeEach
	public void setUp() throws Exception 
	{
		// instantiate an instance of lab13
		lab = new lab13();
		
		// read the input value and populate the ArrayList<Integer> in the lab13 class
		lab.readData(inputFilename);
		
		// testData.get(0) has the expected results for getResult1()
		// testData.get(1) has the expected results for getResult2()
		// testData.get(2) has the expected results for getResult3()
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in testData.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
			expectedResult1 = new Integer[testData.get(0).size()];
			for(int x = 0; x < testData.get(0).size(); x++)
			{
				expectedResult1[x] = (testData.get(0)).get(x);
			}
			
			// put code here to populate expectedResult2 with the values in testData.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
			expectedResult2 = new Integer[testData.get(1).size()];
			for(int x = 0; x < testData.get(1).size(); x++)
			{
				expectedResult2[x] = (testData.get(1)).get(x);
			}
			
			// put code here to populate expectedResult3 with the values in testData.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
			expectedResult3 = new Integer[testData.get(2).size()];
			for(int x = 0; x < testData.get(2).size(); x++)
			{
				expectedResult3[x] = (testData.get(2)).get(x);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}		
	}
	
	@Test
	public void testgetTotalCount()
	{
		assertEquals(lab.getTotalCount(), 1000);
	}
	
	@Test
	public void testgetOddCount()
	{
		assertEquals(lab.getOddCount(), 507);
	}
	
	@Test
	public void testgetEvenCount()
	{
		assertEquals(lab.getEvenCount(), 493);
	}
	
	@Test
	public void testgetDistinctGreaterThanFiveCount()
	{
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
	}
	
	@Test
	public void testgetResult1()
	{
		assertArrayEquals(lab.getResult1(), expectedResult1);
	}
	
	@Test
	public void testgetResult2()
	{
		assertArrayEquals(lab.getResult2(), expectedResult2);
	}
	
	@Test
	public void testgetResult3()
	{
		assertArrayEquals(lab.getResult3(), expectedResult3);
	}
}
