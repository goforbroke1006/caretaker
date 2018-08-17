package com.goforbroke1006.caretaker

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._

object Caretaker extends App {
  val before = System.currentTimeMillis()


  val browser = JsoupBrowser()
  val doc = browser.get("https://spb.cian.ru/novostroyki/")
  val items = doc >> elementList(".serp-item.serp-item_type_1")
  for (item <- items) {
    val developer = item >> text(".serp-item__title")
    val pricesBlock = item >> elementList(".serp-item__description-col.serp-item__newobject__stat > .row > .row")

    println(developer)
    pricesBlock.map(_ >> text("*")).foreach(println)
  }


  val after = System.currentTimeMillis()
  val est = (after - before).doubleValue()
  println(est)

}
