package rna;

import scala.io._

class RnaTranslator {

  def translate(dnaString: String): String = dnaString.replaceAll("T", "U")

}

object App {

  val rnaFile = "src/main/scala/rna/rosalind_rna.txt"

  def main(args: Array[String]): Unit = {
    val rnaTranslator = new RnaTranslator
    Source.fromFile(rnaFile).getLines.foreach ( line =>
      println(rnaTranslator.translate(line))
    )
  }
}


