val str = "hello"
str.hashCode
val str1 = "Hello this is longer string"
str1.hashCode

str.##
str1.##

3.0.hashCode()
3.0.##

val m=14

def hash[K](key: K) = {
  val h = key.## % m
  if(h <0 ) h + m else h
}

hash("Hello")

hash("hello")

hash(1000)

hash(19199245)

hash(20848053)

hash(19198979)