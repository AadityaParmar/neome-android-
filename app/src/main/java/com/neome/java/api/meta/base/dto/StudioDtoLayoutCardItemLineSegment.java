// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnTextSize;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutCardItemLineSegment extends StudioBase
{
  @Nullable
  public StudioDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public String line;

  @Nullable
  public MetaIdField[] lineFieldIdSet;

  @Nullable
  public StudioValueVarIdText lineVarId;

  @Nullable
  public Boolean showLabels;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public MetaIdField textSizeFieldId;

  @Nullable
  public MetaIdVar textSizeVarId;
}
