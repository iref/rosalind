package dna 

class DnaBaseCounter(alphabet: List[Char]) {
  val normalizedAlphabet = alphabet map (_.toLowerCase)

  def countBaseOccurrences(base: Char, dnaString: String): Int = {
    dnaString count {x => x equals base}
  }

  def countBases(dnaString: String): List[Int] = {
    normalizedAlphabet map {base => 
        countBaseOccurrences(base, dnaString.toLowerCase)}
  }

}

object App {

  val testDna = "GAGAAGCAATCGCCCAGAAGGTAATACCCACGACTGACAATTATCCGCGCTGGGCAGATGAGACTGTTAGAGTGATAGTAGCCGTACAGGGGCGTCACCCCCACCCTGTTCTCACAGCTGGGGCCCAAGCCCCTCGCACTCTTCGCCGTTTTGGAATCAAAACTCTCACGGGTCCTCATAGACCGGTGAGGGCCGCCGGTCCAAGTGAGCGCGGGACTAATGTAAGCTTCTCGTGTTCATTTAGTTGTTTTTTACAGGAACATATGCATCGAAGCCCTTGATCTATGACAGCTTCAGGTCACTAAGTCTTAAAGCTCGATCAGCGAAATAGAGTAAGGTTGTTTAAAATACATTCGAGCGGCCAGAATGCAACACTCTGCTAGACTTCTGTGATCACGGCGTAACCAGGTTCGTTGTGCAGGTTACCCTATCGGGGAACCCTTCGATAGACGAGGCGAGCTCCGCAGAACCTACACAGTGCACATCACAAGACGCCAGGGCCCCAACCAGGGCGCAATAAGCAATTCACGAGCGGGTCCAGGCGATAAAGGTCAGAAGTACGACTGTGAGTAGCAATGGGTGGATGGAGCTCGGCCTTGTTTAAAGCCCTAGCACTCCACCCACATAATCGCCTCGCTAAAGCTACGCTATTTAAATAAGGTACACTACGTTCCAACTGCGCAGCGGCGAAGTTAACATCGGCCGTCCGTACGTGATTTATTGCTAATAGACATATGTACGGGCACGGTCCTGTGGAATCGTGAAGGGCAGCTGTCTTTCAACGTCCAGAAGGCAGCTCGTACATTGATTAAGGTGGCTGTGGTGTCATTCACCCTGTCATAAGACGGTTGAATACTAACGTCACTGCCTCCCTCAGTCATGGCGAGCTTAGCGCTCATGTTGACTGGACTTCACACTGCTCAATTGCCAGCGGGGG"

  def main(args: Array[String]): Unit = {
    val counter = new DnaBaseCounter(List('A', 'C', 'G', 'T'))
    println(counter.countBases(testDna) mkString " ")
  }
}