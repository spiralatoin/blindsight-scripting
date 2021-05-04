package com.tersesystems.blindsight.scripting

import com.tersesystems.blindsight.Condition
import sourcecode.{Enclosing, Line}

import java.nio.file.Path

class TweakFlowConditionManager(path: Path, verifier: String => Boolean) {

  private val fileConditionSource = new FileConditionSource(path, verifier)

  def condition()(implicit line: Line, enclosing: Enclosing, file: sourcecode.File): Condition = {
    new TweakFlowDynamicCondition(fileConditionSource, line, enclosing, file)
  }
}
