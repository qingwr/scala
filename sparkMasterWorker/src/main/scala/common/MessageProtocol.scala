package common

// worker注册信息 //MessageProtocol.scala
case class RegisterWorkerInfo(id: String, cpu: Int, ram: Int)
// 这个是WorkerInfo, 保存在master的hashmap中的
class WorkerInfo(val id: String, val cpu: Int, val ram: Int)
case object RegisteredWorkerInfo
