package Tavant.Learning.examples
import  scala.collection.immutable.Range
object isPrime  extends  App {
  def isPrimeNum(i:Int) = {
    !(2 until i)
      .exists(x => i % x == 0)}

  // println(isPrimeNum(5))

  def genPrime(start:Int, end:Int)={
  for(y <- start until end){
    if( y % start == 0) y
  }
  }
  println(genPrime(3,10))
}
