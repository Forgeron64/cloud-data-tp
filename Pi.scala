import scala.math.random

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._ 

/** Computes an approximation to pi */
object SparkPi {
  def main(args: Array[String]): Unit = {
  
  val sparkConf = new SparkConf().setAppName("Spark pI") 
  val sc = new SparkContext(sparkConf) 


   val n = args(0).toInt
  // var count = 0
  // var i = 0
  // for (i<-1 to n)
    val count = sc.parallelize(1 until n).map{ 
    i=>
      val x =random 
      val y =random
      if (x*x + y*y <= 1) 1 else 0
       //count=count+1
      }.reduce(_+_)
   println(s"Pi vaut ${4.0*count/(n-1)}")
  }
}
