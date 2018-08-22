package com.goforbroke1006.caretaker.parser

import net.ruippeixotog.scalascraper.browser.JsoupBrowser

import scala.collection.mutable.ListBuffer

object Context {
  private var list = new ListBuffer[ParserStrategy]()

  val register: (ParserStrategy *) => Unit = strategies => {
    for (stg <- strategies)
      list += stg
  }

  var resolveUrl: String => List[StatisticsItem] = url => {
    val browser = JsoupBrowser()
    val doc = browser.get(url)
    list.filter(_.supports(url)).head.parse(doc)
  }
}
