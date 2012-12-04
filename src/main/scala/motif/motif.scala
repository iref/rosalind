
package motif

import scala.io._

object Motif {
	def indeces(dnaString: String, motif: String) = for {
		i <- dnaString.indices
		if dnaString.startsWith(motif, i)
	} yield (i + 1)
}

object Application {
	def main(args: Array[String]): Unit = {
		val iter = Source.fromFile("src/main/scala/motif/test.txt").getLines
		println(Motif.indeces(iter.next, iter.next) mkString " ")
	}
}

