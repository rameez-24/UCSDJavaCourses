/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		int i = 0;
		while (longerList.size()>0) {
			assertEquals("Check all elements", (Integer)i, longerList.remove(0));
			i++;
		}
		
		assertEquals("Check first", "A", shortList.remove(0));
		assertEquals("Check second", "B", shortList.remove(0));
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			list1.add(null);
			fail("Should not be able to add null values");
		} catch (NullPointerException e) {
		
		}
		
		
		try {
			emptyList.add(null);
			fail("Should not be able to add null values");
		} catch (NullPointerException e) {
		
		}
		
		boolean flag = emptyList.add(1);
		assertEquals("Adding an element to an empty list",true,flag);
		assertEquals("Checking the added element",(Integer)1,emptyList.get(0));
		assertEquals("Checking the list size",1,emptyList.size());
		
		boolean flag2 = list1.add(-10);
		assertEquals("Adding an element to an empty list",true,flag2);
		assertEquals("Checking the added element",(Integer)(-10),list1.get(list1.size()-1));
		assertEquals("Checking the list size",4,list1.size());
		assertEquals("Checking the previous element",(Integer) 42,list1.get(list1.size()-2));

	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Checking the list size",0,emptyList.size());
		assertEquals("Checking the list size",3,list1.size());
		assertEquals("Checking the list size",10,longerList.size());
		shortList.add("C");
		assertEquals("Checking the list size",3,shortList.size());
		shortList.remove(1);
		assertEquals("Checking the list size",2,shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list1.add(0, null);
			fail("Should not be able to add null values");
		} catch (NullPointerException e) {
		
		}
		
		try {
			emptyList.add(0,null);
			fail("Should not be able to add null values");
		} catch (NullPointerException e) {
		
		}
		
		try {
			list1.add(6, 10);
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			emptyList.add(-1, 1);
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			emptyList.add(1, 1);
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		emptyList.add(0,1);
		assertEquals("Checking the added element",(Integer)1,emptyList.get(0));
		assertEquals("Checking the list size",1,emptyList.size());
		
		list1.add(list1.size(),-10);
		assertEquals("Checking the added element",(Integer)(-10),list1.get(list1.size()-1));
		assertEquals("Checking the list size",4,list1.size());
		assertEquals("Checking the previous element",(Integer) 42,list1.get(list1.size()-2));
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			list1.set(0, null);
			fail("Should not be able to add null values");
		} catch (NullPointerException e) {
		
		}
		
		try {
			emptyList.set(0,null);
			fail("Should not be able to add null values");
		} catch (NullPointerException e) {
		
		}
		
		try {
			emptyList.set(0,2);
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			list1.set(6, 10);
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			emptyList.set(-1, 1);
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.set(3, "c");
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.set(2, "c");
			fail("Should not be able to add values out of bounds");
		} catch (IndexOutOfBoundsException e) {
		
		}
		
		assertEquals("Checking the added element",(Integer) 42,list1.set(list1.size()-1,-10));
		assertEquals("Checking the list size",3,list1.size());
		assertEquals("AddAtIndex: check return is correct ", (Integer)2, longerList.set(2, 10));
		assertEquals("AddAtIndex: check value is correct ", (Integer)10, longerList.get(2));
		assertEquals("AddAtIndex: check size is correct", 10, longerList.size());
		
		assertEquals("AddAtIndex: check return is correct ", "B", shortList.set(1, "C"));
		assertEquals("AddAtIndex: check value is correct ", "C", shortList.get(1));
		assertEquals("AddAtIndex: check size is correct", 2, shortList.size());
	    
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)(i), longerList.set(i,i+10));
			assertEquals("Check "+i+ " element", (Integer)(i+10), longerList.get(i));
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
