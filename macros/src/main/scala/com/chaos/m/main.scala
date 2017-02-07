package com.chaos.m

import scala.annotation.StaticAnnotation

import scala.meta._

/**
  * Created by zcfrank1st on 07/02/2017.
  */
class main extends StaticAnnotation {
  inline def apply(defn: Any): Any = meta {
    val q"object $name { ..$stats }" = defn
    val main = q"def main(args: Array[String]): Unit = { ..$stats }"
    q"object $name { $main }"
  }
}
