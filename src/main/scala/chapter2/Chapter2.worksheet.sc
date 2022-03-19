import zio._
import scala.io.StdIn

import zio.Console
for {
  _ <- Console.printLine("Hello! What is your name?")
  n <- Console.readLine
  _ <- Console.printLine("Hello, " + n + ", good to meet you!")
} yield ()

// val readLine                = ZIO.attempt(StdIn.readLine())
// def printLine(line: String) = ZIO.attempt(println(s"hi $line"))

// val x = readLine.flatMap(printLine(_))
