package chapter2
import zio._
import scala.io.StdIn
import zio._
import zio.Console

object GroceryStore extends App {

  /**
   * how to run
   * sbt
   * runMain chapter2.GroceryStore
   */
  def printLine(line: String) = ZIO.attempt(println(s"hi $line"))

  override def run(args: List[String]): URIO[ZEnv, ExitCode] = {
    // val goShopping      = ZIO.attempt(println("Going to grocery store"))
    // val goShoppingLater = goShopping.delay(1.hour)
    // goShopping.exitCode
    // goShoppingLater.exitCode

    // val readLine                = ZIO.attempt(StdIn.readLine())
    // def printLine(line: String) = ZIO.attempt(println(s"hi $line"))
    // val x = readLine.flatMap(printLine(_))
    // x.exitCode

    // val readFirstName = ZIO.attempt(StdIn.readLine("First Name: "))
    // val readLastName  = ZIO.attempt(StdIn.readLine("Laste Name: "))
    // val fullName      = readFirstName.zipWith(readLastName)((f, l) => s"$f $l").flatMap(printLine)
    // fullName.exitCode

    // val helloWorld = ZIO.attempt(print("Hello, ")) *> ZIO.attempt(print("World!\n"))
    // helloWorld.exitCode

    // val printNumber = ZIO.foreach(1 to 100)(x => printLine(x.toString))
    // printNumber.exitCode

    val prints = List(
        printLine("The"),
        printLine("quick"),
        printLine("brown"),
    )

    val printWords = ZIO.collectAll(prints)
    printWords.exitCode
  }

}
