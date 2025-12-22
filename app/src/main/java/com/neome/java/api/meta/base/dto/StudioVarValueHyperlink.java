// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnKindHyperlink;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

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
