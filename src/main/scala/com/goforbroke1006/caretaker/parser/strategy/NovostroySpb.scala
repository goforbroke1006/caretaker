package com.goforbroke1006.caretaker.parser.strategy

import com.goforbroke1006.caretaker.parser.{ParserStrategy, StatisticsItem}
import net.ruippeixotog.scalascraper.model.Document

class NovostroySpb extends ParserStrategy {
  override def supports(siteUrl: String): Boolean = {
    false
  }

  def parse(doc: Document): List[StatisticsItem] = {
    List()
  }
}
