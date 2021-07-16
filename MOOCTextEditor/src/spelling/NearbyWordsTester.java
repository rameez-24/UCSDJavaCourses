package spelling;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NearbyWordsTester {
	
	private String dictFile = "data/dict.txt"; 
	
	List<String> currList;
	Dictionary dict;
	NearbyWords nw;
	
	@Before
	public void setUp() throws Exception {
		
		dict = new DictionaryHashSet();
//		DictionaryLoader.loadDictionary(dict, dictFile);
		
		nw = new NearbyWords(dict);
		currList = new ArrayList<String>();
	}
	
	@Test
	public void substitutionTest() throws Exception {
		
		nw.substitution("a", currList, false);
		assertEquals("Testing total no of substitutions",25,currList.size());
		assertEquals("Testing original string",false,currList.contains("a"));
		assertEquals("Testing first element","b",currList.get(0));

		currList.clear();
		nw.substitution("abc", currList, false);
		assertEquals("Testing total no of substitutions",75,currList.size());
		assertEquals("Testing random string",false,currList.contains("abcd"));
		assertEquals("Testing last element","abz",currList.get(currList.size()-1));
		
		currList.clear();
		nw.substitution("", currList, false);
		assertEquals("Testing total no of substitutions",0,currList.size());
		assertEquals("Testing random string in list",false,currList.contains("a"));
		
	}

	@Test
	public void insertionsTest() throws Exception {
		
		nw.insertions("a", currList, false);
		assertEquals("Testing total no of substitutions",51,currList.size()); // "aa" appears twice
		assertEquals("Testing original string in list",false,currList.contains("a"));
		assertEquals("Testing first string in list","aa",currList.get(0));

		currList.clear();
		nw.insertions("abc", currList, false);
		assertEquals("Testing total no of substitutions",26*4-3,currList.size()); // aabc abbc abcc
		assertEquals("Testing random string in list",false,currList.contains("abcde"));
		assertEquals("Testing last string in list","abcz",currList.get(currList.size()-1));
		
		currList.clear();
		nw.insertions("", currList, false);
		assertEquals("Testing total no of substitutions",0,currList.size());
		assertEquals("Testing random string in list",false,currList.contains("a"));
		
	}
	
	@Test
	public void deletionsTest() throws Exception {
		
		nw.deletions("a", currList, false);
		assertEquals("Testing total no of substitutions",0,currList.size()); // empty list
		assertEquals("Testing original string in list",false,currList.contains("a"));

		currList.clear();
		nw.deletions("abcdef", currList, false);
		assertEquals("Testing total no of substitutions",6,currList.size());
		assertEquals("Testing random string in list",true,currList.contains("abcde"));
		assertEquals("Testing last string in list","abcde",currList.get(currList.size()-1));
		
		currList.clear();
		nw.deletions("", currList, false);
		assertEquals("Testing total no of substitutions",0,currList.size());
		assertEquals("Testing random string in list",false,currList.contains("a"));
		
	}
}
