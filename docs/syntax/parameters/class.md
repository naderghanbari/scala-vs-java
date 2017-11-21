Class Parameters
================

### Java 

In Java you have to write constructors to pass parameters to a class.
If you need some of those parameters only at construction time, you have
to make a separate case for them. Often times you will have private instance
members and you instantiate them from constructor params.

I trust you on this one. No need for an example because there will be a
lot of noise just to pass three parameters to a class.

### Scala

[`Shape.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/clazz/scala/Shape.scala)

```scala
class Shape(val size: Int, color: Color, name: String) {
  val fullName = color + " " + name + " " + size

  def compare(that: Shape) = this.size > that.size
}

val small = new Shape(size = 42, Color.BLACK, "Circle")
val big = new Shape(size = 100, Color.BLACK, "Circle")
```

Scala syntax makes life much easier. Class parameters come after the class name
in round brackets. Most of the rules applying to normal functions
apply here. For instance you can group class parameters, or you can have
default values, or pass some of them implicitly.

Rule of thumb is that class body is the constructor, i.e. whatever comes
after the opening curly brace is the constructor.
Compiler will generate proper constructors based on what you do with class parameters
in the class body or based on their usage in defined methods.
Parameters without a `val` or `var` prefix won't be publicly accessible from outside.
In fact compiler is smart enough to even not bother storing them as private instance fields if their
presence is needed only at time of the construction.

When number of parameters grow from one or two to around 5 or 6, things
become exponentially more complicated and verbose in Java: lots of
overloaded constructors just to work around tiny differences between different cases.
Yup, yup, there is the builder pattern but Scala's flexible syntax (named
params, grouping, default value, implicit params) will free you from all that
hassle. It almost feels like the most dynamic languages, except that
you don't even lose type safety. Compilers, just like any other technology,
are much better now compared to 30 years ago.

Later we will see Case Classes, little immutable objects which will make
programming much easier and less prone to reckless errors.