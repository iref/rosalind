package basepair

import commons._

class DnaPairing {
  def findPair(dnaString: String): String = dnaString.reverseMap {
    x => x match {
      case 'A' => 'T'
      case 'T' => 'A'
      case 'G' => 'C'
      case 'C' => 'G'
    }
  }
}

object App {
  def main(args: Array[String]): Unit = {
    val dnaPairing = new DnaPairing
    val runner = new Runner
    runner.run("src/main/scala/basepair/rosalind_pair.txt")(dnaPairing.findPair)
  }
}
