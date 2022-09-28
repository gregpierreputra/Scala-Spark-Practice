package com.rockthejvm

/*
extends App
everything in the brackets executes as a stand-alone application
 */
object Basics extends App
{
  /*
  Defining a value
   */
  val meaningOfLife:Int = 42
  /*
  Reassignment is illegal, will throw an error
  meaningOfLife = 43
   */

  /*
  Type-casting is optional, we can just do the below and it automatically detects it
  The standard data-types are:
  Int, Double, Float, Boolean, Char, String
   */
  val myAge: Int = 23
  val aDouble: Double = 23.1
  val aFloat: Float = 79.13f
  /*
  Chars are written in SINGLE quotation marks ('')
  Strings are written in DOUBLE quotation marks ("")
   */
  val aChar: Char = 'E'
  val aString: String = "This string is written in DOUBLE quotation marks"
  val aBoolean = false
  val secondBoolean: Boolean = true

  /*
  String and String Operations
  Strings can be composed with other with other strings using the + notation
   */
  val scalaString = "I love Scala"
  val aComposedString = "I" + "Love" + "Scala"
  // We can also inject values into strings using the following notation
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  /*
  Expressions
  Structures that can be reduced to values

  Scala thinks in terms of values and composing these values to obtain new values
   */
  val anExpression = 2 + 3


  /*
  If-expression

  The if statement below reduces to a single value, e.g., either 56 or 999 depending on the meaningOfLife
  Similar to a ternary operator in C++ and JavaScript, e.g., meaningOfLife > 43 ? 56 : 999
   */
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  /*
  Chained if-expression

  We can chain them as long as we want. It works as in the end it cna be expressed as a single value
  e.g., 56, -2, 78 or 0

  We are assigning values to these names if some conditions are true or not
   */
  val chainedIfExpression = {
    if (meaningOfLife > 42) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  /*
  Code Block

  Inside them you can define: local values, functions, classes, even an inner code block
  HOWEVER, you MUST RETURN something AT THE END
  I
   */
  val aCodeBlock = {
    // Definitions
    val aLocalValue = 67

    // Value of the block is the last expression of the block
    aLocalValue + 3
  }

  /*
  Functions

  The notation is as follows:
  def <function-name>(<parameters>:<datatype>):<return datatype> = <expression>
   */
  def myFunction(x: Int, y: String): String = y + " " + x

  /*
  Functions can also be defined inside a code block as it is also an expression
   */
  def codeBlockFunction(x: Int, y: String): String = {
    y + " " + x
  }

  /*
  Recursive Functions

  Functions are usually dependent on their own definitions - hence, recursion
  The below code is a recursive code,
  factorial(4) = 4 * factorial(3)
  factorial(3) = 3 * factorial(2)
  factorial(2) = 2 * factorial(1)
  factorial(1) = 1

  Hence, we GO DOWN the STACK to calculate the expression and then GO BACK UP the STACK to calculate the final value
   */
  def factorial(n: Int): Int =
    if (n >= 1) 1
    else n * factorial(n - 1)

  /*
  Scala does not use LOOPS or ITERATIONS, we use RECURSION
  Scala DOES HAVE variables and loops - but, they are HEAVILY DISCOURAGED
   */

  /*
  There is a "void" or no meaningful data value RETURN TYPE it is the
  Unit datatype

  The unit type of is the type of SIDE EFFECTS
  SIDE EFFECTS
  - have NOTHING TO DO with computing some meaningful information
  - relate to printing something on screen
  - showing something on screen
  - sending something to a socket or server
  - storing something in a file,
   */

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit!")
  }
}
