/*
 * this is the junit test for BruteAutoComplete
 */

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class BruteAutoCompleteTest {
	
	private BruteAutoComplete1 auto;
	
	@Test
	public void testWeightOf() {
		try {
			auto = new BruteAutoComplete1();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found Error");
			e.printStackTrace();
		}
		assertEquals(703754300,auto.weightOf("as"),0.01);
		assertEquals(396041,auto.weightOf("mon"),0.01);
		assertEquals(0.0,auto.weightOf("xyz"),0.01);
	}

	@Test
	public void testBestMatch()
	{
		try {
			auto = new BruteAutoComplete1();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found Error");
			e.printStackTrace();
		}
		assertEquals("the",auto.bestMatch("th"));
		assertEquals("zone",auto.bestMatch("zo"));
	}
	
	@Test
	public void testMatches()
	{
		try {
			auto = new BruteAutoComplete1();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found Error");
			e.printStackTrace();
		}
		Iterator<String> result = auto.matches("th", 3).iterator();
		while(result.hasNext())
		{
			assertEquals("the",result.next());
			assertEquals("that",result.next());
			assertEquals("this",result.next());
			break;
		}
	}
}
