// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindHyperlink;
import com.neome.api.meta.base.Types.MetaIdHyperlink;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoHyperLink
{
  @Nullable
  public DefnDtoColor color;

  @Nullable
  public DefnDtoColor colorVar;

  @Nullable
  public String displayText;

  @Nullable
  public EnumDefnKindHyperlink kind;

  public MetaIdHyperlink metaId;

  @Nullable
  public String value;
}
