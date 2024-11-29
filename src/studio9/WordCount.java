package studio9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map; 

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2;
	 * key="be", value=2;
	 * key="or", value=1;
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {
		Map<String, Integer> wordCounts = new HashMap<>(); // Create a HashMap to store word counts
		for (String word : words) { // Iterate through the list of words
			wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1); // Increment the word count
		}

		return wordCounts; // Return the map
	}

	public static void main(String[] args) {

		List<String> wordList = new LinkedList<>();
		wordList.add("to");
		wordList.add("be");
		wordList.add("or");
		wordList.add("not");
		wordList.add("to");
		wordList.add("be");
		Map<String, Integer> words = countWords(wordList);

		//TODO: Write code that will iterate over the words map
		//to verify its contents
		for(Map.Entry<String, Integer> entry:words.entrySet()) { 
			System.out.println("Word: "+entry.getKey() + ", Count: "+ entry.getValue()); 
		}
	} 
} 
