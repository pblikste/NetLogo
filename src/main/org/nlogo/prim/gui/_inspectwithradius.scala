package org.nlogo.prim.gui

import org.nlogo.api.I18N
import org.nlogo.nvm.{ Command, Context, EngineException, Syntax }

class _inspectwithradius extends Command {
  override def syntax =
    Syntax.commandSyntax(Array(Syntax.TYPE_AGENT, Syntax.TYPE_NUMBER))
  override def perform(context: Context) {
    val agent = argEvalAgent(context, 0)
    val radius = argEvalDouble(context, 1)
    if (agent.id == -1)
      throw new EngineException(context, this,
        I18N.errors.getN("org.nlogo.$common.thatAgentIsDead", agent.classDisplayName))
    val limit = (world.worldWidth - 1) / 2
    if (radius < 0 || radius > limit)
      throw new EngineException(
        context, this, "the radius must be between 0 and " + limit)
    org.nlogo.awt.Utils.invokeLater(
      new Runnable {
        override def run() {
            workspace.inspectAgent(agent.getAgentClass, agent, radius)
        }})
    context.ip = next
  }
}