// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.ent.base.dto.DtoPromptAction;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigPromptActions extends Sig
{
  @Nullable
  public DtoPromptAction[] executedPromptActionList;

  @Nullable
  public DtoPromptAction[] reviewPromptActionList;
}
