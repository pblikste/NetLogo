// (C) 2011 Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.agent.Link
import org.nlogo.api.Syntax
import org.nlogo.nvm.{ Command, Context }

class _showlink extends Command {
  override def syntax =
    Syntax.commandSyntax("---L", true)
  override def perform(context: Context) {
    context.agent.asInstanceOf[Link].hidden(false)
    context.ip = next
  }
}
