package com.learning

/**
  * This simple application is an invitation to you to play around with any Scala code you like!
  * (not that you'd not be able to create your own application, mind you.)
  *
  * So get creative - test the code that we write in the videos and try new things!
  *
  * Daniel @ Rock the JVM
  */
object Playground extends App 
{
  println("I love Scala!")

  val myFirstDouble: Double = 2.314
  val myFirstFloat: Float = 3.14f
  val myFirstInteger: Int = 123
  val myFirstChar: Char = 'C'
  val myFirstString: String = "The first index of Char is"

  def myFactorialFunction(value: Int): Int = {
    if (value <= 1) 1
    else value * myFactorialFunction(value - 1)
  }
  val fiveFactorialFunctionCall: Int = myFactorialFunction(5)
  print(s"The sum of my created factorial is $fiveFactorialFunctionCall")


  def chainedIfsIntoFunction(value: Int): String = {
    if (value == 10) s"This is the $value time I print this"
    else chainedIfsIntoFunction(value + 1)
  }
  val chainedStrings: String = chainedIfsIntoFunction(5)
  println("--------------" + s"\nThis is the value of chainedIfsIntoFunction(5) : $chainedStrings")


  val myCodeBlock: String = {
    s"$myFirstString" + s"$myFirstChar" + ' ' +"my first integer, double, and float are" + ' '
      s"$myFirstInteger, $myFirstDouble, $myFirstFloat respectively.\nThis string notation is a bit difficult to understand." +
      "\nI intentionally made this string difficult in order to practice string functions."
  }
  println(myCodeBlock)
}
