package Tavant.Learning.examples

object ListReverse extends App{

  def revList[T](ll:List[T]):List[T] =ll match {
    case Nil=> Nil
    case x::xx => revList(xx)::: List(x)
  }

  def revListUsingFoldLet [T](ll:List[T]):List[T]={
    ll.foldLeft(List[T]()){ (r, h) => h :: r }
    }

}
