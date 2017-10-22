Default Parameters
==================

### Java 

Java syntax lacks the concept of default parameters. 

The closet thing is [Using Builder Pattern](https://stackoverflow.com/questions/1988016/named-parameter-idiom-in-java) 
which we will see more about this in [Named Parameters](named.md).


### Scala

#### Function Definition with Default Params
[`Shape.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/defaults/scala/Shape.scala)

```scala
def renderShape(resolution: Int, details: Boolean = false, out: java.io.OutputStream = System.out): Unit
```

#### Usage
[`DefaultParameters.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/defaults/scala/NamedParameters.scala)

```scala
  val shape = Shape(color = Color.black, name = "Circle", size = 42)

  shape.renderShape(2048) // Use defaults for second and third params
  shape.renderShape(resolution = 1024) // Named param + Default Param
  shape.renderShape(resolution = 1024, details = true) // Default param only for third parameter
```

Default parameters work for any function defined, as well as for [Case Classes](#TBD).

#### Hint
Always put parameters with default values at the end at definition-site.