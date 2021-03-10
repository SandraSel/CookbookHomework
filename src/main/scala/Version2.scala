import ReadingCookbook.{ingredients, linestoAnalyze, recipeTitles}

import scala.io.Source

object Version2 extends App {

  val relative_path = "src/resources/CookBook"

  //FIXME could move to another class to clean the code
  def getLinesFromFile(srcPath: String) = {
    val bufferedSource = Source.fromFile(srcPath)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

  val poemLines = {
    getLinesFromFile(relative_path).slice(1331, 3446)
  }

  //poemLines.foreach(println)

  //val titleIngredients = Map(recipeTitles -> ingredients)
  //titleIngredients.foreach(println("\n")) //not working

  //FIXME how to join two array[string] into one related list?

  //for ((k, v) <- titleIngredients) yield (println(k.mkString + "\n" + v.mkString) //FIXME neprintē kā vajag, jāpaskatās pie maps kāpēc

  //def getTitlesIngredients(lines: Array[String]) {
  //val ingredientCount = 1
  //for (line <- lines) {
  //if (line -> line.contains(recipeTitles)) println (recipeTitles)
  //if (line == ingredientCount) println (ingredients) or maybe line.length == ingredientCount
  //else
  //else if (line => poemLines.split("\n\r") println(ingredients)  //&& lineCount +=1) // check how to iterate that it is after on empty line
  //else println("\n")
  // if line is the recipe title line, then print that line
  //else if after one empty line there are ingredients list, then print the list of ingredients
  // else print empty line or new line
  //}
  //}
  //titleIngredients.foreach(println)

  //val ingredients = poemLines.filter(_.startsWith("  "))

  //ingredients.foreach(println)
  //val titlesIngredients: String = ingredients.mkString("\n") //one big string with newlines in between


//this somewhat works, just doesn't include all the titles
  val count = 1
  val countMore = 2
  for (text <- linestoAnalyze) {
    if (text.contains(recipeTitles)) {
      recipeTitles.foreach(println)
    }
    else if (text.trim.length == count || text.trim.length == countMore) {
      if (text.contains(ingredients)) println(ingredients.mkString("\n"))
      else println("No Ingredients")
    }
    else text.split("\n\r")
  }

}
