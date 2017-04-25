/*
 * Copyright 2017 Leanne Northrop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.northrop.leanne


object Main {
  def run(arg1: String) : Unit = {
    println(s"Hello ${arg1}")
  }

  def main(args: Array[String]) : Unit = args.length match {
    case 0 => println("""Usage:
              |scala org.northrop.leanne.Main 'arg1'
              |""".stripMargin)
    case 1 =>
      run(args(0))
    case _ =>
      run(args(0))
      println("Don't know what to do with additional arguments: " + args.splitAt(1)._2.deep.mkString(", "))
  }
}
