package com.goforbroke1006.caretaker.parser

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.model.Document

import scala.collection.mutable.ListBuffer

object Context {
  private var list = new ListBuffer[ParserStrategy]()

  val register: Unit = (strategy: ParserStrategy) => {
    list += strategy
  }

  var resolve : Seq[StatisticsItem] = (url: String) => {
    val browser = JsoupBrowser()
    val doc = browser.get(url)
    list.filter(_.supports(url)).head.parse(doc)
  }
}
