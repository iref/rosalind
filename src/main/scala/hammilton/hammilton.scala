package hammilton

import commons.Runner
import scala.io._

class HammiltonDistance {
	def count(first: String, second: String): Int = (first zip second).foldLeft(0)((acc, b) =>
		if (b._1 != b._2) {
			acc + 1
		} else {
			acc
		}
	)
}

object App {
	def main(args: Array[String]): Unit = {
		val iter = Source.fromFile("src/main/scala/hammilton/test.txt").getLines
		val h = new HammiltonDistance
		h.count(iter.next, iter.next)
	}	
}