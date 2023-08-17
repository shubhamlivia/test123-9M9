/**
 * Exercise 1:
Write a function that takes a list of integers and returns a new list where each element is replaced
by the product of all the other elements in the original list.

Exercise 2:
Write a function that takes a list of strings and returns a new list where each string is sorted alphabetically,
but with the vowels removed.

Exercise 3:
Write a function that takes a list of tuples, where each tuple contains a string and an integer. Return a new list
of strings where each string is repeated as many times as its corresponding integer in the tuple.

Exercise 4:
Write a function that takes a list of integers and returns a new list where each element is the average of its
adjacent elements in the original list.

Exercise 5:
Write a function that takes a list of strings and returns a new list where each string is replaced by the
longest common prefix among all the strings in the original list.

Exercise 6:
Write a function that takes a list of integers and returns a new list where each element is the sum of
the absolute differences between itself and all the other elements in the original list.


Exercise 9:
Write a function that takes a list of strings and returns a new list where each string is replaced by its reverse,
but with all the vowels capitalized.

Exercise 10:
Write a function that takes a list of integers and returns a new list where each element is
replaced by the number of distinct prime factors it has.
 */

package scalaCollections

object Lists2 extends App{

  def productofOtherElements(lst:List[Int]):List[Int]={

    var newlist:List[Int] = List()

    for(element <- lst){
      val productList = lst.filterNot(x=> x==element)
      var sum=1
      for(i<- 0 to productList.length-1){
        sum = sum * productList(i)
      }
      newlist = newlist :+ sum
    }
    newlist
  }

  println(productofOtherElements(List(1,2,0,4)))

  def stringSorted(lst:List[String]):List[String] = {
    val vowellist = List("a","e","i","o","u")
    var outputlist:List[String] = List()

    for(str <- lst){
      if(!vowellist.contains(str.charAt(0).toString.toLowerCase)){
        outputlist = outputlist :+ str
      }
    }
    outputlist.sorted
  }

  println(stringSorted(List("iphone","Random","Uturn","Power","Eye","Box","Queue")))


  def tupleString(lst:List[(String, Integer)]):List[String]= {

    var newlst:List[String] = List()

    for((key,value) <- lst){
      for(i<-0 to value-1){
        newlst = newlst :+ key
      }
    }
    newlst
  }

  println(tupleString(List(("chandra",1),("Jena",2),("Random",3))))

  def tupleString1(lst:List[(String, Integer)]):List[String]= {
    lst.flatMap
    {
      case (key,value)=>
        List.fill(value.toInt)(key)
    }
  }
  println(tupleString1(List(("chandra",1),("Jena",2),("Random",3))))

  def adjacentElementsAvg(lst:List[Int]):List[Int] = {

    var newlist:List[Int] = List()

    for(i<-0 to lst.length-1){

      val prev = if (i > 0) lst(i - 1) else 0
      val next = if (i < lst.length - 1) lst(i + 1) else 0
      val avg = (prev + next) / 2
      newlist = newlist :+ avg

    }
    newlist
  }
  println(adjacentElementsAvg(List(5,8,4,6,2)))

  def absoluteDiffElements(lst:List[Int]):List[Int] = {

    var newlist:List[Int] = List()

    for(i<-0 to lst.length-1)
      {
        var sum=0
        for(j<-0 to lst.length-1)
          {
            sum = sum + Math.abs(lst(i)  - lst(j))
          }
          newlist = newlist :+ sum
      }
      newlist
  }

  println(absoluteDiffElements(List(1,2,3,4,5)))

  def absoluteDiffElements1(lst: List[Int]): List[Int] = {
    lst.map(num => lst.map(other => Math.abs(num - other)).sum)
  }

  val outputList = absoluteDiffElements1(List(1, 2, 3, 4, 5))
  println(outputList)


  def reverseStrVowelsCapital(lst:List[String]):List[String] = {
    val vowels = List("a", "e", "i", "o", "u")

    val reversestr = lst.map{ str =>
      val reversed = str.reverse
      val capitalized = reversed.map { char =>
        if(vowels.contains(char.toString.toLowerCase())){
          char.toString.toUpperCase()
        }
        else
          char.toString
      }
      capitalized.mkString
    }
    reversestr
  }

  println(reverseStrVowelsCapital(List("chandra","kanth","hello","how","are","you?")))
}
