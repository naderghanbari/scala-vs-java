#!/usr/bin/env scala
import java.{io, util}
def prettyPrint(f: io.File) = s"${f.getName} ${f.length} ${new util.Date(f.lastModified)}"
val dir = new io.File(args.headOption.getOrElse("."))
dir.listFiles().toStream.map(prettyPrint).foreach(println)