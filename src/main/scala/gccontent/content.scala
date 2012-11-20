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

  def parse(value: String): GcContent = pattern findFirstIn value match {
      case Some(pattern(id, dnaString)) => new GcContent(id, dnaString)
      case None => throw new IllegalArgumentException("Invalid format")
  }

  def concatContents(values: List[String]): List[String] = {
    
    if (values.isEmpty) {
      Nil
    } else {
      val index = values.indexWhere(x => x startsWith ">", 1)
      if (index == -1) {
        List(values.flatten mkString "")
      } else {
        val (prefix, suffix) = values.splitAt(index)  
        (prefix.flatten mkString "") :: concatContents(suffix)
      }      
    }    
  }

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
    val content = GcContentParser.concatContents(Source.fromFile("src/main/scala/gccontent/test.txt").getLines.toList) 
      .map (line => GcContentParser.parse(line)) max ( new GcContentOrdering)  
    println(content.id)
    println(content.gcContentPercentage)
  }
}
