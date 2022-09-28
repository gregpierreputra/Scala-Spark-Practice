package com.learning

object ObjectOrientation extends App {
  /*
  Classes - we can create a class the notation below
  the extends notation means inheriting from all the methods of the superclass

  All methods are by default - public
  We can use private and protected for the field or methods
  private - only the class has access to this field or method
  protected - this class and all of its descendants have access to this method
   */
  class Animal {
    /*
   * We can instantiate this class - create a concrete representation of this class in memory
   * We define fields for this class as seen below
   */
    val myName: String = "Hewan"
    val age: Int = 0

    def eat() = println("I am eating")

    def me(): Unit = {
      println(s"My name is $this.myName")
    }
  }
  /*
   * Methods can be defined as seen above
   */



  val anAnimal = new Animal

  /*
   * Inheritance - inheriting all its members and method
   * Constructor arguments (e.g., new Dog("Lassie") are not automatically fields unless the CONSTRUCTOR has the val for the attribute(field name) before it
   * We need to write is as seen below to save a constructor argument into a class field when it is instantiated
   */
   class Dog(val name: String) extends Animal { // Constructor definition - we need to write it as seen below

    val aDog = new Dog(name="Jonah")
    println(aDog.name)


    /*
    Subtype polymorphism
    seen in other statically typed object-oriented languages

    an Animal class is declared on the left, but on the right we use a Dog class
    At compile time, the compiler only knows that you're calling the eat method from an Animal object
    At run time, the eat method will be called from the most derived class
     */
    val aDeclaredAnimal: Animal = new Dog("Hachi")
    // aDeclaredAnimal.eat() // Not sure why this doesn't work


    /*
    Abstract Classes

    We have a list of attributes/fields and an undefined method
    We can have attributes and methods be defined/undefined or implmented/unimplemented

    The method
    NEEDS TO BE OVERWRITTEN and PROVIDED an IMPLEMENTATION of this method
     */
    abstract class WalkingAnimal {
      val hasLegs = true
      val tail: Boolean
      val eyes: Int

      def walk(): Unit
    }

    /*
    Interface - Ultimate Abstract Type

    Basically an abstract type with EVERYTHING NOT IMPLEMENTED - we need to implement it in a further class
     */
    trait Carnivore {
      def eatMeat(animal: Animal): Unit
    }
    trait Herbivore {
      def eatPlant(animal: Animal): Unit
    }

    trait Philosopher {
      /*
      ?! is a method NAME - valid to use ? and ! in a method's name
       */
      def ?!(thought: String): Unit
    }

    /*
    Single class inheritance and multi trait inheritance - "Mixing"
     */
    class Crocodile extends Animal with Carnivore with Herbivore with Philosopher
    /*
     * The compiler tells us to EITHER declare the class as abstract or define the unimplemented methods in the traits
     *
     * Implementing the method of a supertype is an ovveride
     */
    {
      def eat(animal: Animal): Unit = println(s"I am eating $Animal.")

      override def eatMeat(animal: Animal): Unit = {
        println("I eat meats!")
      }

      override def eatPlant(animal: Animal): Unit = {
        println("I eat plants!")
      }


      override def ?!(thought: String): Unit = {
        println(s"I was thinking $thought")
      }

      // We can also override the method in the superclass (e.g., Animal in this case
      // override def eat(): Unit = super.eat()

      /*
       * Methods that use a single argument can be written in an infix notation
       */
      val aCrocodile = new Crocodile
      aCrocodile.eat(aDog)
      aCrocodile eat aDog // Infix notation
      aCrocodile ?! "What if we could fly!"

      // Operators in Scala are actually methods
      val basicMath = 1 + 2
      val translatedBasicMath = 1.+(2)

      /*
       * Anonymous classes
       *
       * We can create a value of a traits class and  define traits (interfaces) on the spot as seen below
       */
      val Dinosaur = new Carnivore {
        override def eatMeat(animal: Animal): Unit = println("I am a dinosaur, so I can eat anything!")
      }

      /*
       * Singleton object
       *
       * When defining object (e.g., mySingleton) - we have defined the type mySingleton and the single instance of the mySingleton type)
       */
      object mySingleton
      {
        val mySpecialValue = 53278

        def mySpecialMethod(): Int = 53278
        /*
        Special method called apply() which can take any arguments and be present in any class and object
         */
        def apply(x: Int): Int = {
          x + 1
        }
      }
      mySingleton.mySpecialMethod()

      /*
      The apply method can be called using the 2 similar functions

      Allows instances of that class to be invoked like functions.
       */
      mySingleton.apply(65)
      mySingleton(65) // both are equivalent - invoking the singleton object with the argument 65

      /*
      We can define a class and a singleton object in the same file - perfectly acceptable
       */
      object Animal { // The class animal and the object animal are called companions - called a companion object (same name as a Class or Trait)
        // Companions cna access each others' private fields/methods
        // Singleton animal and instances of Animal are different things

        val canLiveIndefinitely = false
      }

      val animalsCanLiveForever = Animal.canLiveIndefinitely // we access the singleton object Animal similar to "static" field/methods in Java


      /*
      Case Classes - lightweight data structures with some boilerplate
      - sensible equals and hash code
      - serialization
      - companion with apply
      - pattern matching

      We define a person with the following attributes
       */
      case class Person(name: String, age: Int)

      val Jackson = new Person(name="Jackson", age=54)
      val Bob = Person("Bob", 54) // Case Classess allows companionships with apply which is great for less code and w/o the keyword new
      // The above is equivalent to val Bob = Person.apply("Bob", 54)


      /*
      Exceptions

      If one of the objects is thrown, then the JVM will interrupt its normal code flow execution

      Exceptions are special objects treated with the try and catch expression
       */
      try {
        // Code that cna throw - usually done for error handling with the e lambda
        val x: String = null;
        x.length
      } catch {
        case e: Exception => "Some faulty error has occurred"
      } finally {
        // Execute some code no matter what - useful for closing connections, closing files, releasing memory, etc.
        println("Do the worm!")
      }


      /*
      Generics

      Abstract class and normal classes can be used with this

      We can pass a type argument that we normally use as single letters
      Hence, we can the type T can be relatively anything - a type definition - we make it concerte later during instantiation

       */
      abstract class MyList[T] {
        def head: T
        def tail: MyList[T]
      }

      /*
      This is the list notation for creating a list of ints in scala

      Using a generic - MyList with a concrete type
       */
      val aList: List[Int] = List(1,2, 3) // List.apply(1, 2 ,3)
      val first: Int = aList.head
      val rest: List[Int] = aList.tail

      val stringList: List[String] = List("hello", "world", "test", "earth", "rocket")
      val firstString: String = stringList.head
      val tailString: List[String] = stringList.tail


      /*
      In Scala, we operate with IMMUTABLE values
      any modification should result in another instance instead of the same instance being modified

      Benefits:
      1) Works miracles in multi-threaded environments / distributed code-bases
      2) Helps make sense of the code ("reasoning about")
       */
      val reversedList = aList.reverse // reverse is a method on the List type - this returns a new list called reversedList


      /*
      Scala is closest to the object-oriented ideal

      All piece of code is part of a class, object, since most of the values or methods are inside an object or class.
       */
    }
  }
}
