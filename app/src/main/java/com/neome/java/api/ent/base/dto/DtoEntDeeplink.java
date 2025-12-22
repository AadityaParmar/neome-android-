// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnKindDeeplink;
import com.neome.java.api.meta.base.Types.MetaIdDeeplink;
import com.neome.java.api.meta.base.dto.StudioModuleSelection;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntDeeplink
{
  public MetaIdDeeplink deepLinkId;

  @Nullable
  public String description;

  public EnumDefnKindDeeplink kind;

  @Nullable
  public StudioModuleSelection modules;

  public Symbol name;
}
