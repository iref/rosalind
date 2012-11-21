package rna;

import commons.Runner 

class RnaTranslator {

  def translate(dnaString: String): String = dnaString.replaceAll("T", "U")

}

object App {

  val rnaFile = "src/main/scala/rna/rosalind_rna.txt"

  def main(args: Array[String]): Unit = {
    val rnaTranslator = new RnaTranslator
    val runner = new Runner
    runner.run(rnaFile) (rnaTranslator.translate)    
  }
}


