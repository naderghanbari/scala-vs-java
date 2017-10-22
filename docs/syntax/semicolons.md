Semicolons
==========

### Java 

[`Semicolons.java`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/java/syntax/semicolons/java/Semicolons.java)

```java
String message = "Error occurred!";
Boolean shouldNotifyUser = config.isNotificationEnabled();
if (shouldNotifyUser) {
    notifyUser(currentUser, message);
}
```

### Scala 

[`Semicolons.scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/src/main/scala/syntax/semicolons/scala/Semicolons.scala)

```scala
val message = "Error occurred!"
val shouldNotifyUser = config.notificationEnabled
if (shouldNotifyUser) notifyUser(currentUser, message)
```

Semicolons are optional (read as **not needed**) in Scala.

Semicolons might be needed in [some special situations](
https://stackoverflow.com/questions/29743009/in-scala-are-semicolons-necessary-in-some-situations), 
though there is always a way to avoid them. Besides, optional semicolons makes the transition of developers used to 
Java or other [C-family of languages](https://en.wikipedia.org/wiki/List_of_C-family_programming_languages) smoother.

#### Hint
Avoid using semicolons. I get nostalgic about them sometimes as well but it's like reminiscing manual transmission 
in the age of self-driving cars. Don't shift gears manually, let the auto transmission do it for you. 

#### Fact
Compilers, like everything else, had many great breakthroughs since the C language appeared. 
A smart modern compiler can infer end of statements in most cases, with a little bit of help in all cases. 