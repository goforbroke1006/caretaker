package com.goforbroke1006.caretaker.parser.strategy

import com.goforbroke1006.caretaker.parser.{ParserStrategy, StatisticsItem}
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Document
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.{elementList, text}

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

class SpbCianRu extends ParserStrategy {
  override def supports(siteUrl: String): Boolean = {
    siteUrl.contains("spb.cian.ru")
  }

  override def parse(doc: Document): List[StatisticsItem] = {
    val res = new ListBuffer[StatisticsItem]
    val items = doc >> elementList(".serp-item.serp-item_type_1")
    val priceRegex: Regex = "([0-9,]+)–([0-9,]+) млн. руб. за ([0-9])-комнатные от ([0-9,]+) м2".r
    for (item <- items) {
      val developer = item >> text(".serp-item__title")
      if (developer.contains("Надёжный выбор Мы проверили этот объект на соответствие критериям надёжности")) {
        //
      } else {
        val pricesBlock = item >> elementList(".serp-item__description-col.serp-item__newobject__stat > .row > .row")
        for (pb <- pricesBlock) {
          val str = pb >> text("*")
          val matches = priceRegex.findAllIn(str)
          //          println(matches)

          if (matches.nonEmpty) {
            val min = matches.group(1).replace(',', '.').toDouble
            val max = matches.group(2).replace(',', '.').toDouble
            res +=
              new StatisticsItem(
                developer,
                min,
                min + (max - min) / 2,
                max,
                matches.group(3).toInt
              )
          }
        }
      }
    }
    res.toList
  }
}
