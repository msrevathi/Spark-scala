package Tavant.Learning.examples

  object NumberReverse extends App {
    /* Iterative function to reverse
       digits of num*/
    def reversDigits(number: Int): Int = {

      var num = number
      var rev_num = 0
      while ( {
        num > 0
      }) {
        rev_num = rev_num * 10 + num % 10
        num = num / 10
      }
      rev_num
    }

    val num = 4562
    System.out.println("Reverse of no. is " + reversDigits(num))

    println("4562".foldLeft("")((x,y)=>y+x))
  }


/*
Example:
num = 4562
rev_num = 0

rev_num = rev_num *10 + num%10 = 2
num = num/10 = 456

rev_num = rev_num *10 + num%10 = 20 + 6 = 26
num = num/10 = 45

rev_num = rev_num *10 + num%10 = 260 + 5 = 265
num = num/10 = 4

rev_num = rev_num *10 + num%10 = 265 + 4 = 2654
num = num/10 = 0
 */