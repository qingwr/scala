package worker

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import common.{RegisterWorkerInfo, RegisteredWorkerInfo}

class SparkWorker(masterUrl: String) extends Actor {
  var masterProxy: ActorSelection = _
  val workerId = UUID.randomUUID().toString

  override def preStart(): Unit = {
    masterProxy = context.actorSelection(masterUrl)
  }

  override def receive: Receive = {
    case "start" => { // 自己已就绪
      println(workerId + " 向master发出注册信息... ")
      masterProxy ! RegisterWorkerInfo(workerId, 1, 64 * 1024) //
    }
    case RegisteredWorkerInfo => {
      println(workerId + " 向master注册成功了... ")
    }
  }
}

object SparkWorker {
  def main(args: Array[String]): Unit = {
    val host = "127.0.0.1"
    val port = 10002
    val masterURL = "akka.tcp://sparkMaster@127.0.0.1:10001/user/master-01"
    val workerName = "worker-01"
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=127.0.0.1
         |akka.remote.netty.tcp.port=10002
            """.stripMargin)
    val actorSystem = ActorSystem("sparkWorker", config)
    val workerActorRef = actorSystem.actorOf(Props(new SparkWorker(masterURL)), workerName)
    workerActorRef ! "start"
  }
}
