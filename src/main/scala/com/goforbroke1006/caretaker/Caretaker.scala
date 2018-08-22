package com.goforbroke1006.caretaker

import com.goforbroke1006.caretaker.parser.{Context, StatisticsItem}
import com.goforbroke1006.caretaker.parser.strategy.{NovostroySpb, SpbCianRu}
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._

object Caretaker extends App {
  val before = System.currentTimeMillis()


  //  val browser = JsoupBrowser()
  //  val doc = browser.get("https://spb.cian.ru/novostroyki/")
  //  val items = doc >> elementList(".serp-item.serp-item_type_1")
  //  for (item <- items) {
  //    val developer = item >> text(".serp-item__title")
  //    val pricesBlock = item >> elementList(".serp-item__description-col.serp-item__newobject__stat > .row > .row")
  //
  //    println(developer)
  //    pricesBlock.map(_ >> text("*")).foreach(println)
  //  }

  Context.register(new NovostroySpb)
  Context.register(new SpbCianRu)

  private val items = Context.resolveUrl("https://spb.cian.ru/novostroyki/")
  for (i <- items) {
    printf("%s от %.2f до %.2f за %d-комнатную (средняя цена всего - %f, средняя за кв.м. - %f",
      i.name, i.minPrice, i.maxPrice, i.roomsCount, i.afgPrice, 0f)
    println
  }


  val after = System.currentTimeMillis()
  val est = (after - before).doubleValue()
  println(est)

}
