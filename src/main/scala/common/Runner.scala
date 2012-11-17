package commons

import scala.io._

class Runner {
  def run[T] (path: String)(f: String => T): Unit = {
    Source.fromFile(path).getLines.foreach ( line => 
      println(f(line)))
  }
}
