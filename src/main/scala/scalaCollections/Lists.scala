package scalaCollections

object Lists extends App{

  def isEmptyList[A](list:List[A]):List[A]= list.init

  println(isEmptyList(List(1,2,3,4,54)))

  val originalList = List(1,2,3,4)
  val newlist =  12 +: originalList  :+ 11 :+ 4
  println(newlist)
  val newlist2 = newlist.filter(x=> x== 4)

  def sumofEvenSquares(nums:List[Int]): Int = {
    nums.filter(x=> x%2==0).map(x=> x*x).sum
  }

  println(sumofEvenSquares(List(1,8,6,3)))

  /**
   * Write a function that takes two lists of integers and returns a new list that contains only the common elements
   * between the two lists, in the order they appear in the first list.
   */
  def commonElements(list1:List[Int], list2: List[Int]):List[Int] = {
    list1.filter(list2.contains)

    /**
     * list2.contains is a predicate function. It is called on each element of list1 during the filtering process.
     *
     * The contains method is invoked on list2 for each element of list1. This method checks whether list2 contains
     * the element passed as an argument and returns a Boolean value indicating whether the element is present
     * in list2 or not.
     * The filter method iterates over each element of list1 and applies the predicate function list2.contains to each
     * element. It retains only the elements for which the predicate returns true.
     *
     * In summary, list1.filter(list2.contains) filters list1 by keeping only the elements that are present in list2
     */
  }

  println(commonElements(List(1,2,3), List(2,0,1)))

  def uniqueSortedByLength(strings: List[String]): List[String] = {
    strings.distinct.sortBy(x=> x.length)
  }

  println(uniqueSortedByLength(List("hello","Test","Hello","hello","Chandra")))

  def reverseStrings(str:List[String]): List[String] = {
    str.map(x=> x.reverse)
  }
  println(reverseStrings(List("hello","Test","Hello","hello","Chandra")))

  def repeatByValue(lst:List[Int]):List[Int] = {
    var result:List[Int] = List()
    for(element <- lst)
      {
        var x = element
        while(x > 0)
          {
            result = result :+ element
            x = x-1
          }
      }
      result
  }

  println(repeatByValue(List(2,3,4)))


  def vowelList(genlist: List[String]): List[String] = {
    val vlist = List("a", "e", "i", "o", "u")
    var varray: List[String] = List()
    for (element <- genlist) {
      //if (vlist.contains(element.charAt(0).toString.toLowerCase())) {     //OR
      if(vlist.exists(vowel => element.toLowerCase.startsWith(vowel))) {
        varray = varray :+ element
      }
    }
    varray
  }

  println(vowelList(List("hello","ITest","uHello","hello","Chandra")))


  val str = "Chandra"
  val x = str.charAt(0)

  def separateEvenOdd(lst:List[Int]): (List[Int], List[Int]) = {
    val evenlst = lst.filter(x=> x%2==0).sorted
    val oddlst = lst.filter(x=> x%2!=0).sorted
    (evenlst,oddlst)
  }

  println(separateEvenOdd(List(1,2,3,4,5,6,7,8,9,0)))

  /**
   * vowel count >3
   */

  def threevowel(lst:List[String]): List[String] = {
    val vowlist = List("a","e","i","o","u")

    var vowlistwords:List[String] = List()

    for(element <- lst){
      var vowelcount=0

      for(char <- element){
        if (vowlist.contains(char.toString.toLowerCase())) {
          vowelcount = vowelcount + 1
        }
      }
      if(vowelcount > 3)
        {
          vowlistwords  = vowlistwords :+ element
        }
    }
    vowlistwords
  }

  println(threevowel(List("uTurnedon","Test","AnAffair","thanever")))

  def productExceptSelf(lst:List[Int]):List[Int] = {

    var productlist:List[Int] = List()

    for(value <- lst)
      {
        val newlist = lst.filterNot(x=> x==value)

        var productResult= 1

        for(newvalue <- newlist)
          {
            productResult= productResult * newvalue
          }
        productlist = productlist :+ productResult
      }
      productlist
  }

  println(productExceptSelf(List(4,3,0)))

  def commonElementsSortedByFrequency(list1: List[Int], list2: List[Int]): List[Int] = {

    val list3 = list1.filter(list2.contains).reverse
    list3

  }

  println(commonElementsSortedByFrequency(List(0,1,2), List(1,2,3)))

}
