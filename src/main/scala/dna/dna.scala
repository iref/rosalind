package dna 

import scala.io._

/**
 * Class counts DnaBase occurrences in provided DNA string.
 * Possible DNA bases are provided in constructor.
 */
class DnaBaseCounter(alphabet: List[Char]) {
  /** Normalized version of provided DNA bases */
  private val normalizedAlphabet = alphabet map (_.toLowerCase)

  /**
   * Method counts occurrences of base in dnaString
   * @param base dna base, that occurrences should be counted
   * @param dnaString dna string to be searched for occurrences
   * @return count of dna base in dna string
   */
  def countBaseOccurrences(base: Char, dnaString: String): Int = {
    dnaString count {x => x equals base}
  }

  /**
   * Method counts occurrences of every base in alphabet in given dnaString.
   * @param dnaString dnaString to be search for dna base occurrences
   * @return list of counts of dna base in dna string. Count at index i
   *  is count for base at index i in alphabet
   */
  def countBases(dnaString: String): List[Int] = {
    normalizedAlphabet map {base => 
        countBaseOccurrences(base, dnaString.toLowerCase)}
  }

}

object App {
  /**
   * Use classloader instead... this wont work if App is run inside JAR
   */
  val testFilePath = "src/main/scala/dna/dnaTest.txt"

  def main(args: Array[String]): Unit = {
    val counter = new DnaBaseCounter(List('A', 'C', 'G', 'T'))
    Source.fromFile(testFilePath).getLines.foreach ( line =>
      println(counter.countBases(line) mkString " "))
  } 
  
}
