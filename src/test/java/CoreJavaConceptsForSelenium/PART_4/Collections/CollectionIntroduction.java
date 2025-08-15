package CoreJavaConceptsForSelenium.PART_4.Collections;

public class CollectionIntroduction {

    /**
     * Collections
     * It is a collection/Combination of Functions and classes that can be used
     * to process data efficiently
     *
     * Collections are of 3 types
     *
     * List -> ArrayList, LinkedList, Vector
     * Maps -> hashmap, treemap, LinkedHashmap
     * Set -> hashset, treeSet, linkedHashset
     *
     */

    ///  All HashMap, HashSet has O(1) time complexity
    ///  All LinkedHashMap, LinkedSet or LinkedList has O(1) as well
    ///  Tree has O(log (n))

    /**
     * Java Collections Quick Comparison
     * Feature / Type	List (ArrayList, LinkedList, Vector, Stack)	Set (HashSet, LinkedHashSet, TreeSet)	Map (HashMap, LinkedHashMap, TreeMap, Hashtable)
     * Stores Duplicates?	✅ Yes	❌ No	❌ Keys No (Values can repeat)
     * Order Maintained?	ArrayList / Vector – Insertion order
     * LinkedList – Insertion order
     * Stack – LIFO	HashSet – No order
     * LinkedHashSet – Insertion order
     * TreeSet – Sorted order	HashMap – No order
     * LinkedHashMap – Insertion order
     * TreeMap – Sorted by key
     * Hashtable – No order
     * Null Allowed?	✅ Multiple nulls allowed	✅ Only one null element	✅ One null key (except TreeMap & Hashtable), multiple null values
     * Thread-Safe?	❌ Not thread-safe (except Vector & Stack)	❌ Not thread-safe	❌ Not thread-safe (except Hashtable)
     * Performance	ArrayList – Fast random access, slow insert/remove in middle
     * LinkedList – Fast insert/remove, slow random access	HashSet – Fast lookups
     * TreeSet – Slower (sorted)	HashMap – Fast lookups
     * TreeMap – Slower (sorted)
     * Duplicates Handling	Can store duplicates exactly as inserted	Automatically removes duplicates	Keys overwrite previous value if duplicate key inserted
     * Typical Use Cases	Ordered data, frequent random access, stack/queue implementations	Unique elements, set operations (union, intersection)	Key-value mappings, dictionary-like lookups
     *
     * One-line summary:
     * List → Ordered, allows duplicates.
     *
     * Set → No duplicates, order depends on implementation.
     *
     * Map → Key-value pairs, keys unique, values can repeat.
     */
}
