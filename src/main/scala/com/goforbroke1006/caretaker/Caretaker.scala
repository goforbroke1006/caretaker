package com.goforbroke1006.caretaker

import com.goforbroke1006.caretaker.dao.StatisticsItemDao
import com.goforbroke1006.caretaker.parser.{Context, StatisticsItem}
import com.goforbroke1006.caretaker.parser.strategy.{NovostroySpb, SpbCianRu}

object Caretaker extends App {

  (new StatisticsItemDao).save(new StatisticsItem(name = "HELLO", 0, 0, 0))

  //  val before = System.currentTimeMillis()
  //
  //  Context.register(new NovostroySpb)
  //  Context.register(new SpbCianRu)
  //
  //  private val items = Context.resolveUrl("https://spb.cian.ru/novostroyki/")
  //  for (i <- items) {
  //    printf(
  //      "%s от %.2f до %.2f за %d-комнатную (средняя цена всего - %.2f, средняя за кв.м. - %.2f)",
  //      i.name, i.minPrice, i.maxPrice, i.roomsCount, i.avgPrice, 0f)
  //    println
  //  }
  //
  //  val after = System.currentTimeMillis()
  //  val est = (after - before).doubleValue()
  //  println(est)

}
