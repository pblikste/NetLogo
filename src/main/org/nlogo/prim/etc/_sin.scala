package org.nlogo.prim.etc

import org.nlogo.api.Syntax
import org.nlogo.nvm.{ Context, Pure, Reporter }

class _sin extends Reporter with Pure {
  override def syntax =
    Syntax.reporterSyntax(
      Array(Syntax.NumberType),
      Syntax.NumberType)
  override def report(context: Context) =
    Double.box(report_1(context, argEvalDoubleValue(context, 0)))
  def report_1(context: Context, arg0: Double) =
    StrictMath.sin(StrictMath.toRadians(arg0))
}