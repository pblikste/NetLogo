// (C) 2011 Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim;

import org.nlogo.nvm.Reporter;
import org.nlogo.api.Syntax;
import org.nlogo.nvm.Context;
import org.nlogo.agent.Turtle;
import org.nlogo.agent.Patch;
import org.nlogo.api.Nobody$;

public final strictfp class _patchnw extends Reporter {
  @Override
  public Syntax syntax() {
    return Syntax.reporterSyntax
        (Syntax.PatchType(), "-TP-");
  }

  @Override
  public Object report(Context context) {
    return report_1(context);
  }

  public Object report_1(Context context) {
    Patch patch;
    if (context.agent instanceof Patch) {
      patch = ((Patch) context.agent).getPatchNorthWest();
    } else if (context.agent instanceof Turtle) {
      patch = ((Turtle) context.agent).getPatchHere().getPatchNorthWest();
    } else {
      patch = world.fastGetPatchAt(-1, 1);
    }
    if (patch == null) {
      return Nobody$.MODULE$;
    }
    return patch;
  }
}
