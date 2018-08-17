package com.goforbroke1006.caretaker.parser.strategy

import com.goforbroke1006.caretaker.parser.{ParserStrategy, StatItem}
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.{Document, Element}
import net.ruippeixotog.scalascraper.scraper.ContentExtractors.{elementList, text}

class SpbCianRu extends ParserStrategy {
  override def supports(siteUrl: String): Boolean = false

  override def parse(doc: Document): Seq[StatItem] = {
    val items = doc >> elementList(".serp-item.serp-item_type_1")
    /*var tmpRes = Seq[StatItem]
    for (item <- items) {
      val developer = item >> text(".serp-item__title")
//      val pricesBlock = item >> elementList(".serp-item__description-col.serp-item__newobject__stat > .row > .row")
//      tmpRes = pricesBlock.map(_.text => new StatItem(_, 0.0, 0.0, 0.0, 1))
      yield tmpRes
    }*/

    List()
  }
}
