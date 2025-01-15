This note is about Hash (Hashing), I won't go indepth in this note, you can find more information on GeeksForGeeks.

But to simplify:

- Hashing Function which are functions used for Hashing
- Collision which are the prevention of 2 data having the same hash
- Hashing Table which are in table format

More importantly are the `HashMap` and `HashTable`:

`HashTable` and `HashMap` are generally the same thing, they are a pair of key-value array. The only thing that is difference is `HashTable` is thread safe and synchronized.

Here is an example of `HashMap` in Java:

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        System.out.println(map.get("Bob")); // Output: 30
    }
}
```

Here is an example of `HashTable` in Java:

```java
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("Alice", 25);
        table.put("Bob", 30);
        table.put("Charlie", 35);

        System.out.println(table.get("Charlie")); // Output: 35
    }
}
```

In Python, there is something similar called `dict` stands for dictionary, it is a key-pair value array. Here is an example of using `dict` to find the frequency of numbers appearances.

```python
# Example: Counting frequency of numbers in a list
numbers = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]

# Using a dictionary to count frequency
frequency = {}
for num in numbers:
    if num in frequency:
        frequency[num] += 1
    else:
        frequency[num] = 1

print(frequency)  # Output: {1: 1, 2: 2, 3: 3, 4: 4}
```
