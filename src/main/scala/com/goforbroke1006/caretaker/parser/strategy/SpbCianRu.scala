package com.goforbroke1006.caretaker.parser.strategy

import com.goforbroke1006.caretaker.parser.{ParserStrategy, StatisticsItem}
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Document
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.{elementList, text}

import scala.collection.mutable.ListBuffer

class SpbCianRu extends ParserStrategy {
  override def supports(siteUrl: String): Boolean = {
    siteUrl.contains("spb.cian.ru")
  }

  override def parse(doc: Document): List[StatisticsItem] = {
    val res = new ListBuffer[StatisticsItem]
    val items = doc >> elementList(".serp-item.serp-item_type_1")
    for (item <- items) {
      val developer = item >> text(".serp-item__title")
      val pricesBlock = item >> elementList(".serp-item__description-col.serp-item__newobject__stat > .row > .row")
      for (pb <- pricesBlock) {
        res += new StatisticsItem(developer, 0.0, 0.0, 0.0, 1)
      }
    }
    res.toList
  }
}
