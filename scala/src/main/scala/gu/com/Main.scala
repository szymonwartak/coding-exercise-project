package gu.com

import collection.mutable

class Game {
  /**
    * - bottom left is 0, 0; 7 columns X 6 rows
    */
  val board = (0 until 7).map(_ => new StringBuilder("......"))

  def move(player: String, column: Int) {
    val row = board(column).zipWithIndex.find{ case (c, idx) => c == '.' } match {
      case None => throw new Exception("illegal move - column is full")
      case Some((_, idx)) => idx
    }
    board(column).replace(row, row + 1, player)
  }

  def checkWin(): Boolean = {
    // column check
    if (board.exists(col => col.toString.contains("xxxx"))) {
      print("Player x wins")
      return true
    }
    // row check
    // diag - up right check
    // diag2 check
    false
  }

  override def toString(): String = {
    (0 until 6).map(row => (0 until 7).map(col => board(col)(5 - row)).mkString).mkString("\n")
  }
}
object Main {
  def main(args: Array[String]): Unit = {



  }

  def whereWeLive = "Mars"
}
