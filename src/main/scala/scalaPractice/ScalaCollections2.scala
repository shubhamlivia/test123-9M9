package scalaPractice

object ScalaCollections2 {

//  def reverseWords(s: String): String = {
//    val str = s.split(" ")
//    val reverseWords = str.map(reverseString)
//    reverseWords.mkString(" ")
//  }
//
//  def reverseString(s: String): String = {
//    val n = s.length
//    var chars = s.toCharArray
//    for(i<- 0 until n/2)
//    {
//      val temp = chars(i)
//      chars(i)=chars(n-1-i)
//      chars(n-1-i) = temp
//    }
//    new String(chars)
//  }


  def reverseWords(s: String): String = {
    val words = s.split("\\s+")
    val reversedWords = words.map(x=> x.reverse)    //word reverse -each letter in a word is reversed.
    reversedWords.mkString(" ")
  }


  def reverseSentence(s: String): String = {
    s.split("\\s+").reverse.mkString(" ")   //word order reverse
  }

  def main(args: Array[String]): Unit = {
    val sentence1 = "Hello world, how are you?"
    val reversedSentence1 = reverseWords(sentence1)
    println(reversedSentence1)

    val sentence = "Hello world, how are you?"
    val reversedSentence = reverseSentence(sentence)
    println(reversedSentence)
  }
}
