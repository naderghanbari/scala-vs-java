Scripting
=========
    
### Java 

#### Java 9
Java 9 is the first version of Java with a REPL. It's called
[jshell](https://docs.oracle.com/javase/9/tools/jshell.htm#JSWOR-GUID-C337353B-074A-431C-993F-60C226163F00).

Just run it with the `jshell` command.

``` java
    $ jshell

    |  Welcome to JShell -- Version 9
    |  For an introduction type: /help intro

    jshell> String[] fruits = {"apple", "banana", "orange"}
    fruits ==> String[3] { "apple", "banana", "orange" }

    jshell> Arrays.asList(fruits).forEach(System.out::println)
    apple
    banana
    orange
```

#### Java 8 and before
Before Java 9, Java had no REPL. You could/still can use third party or open source REPLS such as
[JavaREPL](http://www.javarepl.com/term.html) which also has a browser-based REPL.


### Scala

Scala has a REPL which you can run narutally with the `scala` command.

```scala
    $ scala

    Welcome to Scala 2.12.3 (Java HotSpot(TM) 64-Bit Server VM, Java 9).
    Type in expressions for evaluation. Or try :help.

    scala> val fruits = Array("apple", "banana", "orange")
    fruits: Array[String] = Array(apple, banana, orange)

    scala> fruits.foreach(println)
    apple
    banana
    orange
```

If you want to paste multiple lines just type `:paste`. Type `ctrl-D` at the end to terminate the paste mode. 

#### Ammonite

[Ammonite](https://github.com/lihaoyi/Ammonite) Shell and REPL are very powerfool tools. Check them out if you need a full fledged shell/REPL.