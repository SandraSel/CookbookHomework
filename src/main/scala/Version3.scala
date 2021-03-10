import scala.io.Source

object Version3 extends App {
  val relative_path = "src/resources/CookBook"

  def getLinesFromFile(srcPath: String) = {
    val bufferedSource = Source.fromFile(srcPath)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val poemLines = getLinesFromFile(relative_path)
  //poemLines.foreach(println)  later can maybe delete

  def getTitles(lines: Array[String], startLine: Int, endLine: Int): Array[String] = {
    val inLines = lines.slice(startLine, endLine)
    val recipeTitlesIngredients = inLines.filter(line => line.toUpperCase == line && line.nonEmpty || line.startsWith("  ") || line.trim.startsWith("_"))
    recipeTitlesIngredients
  }

  val recipeTitlesIngredients = getTitles(poemLines, 1310, 3446).mkString(sep = "\n\r")
  recipeTitlesIngredients.foreach(println)

    //saving the new file
  val relative_save_path = "src/resources/CookBook_filtered.txt"

  import java.io.{PrintWriter,File}
  val pw = new PrintWriter(new File(relative_save_path ))
  pw.write(recipeTitlesIngredients)
  pw.close() //when writing it is especially important to close as early as possible

}

