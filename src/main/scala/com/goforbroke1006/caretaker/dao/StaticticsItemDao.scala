package com.goforbroke1006.caretaker.dao

import com.goforbroke1006.caretaker.dao.Helpers.GenericObservable
import com.goforbroke1006.caretaker.parser.StatisticsItem
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}

class StatisticsItemDao {
  val save: StatisticsItem => Unit = si => {
    val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017/caretaker?w=1")
    val database: MongoDatabase = mongoClient.getDatabase("caretaker")
    val collection: MongoCollection[Document] = database.getCollection("statisticsItem")
    val doc: Document = Document(
      "name" -> si.name, "type" -> "database",
      "count" -> 1, "info" -> Document("x" -> 203, "y" -> 102))
    collection.insertOne(doc).results()
    println(collection.countDocuments())
    println(doc)
    mongoClient.close()
    //  collection.find.first().printResults()
  }
}
