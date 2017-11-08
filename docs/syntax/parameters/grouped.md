Grouped Parameters
==================

### Java 

In Java, there is no way to group parameters of a method. We will
see later that grouping parameters will enable us to do `currying` and
later on we will see how difficult and severely verbose the Java code can become in
an attempt to support currying. Lacking parameter grouping is the main
contributor to this problem.

Passing multiple varargs is also impossible in Java but with the help of
parameter grouping we can easily define a function supporting multiple varargs.

### Scala

[`GroupedParameters.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/grouped/scala/GroupedParameters.scala)

```scala
def divisibleBy(n: Int)(x: Int) = (x % n) == 0

divisibleBy(5)(10)

val divisibleByFive = divisibleBy(5)

divisibleByFive(10)

def multiSum(as: Int*)(bs: Int*)(cs: Int*) = as.sum * bs.sum * cs.sum

multiSum(1, 2, 3)(4, 5, 6, 7, 9)(10, 11)
```

As you see in the example above you can group function parameters into
several groups. Each group can have multiple parameters all defined in
the same enclosing round brackets.

There are several reasons to group parameters. We briefly mention some of
them here:

1. [Implicit Parameters](implicits.md) need to be grouped. We see them shortly
in the next section.
1. `Currying`
   - A powerful technique that we will see shortly. If you want
   to know a bit more about it right now just look at the example above. The
   `divisibleBy(5)` is an example of currying. As you see we're passing only
   the first group of arguments and we leave the second group `(x:Int )`.
1. Type inference
   - Sometimes in order to improve type inference we have to group parameters.
   Don't worry if this does not make total sense, we will discuss it in details later.
   For now just keep in mind that in some scenarios, in order to help compiler
   infer types we can group parameters. Compiler will infer types per group in the
   same order that they are defined.
1. Multiple Varargs
   - In the example above `multiSum` is an example of defining multiple varargs
   params. This is not possible in Java.
