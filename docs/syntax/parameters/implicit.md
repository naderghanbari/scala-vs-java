Implicit Parameters
===================

### Concept
Implicit parameters act as a context. For instance imagine you have
a code working for different devices and you have to take the device
resolution into account. Object orientation and polymorphism helps but
often times you will end up passing the same parameter over and over
to a lot of methods and functions.

Implicit params let you pass those parameters implicitly without the
need to explicitly pass them.

You might think the same thing is achievable by different design
patterns but in fact only implicit params can give you the power of
implicit params! We will see more advanced scenarios later but for
now just imagine you are writing a library and you don't really know
how it's gonna be used/extended/enriched. In this situations implicit
params will make the code much more concise and readable. Think of
them as a cascading context.

### Java 

Java lacks this powerful asset. Most times ThreadLocal is used as an
alternative but it's not really equivalent first of all because it's
tied to the Thread and hence it is a runtime entity, as opposed to
implicit params which are compile-time beasts.

Security frameworks, such as Spring Security are good examples. The
authenticated principal (user details) are normally put in ThreadLocal
so that other layers can use them. We will see how to do this with
implicit parameters in Scala shortly.

### Scala

[`ImplicitParameters.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/parameters/named/scala/ImplicitParameters.scala)

```scala
 trait Service {
   def userHasAccessTo(department: String)(implicit currentUser: User): Boolean
 }

 trait Controller {
   def service: Service

   def allPurchases(department: String)(implicit currentUser: User, timeZone: TimeZone) = {
     if (service.userHasAccessTo(department)) service.findPurchasesByDepartment(department)
     else throw new IllegalAccessException("Access to feature forbidden!")
   }
 }
 ```

In the example above, the current logged-in user is passed implicitly
to all functions that need a reference to it. Resulting code is
often much cleaner and more concise compared to passing parameters
explicitly. We will see a lot more about implicits later but for now
just think of them as normal parameters which are passed implicitly.
Instead of mechanically copy paste them all over the place, you mark
them as implicit and the compiler will do that for you.

#### Hint
All parameters grouped in a single bracket pair will be implicit
if there is a leading `implicit` keyword. For instance in the above
example both `currentUser` and `timeZone` are implicit parameters.
There can be only one such group of implicit parameters and it should
always be the last group of arguments.

#### Fact
A very important advantage of implicits is that compile will prove the
correctness for us, unlike annotations or ThreadLocal approaches which
will be resolved in runtime (or startup time in best case).

#### Fact
Scala compiler uses a simple strategy to resolve the implicit parameters.
We will see that in details later but for now just keep in mind that
there should be one and only one implicit of the expected type when
one is needed. Otherwise due to ambiguity compiler can't decide which one
to use.

#### Hint
Never make general or widely used types implicit parameters. For instance
it's a bad idea to have an `(implicit count: Int)` because `Int` type is
too general for that. Normally you would define your own specific types or
case classes for this purposes.

#### Explicitly
Note that you can always opt to pass things explicitly even if the parameter
is defined to be implicit. In other words compiler will help you
by wiring implicits only if you don't do the wiring (passing parameters
explicitly) yourself. Sometimes you have to pass things explicitly
to get rid of ambiguity. Maybe you have more than one implicit of the
expected type in scope. Sometimes you would do that for readability and
sometimes for testing purposes, for instance in unit tests.

#### More examples
If you are interested in knowing more about implicit parameters right now,
take a look at the definition of
[Array#sorted](http://www.scala-lang.org/api/2.12.3/scala/Array.html#sorted[B>:A](implicitord:scala.math.Ordering[B]):Repr)
method. You will see that the ordering (logic or algorithm to compare two
objects of the same type) is being passed implicitly. So you can
do the following

```scala
// a default implicit ordering is always in scope for [Int] type
Array(1, 3, 4).sorted

// or pass an ordering parameter explicitly
Array(1, 3, 4).sorted(Ordering[Int].reverse)
```

In most cases we want to just sort things in ascending order so being
able to write concise and clean code is a plus, that's why the ordering
is an implicit param in the standard library. But sometimes you want
custom or reverse ordering, and that's when you want to pass things
explicitly.
