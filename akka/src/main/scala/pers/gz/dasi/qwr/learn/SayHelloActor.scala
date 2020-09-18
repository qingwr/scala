package pers.gz.dasi.qwr.learn

import akka.actor.{Actor, ActorSystem, Props}

object SayHelloActor {

  //创建 ActorSystem
  private val actorFactory = ActorSystem("ActorFactory")
  //说明
  //1.通过  actorFactory 创建 SayHelloActor 对应的 ActorRef
  //2.目的是通过sayHelloActorRef 发送消息
  //3.Props[SayHelloActor] 表示创建的是 SayHelloActor 这个actor(通过反射机制)
  //4.actorFactory.actorOf 方法返回的是 actorRef,可以理解成是actor的代理对象/引用
  //4."sayHelloActor" 是actor/actorref的名字，由程序员指定
  private val sayHelloActorRef = actorFactory.actorOf(Props[SayHelloActor], "sayHelloActor")

  def main(args: Array[String]): Unit = {

    // 给sayHelloActorRef发送消息
    // ！是方法名，可以看下源码
    sayHelloActorRef ! "hello"
    sayHelloActorRef ! "ok"

    //如果不发送exit, Actor就会等待接收消息，而不会退出程序.
    sayHelloActorRef ! "exit"

  }
}

class SayHelloActor extends Actor {
  // 循环的接收消息,
  override def receive: Receive = {
    // 接受消息并处理,如果接收到exit，就退出
    case "hello" => println("发送:hello\t\t回应: hello too:)", Thread.currentThread.getName)
    case "ok" => println("发送:ok\t\t\t回应: ok too:)", Thread.currentThread.getName)
    case "exit" => {
      println("接收到exit~指令，退出系统.....", Thread.currentThread.getName)
      context.stop(self) // 停止自己的actorRef
      context.system.terminate() // 关闭ActorSystem
      //      Thread
    }
  }
}