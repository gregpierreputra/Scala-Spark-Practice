package com.rockthejvm

object OOPractice extends App
{
  /*
  My First CLass

  val - immutable - read only parameters
  var - mutable - readable and modifiable parameters

  The class below utilizes a single primary constructor
  We can also add auxiliary constructors
   */
  // [1] - The primary constructor
  class Animal(var myName: String,
               var myAge: Int,
               var hasTail: Boolean,
               var hasFeet: Boolean,
               var hasWings: Boolean)
  {
    var _hasFourLegs: Boolean = false
    var _hasTwoLegs: Boolean = false
    val fullBooleans: List[Boolean] = List(hasTail, hasFeet, hasWings)

    // [2] - Auxiliary constructor for four legs and two legs parameters
    def this(myName: String,
             myAge: Int,
             hasTail: Boolean,
             hasFeet: Boolean,
             hasWings: Boolean,
             hasFourLegs: Boolean,
             hasTwoLegs: Boolean) = {
      this(myName, myAge, hasTail, hasFeet, hasWings)
      _hasFourLegs = hasFourLegs
      _hasTwoLegs = hasTwoLegs
    }

    def printFeatures(): Unit =
    {
      println("My key features are:" +
        s"Tail : $fullBooleans[0]" +
        s"Feet : $fullBooleans[1]" +
        s"Wings : $fullBooleans[2]")
    }

    def display(): Unit =
    {
      println(s"I am an animal.\nMy name is $myName.\nI am $myAge years old" +
              s"\nThe status of my tail is : $hasTail" +
              s"\nThe status of my feet are : $hasFeet" +
              s"\nThe status of my wings are : $hasWings")
    }

    /*
    We do not need to make getters and setters as they are automatically created
    Look at https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html#classes
     */

    def eat(): Unit = {
      println("I am eating!")
    }
    def thoughts(): Unit = {
      println("I am thinking!")
    }
  }

  val anAnimal: Animal = new Animal("Jorge", 4, true, true, false )
  println(anAnimal)

  /*
  My First Abstract Class
   */
  abstract class AquaticAnimal
  {
    val hasGills: Boolean = true
    val hasEyes: Boolean = true

    val hasTail: Boolean
    val hasFins: Boolean
    val numberOfEyes: Int

    def eat(): Unit
    def swim(): Unit
    def walk(): Unit
  }

  /*
  My First Trait - Similar to Interfaces in Java
   */
  trait Carnivore
  {
    def eat(animal: Animal): Unit
  }

  trait Herbivore
  {
    def eat(plant: String): Unit
  }

  trait Omnivore
  {
    def eat(animal: Animal, plant: String): Unit
  }

  trait Philosopher
  {
    def ?(thought: String): Unit
  }

  trait Interests
  {
    def likes(likes: List[String]): Unit
    def hates(hates: List[String]): Unit
  }

  /*
  My First Inheritance class
   */
  // class Bear extends Animal with Omnivore with Philosopher with Interests

  /*
  class Salmon extends AquaticAnimal with Philosopher with Interests
  {
    override def likes(likes: List[String]): Unit = {

    }
  }
  */

  /*
  My First Subtype Polymorphism
   */
}
