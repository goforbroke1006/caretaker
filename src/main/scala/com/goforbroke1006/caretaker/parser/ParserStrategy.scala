package com.goforbroke1006.caretaker.parser

import net.ruippeixotog.scalascraper.model.Document

trait ParserStrategy {
  def supports(siteUrl: String): Boolean

  def parse(doc: Document): Seq[StatItem]
}
