// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EnumDefnKindHyperlink;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.dto.StudioDtoColor;

@SuppressWarnings("unused")
public class StudioVarValueHyperlink
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public String displayText;

  @Nullable
  public EnumDefnKindHyperlink kind;

  @Nullable
  public String value;
}
