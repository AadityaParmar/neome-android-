// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnKindAction;
import com.neome.java.api.meta.base.Types.MetaIdAction;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntAction
{
  public MetaIdAction actionId;

  @Nullable
  public String description;

  @Nullable
  public String icon;

  @Nullable
  public Boolean increaseAsideWidth;

  public EnumDefnKindAction kind;

  @Nullable
  public String label;

  public Symbol name;

  @Nullable
  public String tooltip;
}
