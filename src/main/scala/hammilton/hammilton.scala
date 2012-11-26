package hammilton

import scala.io._

class HammiltonDistance {
	def count(first: String, second: String): Int = 
		((zipDnaStrings(first, second) foldLeft (0)) 
			((acc, line) => if (line._1 != line._2) acc + 1 else acc))

	def zipDnaStrings(first: String, second: String): Seq[(Char, Char)] = 
		(first zip second)

	def filterEqualedPositions(dna: Seq[(Char, Char)]): Seq[(Char, Char)] = 
		dna filter { x => x._1 != x._2}
}

object App {
	def main(args: Array[String]): Unit = {
		val iter = Source.fromFile("src/main/scala/hammilton/test.txt").getLines
		val h = new HammiltonDistance
		println(h.count(iter.next, iter.next))
	}	
}