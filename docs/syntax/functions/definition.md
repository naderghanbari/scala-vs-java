Function Definition
===================


### Scala

[`Definitions.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/functions/scala/Definitions.scala)

```scala
def function(param1: Int, param2: String): String = {
  if (param1 > 0) param2
  else param2.reverse
}

def abs(x: Int) = if (x < 0) -x else x

def random = math.random()
```

#### `def` keyword
Functions are defined with the `def` keyword in Scala.

#### Parameters
After the `def` keyword come the parameters, which are optional.
The `random` function in the above example has no parameters, but because it's defined
with the `def` keyword it will be treated as a function, i.e. it will be computed or
evaluated every time it's called.
We will see more about this when we talk about
[The Uniform Access Principle](http://joelabrahamsson.com/learning-scala-part-nine-uniform-access/).

#### Return type
Return type comes after a semicolon at the end. Return type is optional
because Scala compiler is able to infer the return type automatically based on the
function body. We will discuss type inference in details later.
In this example, return type is left to be inferred by compiler
for `random` and `abs` functions.

#### Hint
It is recommended to explicitly define the return type for *public* methods for
better readability.

#### Body
Function body comes after the `=` which should be read as `is defined as`.
It's exactly as one would read it in mathematics `f(x) = x^2`.
Just as in mathematics there is no need for a `return` statements here. The last
statement of each code block determines the return value of that block.
If the body is just one statement there is no need for curly braces. Basically
the body of each function is always one statement, but there are two types of statements: single
and compound. A compound statement is a block of code between curly braces whose value
is determined by its last statement. This recursive definition is just like many
other languages but for brevity Scala lets you define single statements without
curly braces.

#### Values and Variables
While we are at it let's see how we can define values and variables

```scala
val i = 10

// i = 20 wont' compile due to 'reassignment to val'

var str = "Lorem"
str = "Now I point to something else"
```

`val` keyword is for defining final references. You can call them immutable
references or pointer but don't confuse them with immutable types or
data structures. `val` is similar to `final` in Java or `const` in JavaScript.

In the example above, `str` is a non-final reference so we can change it
but the object it points to is a `String` which is immutable.
We will see more about this important aspect of functional programming
later when discussing semantics.