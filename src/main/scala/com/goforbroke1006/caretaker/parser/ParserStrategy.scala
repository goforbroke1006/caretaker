package com.goforbroke1006.caretaker.parser

trait ParserStrategy {
  def supports(siteUrl: String)

  def parse(siteUrl: String)
}
