Tuples
======

In mathematics a tuple is a finite ordered sequence of elements.
An `n-tuple` is an ordered sequence of n elements where n can be
any non-negative number.
In programming tuples are ordered fixed-size heterogeneous collection
of elements. Being fixed-size mixed-type makes them a natural choice
over variable-size fixed-type collections such as arrays or linked lists in
some situation.
There are differences though between the interpretation and implementation
of tuples in languages supporting them.

### Java 

Java does not have tuples. We hear myths like "tuples are not needed" or
"they make the code unreadable" frequently. One thing is for sure, if you
get used to them you will not be able to code in a tuple-less environment
ever again! You will end up writing your own version of tuples and in fact
that's what most people do in Java. Take a look at
[javatuples library](https://github.com/javatuples/javatuples) for instance.

### Scala 

[`Tuples.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/tuples/scala/Tuples.scala)

```scala
def connect(): (String, Int) = ("https://localhost", 8080)
val serverAndPort: (String, Int) =  connect()

serverAndPort.swap // (8080, "https://localhost")

serverAndPort._1 // first element
serverAndPort._2 // second element

// Define type aliases if you use the tuple type frequently
// This will further reduce the noise and make the code more readable
type Quad = (String, Int, String, Int)
val quadruple = ("A", 1, "B", 2)

// Deconstruction, discard not needed elements binding them to _
val (a, _, b, _) = quadruple

val entry = "A" -> 1
val myMap = Map("A" -> 1, "B" -> 2)
```

The above code speaks for itself. We will see more about this in
the semantics section when we discuss the [`Product`](http://www.scala-lang.org/api/2.12.4/scala/Product.html)
type which all tuples inherit from. For now let's just see the basic facts
about tuples

#### Tuple type
Tuple types can be expressed in two ways. `(String, Int, Char)` or
`Tuple3[String, Int, Char]`. In most cases the former is easier to
read.

#### Tuple values
You can create tuple values similar to how you define the types:
`("A", 1)` or `Tuple2("A", 1)`. Note that the only way to create a
`Tuple1` is `Tuple1("A")`. If you are familiar with Python perhaps
you are thinking `("A",)` is a neater way. Unfortunately in a highly
static language as Scala syntax can not be as flexible as Python, especially
when it comes to round brackets and commas which are all over the place in
the grammar.

#### Limits
Scala is a statically typed language compiling to Java bytecode. Under
these two huge constraints, turn out that functions can have maximum of
22 parameters. This constraint applies transitively to Tuples. If you ever
need more than that check the [HList](https://github.com/milessabin/shapeless/blob/master/core/src/main/scala/shapeless/hlists.scala)
type.

#### Type alias
If you use certain tuple types over and over again, define a type alias
for them. This will reduce the noise and make the code more readable.
See the `Quad` type in the code above as an example.

#### Deconstruction
Deconstruction, pattern matching, and unapplication need a full separate
section. For now just remember that often times the clearest way to
look inside a tuple is by deconstructing it.
In the example above

```scala
val (a, one, b, _) = quadruple
```

does this job.
`_` here means we are not interested in the 4th element. This is much
clearer than writing

```scala
val a = quadruple._1
val b = quadruple._3
````

and so on.

#### → the arrow function
You can construct a `Tuple2` using the arrow function, e.g.
`"A" -> 2` or `"A" → 2`. This is useful in a lot of situations, because it's
more concise and looks nicer visually. For instance when constructing a `Map`
as in the example above.

#### Advanced
Note that `->` or `→` works only for `Tuple2`. The way it works is not totally
magical! It is not a feature of the language, rather a function
defined in teh standard library. You can define such functions yourself and
we will see more details about this when discussing `implicit classes` and
`implicit conversion`.
