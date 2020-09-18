package pers.gz.dasi.qwr.learn

import akka.actor.Actor

object ToActor {
  def main(args: Array[String]): Unit = {
    println("走到林中僻静处!突然闪出一片身影! 赶紧告诉掌柜的")
    aActorRef ! AMessage("有人拦路!")

  }
}

class AActor extends Actor {
  override def receive = {
    case AMessage("有人拦路!") => {
      print("有人拦路!")
      bActorRef ! BMessage("来着何人!")
    }
    case AMessage("吾乃永州卿祛病是也!速速留下买路财!") => {
      print _
      bActorRef ! BMessage("@#*!")
    }
    case _ => println("开干")
  }
}

class BActor extends Actor {
  override def receive = {
    case BMessage("来着何人!") => {
      print _
      aActorRef ! AMessage("吾乃永州卿祛病是也!速速留下买路财!")
    }
    case BMessage("@#*!") => {
      print _
      aActorRef ! AMessage("那就是谈崩了!")
    }
    case _ => "搞么的!"
  }
}

case class AMessage(message: String)

case class BMessage(message: String)