/*
 * this is the junit test for the term class
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TermTest {

	@Test
	public void testGetters() {
		Term word = new Term(100,"test");
		assertEquals(100,word.getWeight(),0.01);
		assertEquals("test",word.getWord());
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testConstructor()
	{
		Term word = new Term(-1,"test");
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testConstructor2()
	{
		Term word = new Term(1,null);
	}
	
	@Test 
	public void testSetters()
	{
		Term word = new Term(100,"test");
		word.setWeight(120);
		word.setWord("test2");
		assertEquals(120,word.getWeight(),0.01);
		assertEquals("test2",word.getWord());
	}
	
	@Test 
	public void testToString()
	{
		Term word = new Term(100,"test");
		assertEquals("StoreWord [weight=" + 100.0 + ", word=" + "test" + "]",word.toString());
	}

}
