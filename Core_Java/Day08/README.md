# Day 08 – Core Java

## Topics Covered

### 1. String Handling in Java

A **String** is a sequence of characters used to represent text in Java.

Java provides three commonly used classes for string handling:

1. `String`
2. `StringBuilder`
3. `StringBuffer`

These classes are used to store and manipulate text, but they differ in mutability and thread safety.

#### a. String Class

The `String` class represents an immutable sequence of characters.

**Immutable** means that once a String object is created, its content cannot be changed.

If we perform an operation that appears to modify a String, Java creates a new String object instead of changing the original object.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        String str = "Hello";

        str.concat(" Java");

        System.out.println(str);

        str = str.concat(" Java");

        System.out.println(str);
    }
}
```

**Output:**

```text
Hello
Hello Java
```

**Explanation:**

- `str` initially refers to the String `"Hello"`.
- `concat()` creates a new String containing `"Hello Java"`.
- In the first operation, the returned String is not assigned, so `str` remains unchanged.
- In the second operation, the new String reference is assigned to `str`.

**Important Characteristics of String:**

- String objects are immutable.
- String literals can be stored in the String Constant Pool.
- Strings can be created using literals or the `new` keyword.
- The `String` class provides methods for searching, comparing, extracting, and modifying text by creating new String objects.

**Common String Methods:**

| Method | Purpose |
|---|---|
| `length()` | Returns the number of characters |
| `charAt(index)` | Returns the character at a given index |
| `concat(str)` | Combines two strings |
| `equals(str)` | Compares string contents |
| `equalsIgnoreCase(str)` | Compares contents ignoring case |
| `compareTo(str)` | Compares strings lexicographically |
| `substring()` | Extracts part of a string |
| `toUpperCase()` | Converts to uppercase |
| `toLowerCase()` | Converts to lowercase |
| `trim()` | Removes leading and trailing characters recognized as whitespace |
| `contains()` | Checks whether a sequence exists |
| `replace()` | Replaces matching characters or sequences |
| `indexOf()` | Finds the position of a character or substring |

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        String str = "Core Java";

        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.substring(5));
        System.out.println(str.contains("Java"));
    }
}
```

**Output:**

```text
9
C
CORE JAVA
core java
Java
true
```

Practiced creating String objects, using common String methods, and understanding why String objects are immutable.

#### b. StringBuilder Class

`StringBuilder` is a mutable sequence of characters.

**Mutable** means its contents can be modified without creating a new object for every modification.

It is useful when a program performs frequent String modifications.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" Java");
        System.out.println(sb);

        sb.insert(5, " Core");
        System.out.println(sb);

        sb.replace(0, 5, "Welcome");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
    }
}
```

**Output:**

```text
Hello Java
Hello Core Java
Welcome Core Java
avaJ eroC emocleW
```

**Common StringBuilder Methods:**

| Method | Purpose |
|---|---|
| `append()` | Adds content at the end |
| `insert()` | Inserts content at a specified position |
| `replace()` | Replaces characters within a specified range |
| `delete()` | Removes characters within a specified range |
| `deleteCharAt()` | Removes a character at a specified index |
| `reverse()` | Reverses the sequence |
| `capacity()` | Returns the current capacity |
| `length()` | Returns the number of characters |
| `setCharAt()` | Changes a character at a specified index |

**Characteristics of StringBuilder:**

- Mutable sequence of characters.
- Efficient for repeated String modifications.
- Not synchronized.
- Not thread-safe when shared between multiple threads without external synchronization.
- Generally faster than StringBuffer in single-threaded modification scenarios.

Practiced modifying strings using `append()`, `insert()`, `replace()`, `delete()`, and `reverse()`.

#### c. StringBuffer Class

`StringBuffer` is also a mutable sequence of characters.

It provides methods similar to `StringBuilder`, but its methods are synchronized.

Synchronization makes its individual operations thread-safe when accessed by multiple threads.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello");

        sb.append(" Java");
        System.out.println(sb);

        sb.insert(5, " Core");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
    }
}
```

**Output:**

```text
Hello Java
Hello Core Java
avaJ eroC olleH
```

**Characteristics of StringBuffer:**

- Mutable sequence of characters.
- Provides synchronized methods.
- Thread-safe for its synchronized individual operations.
- Suitable when mutable text is shared across multiple threads.
- Can have synchronization overhead compared with StringBuilder.

**String vs StringBuilder vs StringBuffer**

| Feature | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Mutability | Immutable | Mutable | Mutable |
| Thread safety | Safe due to immutability | Not synchronized | Synchronized methods |
| Modification | Creates new String objects | Modifies existing object | Modifies existing object |
| Performance for repeated modifications | Usually less efficient | Generally faster | Synchronization overhead |
| Typical usage | Fixed or rarely modified text | Single-threaded modifications | Shared mutable text |

Practiced using all three classes and understanding their differences in mutability, synchronization, and performance.

---

### 2. `==` vs `equals()`

Java provides `==` and `equals()` for comparing values and objects.

They have different purposes depending on whether primitive values or object references are being compared.

#### a. `==` Operator

For primitive data types, `==` compares actual values.

For reference types, `==` checks whether two references point to the same object.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;

        System.out.println(a == b);

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1 == s2);
    }
}
```

**Output:**

```text
true
false
```

#### b. equals() Method

The `equals()` method compares object contents when the class provides a suitable implementation.

The String class overrides `equals()` to compare the actual character sequences.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1.equals(s2));
    }
}
```

**Output:**

```text
true
```

#### Comparison

| `==` | `equals()` |
|---|---|
| Operator | Method |
| Compares primitive values | Compares objects according to implementation |
| For references, checks identity | String overrides it to check content |
| Cannot be overridden | Can be overridden |

**Important Point:** The default implementation of `Object.equals()` checks object identity. Classes such as `String` override it to provide content-based comparison.

Practiced comparing String objects using `==` and `equals()` and understanding reference equality versus content equality.

---

### 3. String Literal and Non-Literal

Strings in Java can be created using String literals or by explicitly creating objects using the `new` keyword.

#### a. String Literal

A String literal is a sequence of characters written inside double quotes.

**Example:**

```java
String s1 = "Java";
String s2 = "Java";
```

Java maintains String literals in the String Constant Pool.

When the same literal is used again, Java can reuse the existing pooled String object.

**Conceptual Representation:**

```text
String Constant Pool

       +----------+
s1 --->|  "Java"  |
       |          |
s2 --->| Same     |
       | Object   |
       +----------+
```

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

**Output:**

```text
true
true
```

Both references point to the same pooled String object.

#### b. Non-Literal String

A String object can be explicitly created using the `new` keyword.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

**Output:**

```text
false
true
```

**Explanation:**

- `new String("Java")` explicitly creates a new String object.
- The two variables refer to different String objects.
- Their contents are identical.
- Therefore, `==` returns `false`, while `equals()` returns `true`.

#### c. intern() Method

The `intern()` method returns the canonical String from the String Constant Pool.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        String s1 = new String("Java");
        String s2 = "Java";

        String s3 = s1.intern();

        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
    }
}
```

**Output:**

```text
false
true
```

#### String Literal vs Non-Literal

| String Literal | Non-Literal |
|---|---|
| Created using double quotes | Explicitly created using `new String()` |
| Uses String Constant Pool | Creates a separate String object |
| Identical literals can share a pooled object | Each `new String()` creates a distinct object |
| Example: `"Java"` | Example: `new String("Java")` |

Practiced creating literal and non-literal String objects, comparing their references, and understanding the purpose of `intern()`.

---

### 4. Date and Time Handling in Java – Date Class

Java provides classes to represent, manipulate, parse, and format date and time values.

Initially, Java used the legacy Date and Calendar API from the `java.util` package.

The `Date` class represents a specific instant in time, with precision to milliseconds.

#### a. Date Class

The `Date` class belongs to the `java.util` package.

**Example:**

```java
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date d1 = new Date();

        System.out.println(d1);

        Date d2 = new Date(0);

        System.out.println(d2);
    }
}
```

**Output (illustrative):**

```text
Fri Nov 27 18:10:00 IST 2026
Thu Jan 01 00:00:00 UTC 1970
```

**Explanation:**

- `new Date()` creates an object representing the current date and time.
- `new Date(0)` represents the Unix epoch instant: January 1, 1970, at 00:00:00 UTC.
- The Date object internally represents time as milliseconds from the Unix epoch.
- The displayed date depends on the system's default time zone.

#### b. Common Date Methods

| Method | Purpose |
|---|---|
| `new Date()` | Creates the current date and time |
| `getTime()` | Returns milliseconds since the epoch |
| `before(date)` | Checks whether a date is before another |
| `after(date)` | Checks whether a date is after another |
| `equals(date)` | Compares two Date objects |
| `toString()` | Returns a String representation of the date |

**Example:**

```java
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date d1 = new Date();

        System.out.println(d1);
        System.out.println(d1.getTime());
        System.out.println(d1.toString());
    }
}
```

**Important Points:**

- `Date` is a legacy class.
- It represents an instant in time rather than a date-only value.
- Its older component manipulation methods are deprecated.
- It is still used in older Java applications and APIs.

---

### 5. Parsing and Formatting Date Using SimpleDateFormat

When working with dates, we often need to convert a date object into a String or convert a String into a date object.

These operations are called formatting and parsing.

#### a. SimpleDateFormat

`SimpleDateFormat` belongs to the `java.text` package.

It is used to parse and format date values according to a specified pattern.

**Syntax:**

```java
SimpleDateFormat sdf =
        new SimpleDateFormat("dd-MM-yyyy");
```

#### b. Formatting

**Formatting** means converting a Date object into a String representation in a required pattern.

**Example:**

```java
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {

        Date date = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy");

        String formattedDate = sdf.format(date);

        System.out.println(formattedDate);
    }
}
```

**Output (date-dependent):**

```text
27-11-2026
```

**Explanation:**

- `new Date()` creates the current date and time.
- `SimpleDateFormat` defines the required date pattern.
- `format()` converts the Date object into a String.
- The resulting String follows the specified pattern.

#### c. Parsing

**Parsing** means converting a String containing a date into a Date object.

The `parse()` method is used for this operation.

**Example:**

```java
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {

    public static void main(String[] args)
            throws ParseException {

        String dateString = "27-11-2026";

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy");

        Date date = sdf.parse(dateString);

        System.out.println(date);
    }
}
```

**Explanation:**

- `dateString` contains the date in String format.
- `SimpleDateFormat` defines how the String should be interpreted.
- `parse()` converts the String into a Date object.
- `ParseException` can occur when the String cannot be parsed.

**Note:** By default, `SimpleDateFormat` may accept some date values that are out of range by adjusting them. Use `setLenient(false)` when strict validation is required.

#### d. Common SimpleDateFormat Patterns

| Pattern | Meaning | Example |
|---|---|---|
| `dd` | Day of month | `27` |
| `MM` | Month number | `11` |
| `MMM` | Short month name | `Nov` |
| `MMMM` | Full month name | `November` |
| `yyyy` | Year | `2026` |
| `HH` | Hour in 24-hour format | `18` |
| `hh` | Hour in 12-hour format | `06` |
| `mm` | Minutes | `10` |
| `ss` | Seconds | `45` |
| `a` | AM/PM marker | `PM` |

**Important:** Uppercase `MM` represents the month, whereas lowercase `mm` represents minutes.

#### e. Parsing vs Formatting

| Parsing | Formatting |
|---|---|
| String to Date object | Date object to String |
| Uses `parse()` | Uses `format()` |
| Converts text into a date | Converts a date into readable text |

Practiced creating Date objects, converting dates into formatted Strings, and parsing String values into Date objects using `SimpleDateFormat`.

---

### 6. Modern Date and Time API – java.time Package

Java 8 introduced the modern Date and Time API in the `java.time` package.

The modern API provides separate classes for dates, times, date-time combinations, and time zones.

It is designed to overcome many limitations of the older Date and Calendar APIs.

#### Important Classes in java.time

| Class | Purpose |
|---|---|
| `LocalDate` | Represents date without time or time zone |
| `LocalTime` | Represents time without date or time zone |
| `LocalDateTime` | Represents date and time without time zone |
| `ZonedDateTime` | Represents date and time with a time zone |
| `OffsetDateTime` | Represents date and time with a UTC offset |
| `Instant` | Represents a point on the UTC timeline |
| `Period` | Represents a date-based amount of time |
| `Duration` | Represents a time-based amount of time |

#### a. LocalDate

`LocalDate` represents a date using year, month, and day.

It does not contain time or time-zone information.

**Example:**

```java
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        System.out.println(today);

        LocalDate date =
                LocalDate.of(2026, 11, 27);

        System.out.println(date);
    }
}
```

**Output:**

```text
2026-11-27
2026-11-27
```

**Common LocalDate Methods:**

| Method | Purpose |
|---|---|
| `now()` | Gets the current date |
| `of()` | Creates a date using year, month, and day |
| `getYear()` | Returns the year |
| `getMonth()` | Returns the month |
| `getDayOfMonth()` | Returns the day of the month |
| `plusDays()` | Adds days |
| `minusDays()` | Subtracts days |
| `plusMonths()` | Adds months |
| `isBefore()` | Checks whether a date is before another |
| `isAfter()` | Checks whether a date is after another |
| `isLeapYear()` | Checks whether a year is a leap year |

**Example:**

```java
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate date =
                LocalDate.of(2026, 11, 27);

        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());

        System.out.println(date.plusDays(5));
        System.out.println(date.minusMonths(1));
    }
}
```

**Output:**

```text
2026
NOVEMBER
27
2026-12-02
2026-10-27
```

#### b. LocalTime

`Local
