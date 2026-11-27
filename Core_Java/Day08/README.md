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

#### Important Characteristics of String

- String objects are immutable.
- String literals can be stored in the String Constant Pool.
- Strings can be created using literals or the `new` keyword.
- The `String` class provides methods for searching, comparing, extracting, and modifying text by creating new String objects.

#### Common String Methods

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

#### Common StringBuilder Methods

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

#### Characteristics of StringBuilder

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

#### Characteristics of StringBuffer

- Mutable sequence of characters.
- Provides synchronized methods.
- Thread-safe for its synchronized individual operations.
- Suitable when a mutable string is shared across multiple threads.
- Can have synchronization overhead compared with StringBuilder.

#### String vs StringBuilder vs StringBuffer

| Feature | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Mutability | Immutable | Mutable | Mutable |
| Thread safety | Safe due to immutability | Not synchronized | Synchronized methods |
| Modification | Creates new String objects | Modifies existing object | Modifies existing object |
| Performance for repeated modifications | Usually less efficient | Generally faster | Synchronization overhead |
| Typical usage | Fixed or rarely modified text | Single-threaded modifications | Shared mutable text |

Practiced using all three classes and understanding the differences in mutability, synchronization, and performance.

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

The `equals()` method is used to compare object contents when the class provides a suitable implementation.

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

**Important Point:**

The default implementation of `Object.equals()` checks object identity. Classes such as `String` override it to provide content-based comparison.

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

#### String Literal vs Non-Literal

| String Literal | Non-Literal |
|---|---|
| Created using double quotes | Explicitly created using `new String()` |
| Uses String Constant Pool | Creates a separate String object |
| Identical literals can share a pooled object | Each `new String()` creates a distinct object |
| Example: `"Java"` | Example: `new String("Java")` |

#### intern() Method

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

Practiced creating literal and non-literal String objects, comparing their references, and understanding the purpose of `intern()`.

---

### 4. Date and Time Handling in Java

Java provides APIs for working with dates, times, timestamps, and time zones.

The modern Date and Time API is available in the `java.time` package and was introduced in Java 8.

#### Important Classes in java.time

| Class | Purpose |
|---|---|
| `LocalDate` | Represents a date without time or time zone |
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

        LocalDate date = LocalDate.of(2026, 11, 27);

        System.out.println(date);
    }
}
```

**Output:**

```text
2026-11-27
2026-11-27
```

#### Common LocalDate Methods

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

        LocalDate date = LocalDate.of(2026, 11, 27);

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

`LocalTime` represents time without a date or time zone.

**Example:**

```java
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalTime time = LocalTime.now();

        System.out.println(time);

        LocalTime customTime = LocalTime.of(10, 30, 45);

        System.out.println(customTime);
    }
}
```

#### c. LocalDateTime

`LocalDateTime` combines a date and time without storing time-zone information.

**Example:**

```java
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        LocalDateTime current = LocalDateTime.now();

        System.out.println(current);

        LocalDateTime custom =
                LocalDateTime.of(2026, 11, 27, 10, 30);

        System.out.println(custom);
    }
}
```

#### d. ZonedDateTime

`ZonedDateTime` represents a date and time along with a time zone.

**Example:**

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {

        ZonedDateTime dateTime =
                ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        System.out.println(dateTime);
    }
}
```

Practiced obtaining current dates and times, creating custom date-time values, and using date-time classes for different requirements.

---

### 5. Parsing and Formatting of Date

Date parsing and formatting are important operations when working with date and time values.

#### a. Parsing

**Parsing** means converting a String representation of a date or time into a date-time object.

Java uses the `parse()` method for this purpose.

**Example Using LocalDate:**

```java
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        String dateString = "2026-11-27";

        LocalDate date = LocalDate.parse(dateString);

        System.out.println(date);
    }
}
```

**Output:**

```text
2026-11-27
```

#### Parsing Using a Custom Format

When the date String uses a format other than the default ISO format, use `DateTimeFormatter`.

**Example:**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        String dateString = "27-11-2026";

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date =
                LocalDate.parse(dateString, formatter);

        System.out.println(date);
    }
}
```

**Output:**

```text
2026-11-27
```

#### b. Formatting

**Formatting** means converting a date-time object into a String representation in a required pattern.

Java provides the `format()` method and `DateTimeFormatter`.

**Example:**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2026, 11, 27);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = date.format(formatter);

        System.out.println(formattedDate);
    }
}
```

**Output:**

```text
27/11/2026
```

#### Common Date Formatting Patterns

| Pattern | Meaning | Example |
|---|---|---|
| `dd` | Day of month | `27` |
| `MM` | Month number | `11` |
| `MMM` | Short month name | `Nov` |
| `MMMM` | Full month name | `November` |
| `yyyy` | Year | `2026` |
| `HH` | Hour in 24-hour format | `14` |
| `hh` | Hour in 12-hour format | `02` |
| `mm` | Minutes | `30` |
| `ss` | Seconds | `45` |
| `a` | AM/PM marker | `PM` |

**Important:** Use uppercase `MM` for month and lowercase `mm` for minutes.

#### Parsing vs Formatting

| Parsing | Formatting |
|---|---|
| String to date-time object | Date-time object to String |
| Uses `parse()` | Uses `format()` |
| Example: `LocalDate.parse()` | Example: `date.format()` |

Practiced converting date Strings into `LocalDate` objects and formatting date objects into different String representations.

---

### 6. Why Do We Use LocalDate Instead of SimpleDateFormat?

Java provides two generations of date and time APIs:

1. Legacy API – `Date`, `Calendar`, and `SimpleDateFormat`.
2. Modern API – `java.time` classes such as `LocalDate`, `LocalTime`, and `LocalDateTime`.

The modern API was introduced in Java 8 to provide a more reliable and easier approach to date and time handling.

#### a. SimpleDateFormat

`SimpleDateFormat` belongs to the legacy `java.text` package.

It is used to parse and format date values.

**Example:**

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date date = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy");

        System.out.println(sdf.format(date));
    }
}
```

#### b. LocalDate and DateTimeFormatter

The modern API uses `LocalDate` with `DateTimeFormatter`.

**Example:**

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(date.format(formatter));
    }
}
```

#### Why Prefer LocalDate?

**1. Immutability**

- `LocalDate` objects are immutable.
- Date operations return new objects instead of modifying the original.
- This makes date handling easier to reason about.

**2. Thread Safety**

- `LocalDate` and `DateTimeFormatter` are immutable and thread-safe.
- `SimpleDateFormat` is mutable and not thread-safe when shared between threads without external synchronization.

**3. Clear API Design**

- `LocalDate` represents only a date.
- `LocalTime` represents only a time.
- `LocalDateTime` represents date and time.
- `ZonedDateTime` includes time-zone information.

This avoids mixing unrelated date and time information.

**4. Easy Date Calculations**

Modern date classes provide convenient methods such as:

- `plusDays()`
- `minusDays()`
- `plusMonths()`
- `isBefore()`
- `isAfter()`

**5. Better Formatting and Parsing**

`DateTimeFormatter` provides a modern API for parsing and formatting date-time values.

#### Comparison: SimpleDateFormat vs LocalDate

| Feature | SimpleDateFormat | LocalDate |
|---|---|---|
| Package | `java.text` | `java.time` |
| Introduced | Legacy Java API | Java 8 |
| Mutability | Mutable | Immutable |
| Thread safety | Not thread-safe when shared | Thread-safe |
| Represents | Formats/parses legacy Date values | Date without time or zone |
| Formatting | `format()` | Used with `DateTimeFormatter` |
| Parsing | `parse()` | `LocalDate.parse()` |

**Important Clarification:**

`LocalDate` and `SimpleDateFormat` are not direct replacements for each other.

- `LocalDate` represents a date.
- `SimpleDateFormat` is a formatting and parsing class.
- The modern replacement for `SimpleDateFormat` is `DateTimeFormatter`.
- For modern Java applications, prefer the `java.time` API.

Practiced using both legacy and modern date APIs and understood why Java 8 date-time classes are generally preferred for new applications.

---

## Learning Outcomes

- Understood String handling in Java.
- Learned the differences between String, StringBuilder, and StringBuffer.
- Practiced common String methods and String modification operations.
- Understood reference equality using `==` and content equality using `equals()`.
- Learned the difference between String literals and objects created using `new`.
- Understood the String Constant Pool and the purpose of `intern()`.
- Learned date and time handling using the `java.time` package.
- Practiced using LocalDate, LocalTime, LocalDateTime, and ZonedDateTime.
- Understood date parsing and formatting using DateTimeFormatter.
- Learned the differences between legacy date handling and the modern Java Date and Time API.
- Understood why LocalDate and DateTimeFormatter are preferred in modern Java applications.

## Repository Contents

- String handling programs.
- StringBuilder and StringBuffer examples.
- String comparison using `==` and `equals()`.
- String literal and non-literal examples.
- String Constant Pool and `intern()` examples.
- LocalDate, LocalTime, and LocalDateTime programs.
- Date parsing and formatting examples.
- SimpleDateFormat and DateTimeFormatter comparison examples.
- Class notes and supporting learning materials.
