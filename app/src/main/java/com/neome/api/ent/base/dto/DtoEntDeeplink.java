// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink;
import com.neome.api.meta.base.Types.MetaIdDeeplink;
import com.neome.api.meta.base.dto.StudioModuleSelection;

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
