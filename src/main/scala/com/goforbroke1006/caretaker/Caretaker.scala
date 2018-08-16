package com.goforbroke1006.caretaker

object Caretaker extends App {
  val before = System.currentTimeMillis()
  println("Hello World from Scala!")
  val after = System.currentTimeMillis()

  val est = (after - before).doubleValue()
  println(est)
}
