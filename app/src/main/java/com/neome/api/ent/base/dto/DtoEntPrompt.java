// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdPrompt;
import com.neome.api.meta.base.Symbol;

@SuppressWarnings("unused")
public class DtoEntPrompt
{
  public MetaIdAction actionId;

  @Nullable
  public String description;

  @Nullable
  public String hint;

  public MetaIdPrompt metaId;

  public Symbol name;
}
