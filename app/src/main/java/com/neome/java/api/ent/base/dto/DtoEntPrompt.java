// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdPrompt;

import org.jetbrains.annotations.Nullable;

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
