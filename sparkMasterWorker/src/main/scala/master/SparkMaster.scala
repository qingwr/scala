package master

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import common.{RegisterWorkerInfo, RegisteredWorkerInfo, WorkerInfo}

class SparkMaster extends Actor { //SparkMaster.scala
  val workers = collection.mutable.HashMap[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => println("master服务，启动并开始监听端口....")
    case RegisterWorkerInfo(workerId, cpu, ram) => {
      if (!workers.contains(workerId)) {
        println(workerId + " 注册ok.... ")
        val workerInfo = new WorkerInfo(workerId, cpu, ram)
        workers += ((workerId, workerInfo))
        sender() ! RegisteredWorkerInfo
      }
    }
  }
}

object SparkMaster {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=127.0.0.1
         |akka.remote.netty.tcp.port=10001
            """.stripMargin)
    val actorSystem = ActorSystem("sparkMaster", config)
    val masterActorRef = actorSystem.actorOf(Props[SparkMaster], "master-01")
    masterActorRef ! "start"
  }
}
