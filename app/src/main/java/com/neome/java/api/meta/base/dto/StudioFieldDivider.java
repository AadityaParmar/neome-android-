// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDivider extends StudioField
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public EnumDefnThemeDividerKind dividerKind;

  @Nullable
  public MetaIdVar dividerKindVarId;
}
