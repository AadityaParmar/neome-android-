// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdPrompt;
import com.neome.java.api.meta.base.dto.FormValue;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoPromptAction
{
  public boolean executeOnClient;

  @Nullable
  public FormValue formValue;

  @Nullable
  public MetaIdAction promptActionId;

  @Nullable
  public MetaIdPrompt promptId;

  @Nullable
  public MetaIdForm ragFormId;
}
