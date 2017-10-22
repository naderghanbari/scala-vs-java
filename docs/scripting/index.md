Scripting
=========
    
### Java 

The Java platform, since Java 6, supports scripting.
[Mozilla Rhino](https://github.com/mozilla/rhino) engine was embedded in JDK 6 and
[Nashorn](https://www.oracle.com/corporate/features/nashorn-javascript-engine-jdk9.html) is the
embedded Javascript engine in recent versions.
You can't, though, write a script in Java language itself. See 
[JSR 292 invokedynamic](https://jcp.org/en/jsr/detail?id=292) and 
[this article](http://www.oracle.com/technetwork/articles/java/scripting-140262.html) for more info.

### Scala

[`ls-scala`](https://github.com/naderghanbari/scala-vs-java/blob/master/scripts/ls-scala.scala)

```scala
import java.{io, util}
def prettyPrint(f: io.File) = s"${f.getName} ${f.length} ${new util.Date(f.lastModified)}"
val dir = new io.File(args.headOption.getOrElse("."))
dir.listFiles().toStream.map(prettyPrint).foreach(println)
```

#### Running Scala Scripts
Run the above script as follows:

```
$ ./ls-scala ..
$ ./ls-scala /home/me/projects
```

You can run Scala scripts either by `Scala script` or by adding `#!/usr/bin/env scala` shebang and  running `./script`.
Note that the file should have execution permission in this case. 

#### Fact
Slow startup time, mostly due to loading classes, makes Scala scripts quite slow.
 
#### Hint 
Use Scala as a script only if it's a heavy time-consuming task running significantly longer than the startup time. 
You can also use Scala scripts for casual scripting or when you feel too functional when scripting!

#### Ammonite
See [Ammonite](http://ammonite.io/#Ammonite-Shell) for a typed Scripting API resembling 
[bash](https://www.gnu.org/software/bash/). 

### Groovy

[Groovy](http://groovy-lang.org/structure.html#_scripts_versus_classes) is an optionally-typed dynamic JVM-based 
language fully compatible with Java. It is a general purpose language with scripting support by design.

[`ls-groovy`](https://github.com/naderghanbari/scala-vs-java/blob/master/scripts/ls-groovy)

```groovy
dir = args ? args[0] : "."
new File(dir).eachFile { println "${it} ${it.size()} ${new Date(it.lastModified())}" }
```
