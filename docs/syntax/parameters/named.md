Named Parameters
================

### Java 

Java syntax lacks the concept of named parameters. 

The closet thing is [Using Builder Pattern](https://stackoverflow.com/questions/1988016/named-parameter-idiom-in-java) 
but it only applies to one use case and needs a lot of manual effort. Actually one reason you will end up having a 
builder for your class in Java is the syntax limitations such as lack of named and default parameters.

#### Builder Definition
[`Shape.java`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/java/syntax/parameters/named/java/Shape.java)

```java
import java.awt.Color;

public class Shape {

    private final int size;
    private final Color color;
    private final String name;

    private Shape(Builder builder) {
        size = builder.size;
        color = builder.color;
        name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int size;
        private Color color;
        private String name;

        public Shape build() {
            return new Shape(this);
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    }
}

```

#### Usage
[`NamedParameters.java` ](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/java/syntax/parameters/named/java/NamedParameters.java)

```java
Shape shape = Shape.builder()
        .setColor(Color.black)
        .setName("Circle")
        .setSize(42)
        .build();
```

### Scala

#### Case Class Definition
[`Shape.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/named/scala/Shape.scala)

```scala
case class Shape(color: java.awt.Color, name: String, size: Int)
```

#### Usage
[`NamedParameters.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/named/scala/NamedParameters.scala)

```scala
val shape = Shape(color = Color.black, name = "Circle", size = 42)
```

Named parameters work for any function defined, not only for [Case Classes](#TBD) or builders. There is no workaround
for this in Java world. See [Default Parameters](default.md) for a sample with a normal function having default 
parameters and being called with named parameters.

#### Fact
Constructor overloading and builder pattern are more complex than named and default parameters. First of all number of
overloaded constructors grow non-linearly with the number of parameters. Secondly covering all possible combinations
is overwhelmingly complicated. Thirdly it's not really future-proof, you add a new param to your class and boom! You 
have to patch hundreds of lines of code. 

#### Hint
Use the combination of Named Parameters and [Default Parameters](default.md) instead of overloading constructors.
We will see more about this when covering [Case Classes](#TBD) later.

#### Hint
At the call-site, order of named parameters matters. See 
[Scala Tour](https://docs.scala-lang.org/tour/named-arguments.html) for more info.

#### Remark
Calling Java methods with named arguments is not possible, due to lack of names for parameters in the Java bytecode.
See [this](http://www.scala-lang.org/old/node/2503) for more info.