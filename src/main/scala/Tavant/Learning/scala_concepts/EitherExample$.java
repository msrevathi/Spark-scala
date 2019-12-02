//package Tavant.Learning.scala_concepts;
//
//object EitherExample  extends  App {
//
//  def name(name: String): Either[String, String]={
//    if (name.isEmpty)Left("No name!!!!")
//    else  Right(name)
//  }
//
//  println(name("John"))
//  println(name(""))
//
//  def div(x:Int, y:Int):Either[ String, Int]={
//    if(y == 0) Left("cant divide with zero")
//    else Right(x/y)
//  }
//
//  div(4,0) match {
//    case Left(l) => println("Left   " +l)
//    case Right(r) => println("Right  " +r)
//  }
//
//
//}
