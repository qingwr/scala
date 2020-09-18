package pers.gz.dasi.qwr

import akka.actor.{ActorSystem, Props}

package object learn {
  private val actorFactory = ActorSystem("actorFactory")
  val aActorRef = actorFactory.actorOf(Props[AActor], "AActorRef")
  val bActorRef = actorFactory.actorOf(Props[BActor], "BActorRef")
}
