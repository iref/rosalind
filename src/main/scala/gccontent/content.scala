package content

import scala.io.Source
import scala.util.matching.Regex

case class GcContent(id: String, dnaString: String) {

  def filterGcContent: String = dnaString filter { base => base.equals('G') || base.equals('C')}

  def countGcContent: Int = filterGcContent.length

  val gcContentPercentage: Double = (countGcContent.toDouble / dnaString.length) * 100

}


object GcContentParser {

  private val pattern = new Regex(">(.+?_\\d\\d\\d\\d)(.+)", "id", "dnaString")

  def parse(value: String): List[GcContent] = (for {
      matched <- (pattern findAllIn value).matchData           
  } yield new GcContent(matched.group("id"), matched.group("dnaString"))).toList

  def concatContents(values: List[String]): String = values mkString ""

}


class GcContentOrdering extends Ordering[GcContent] {
    
  override def compare(left: GcContent, right: GcContent): Int = {
    if (left.gcContentPercentage < right.gcContentPercentage) {
      -1
    } else if (left.gcContentPercentage > right.gcContentPercentage) {
      1
    } else {
      0
    }    
  }

}  


object App {
  def main(args: Array[String]): Unit = {
    val content = GcContentParser parse GcContentParser.concatContents (
      Source.fromFile("src/main/scala/gccontent/test.txt").getLines.toList 
    ) max  new GcContentOrdering  
    
    println(content.id)
    println(content.gcContentPercentage)
  }
}
