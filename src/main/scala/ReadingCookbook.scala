import scala.io.Source

object ReadingCookbook extends App {
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
    val recipeTitles = inLines.filter(line => line.toUpperCase == line && line.nonEmpty)
    recipeTitles
  }

  val recipeTitles = getTitles(poemLines, 1310, 3446)
  //recipeTitles.foreach(println)

  //start 1311 end 3446
  val linestoAnalyze = poemLines.slice(1310,3446)

  val ingredients = linestoAnalyze.filter(line => line.length > 1 && line.startsWith("  ") && !line.trim.startsWith("_"))


  //figure how to split each other titles ingredients into one pharagraph

  ingredients.foreach(println)
   // if after the title there is an empty line check for ingredients and when there is another empty line finish the program
  val count = 1
  val countMore = 2
  for (text <- linestoAnalyze) {
    if (text.contains(recipeTitles)) {
      recipeTitles.foreach(println)
    }
      if (text.zipWithIndex.length == count || text.zipWithIndex.length == countMore) {
        if (text.contains(ingredients)) println(ingredients.mkString("\n"))
      else println("No Ingredients")
      }
    else text.split("\n\r")
    }


//saving the new file
  //val relative_save_path = "src/resources/CookBook_filtered.txt"

  //import java.io.{PrintWriter,File}
  //val pw = new PrintWriter(new File(relative_save_path ))
  //pw.write(and_text)
  //pw.close() //when writing it is especially important to close as early as possible

}
