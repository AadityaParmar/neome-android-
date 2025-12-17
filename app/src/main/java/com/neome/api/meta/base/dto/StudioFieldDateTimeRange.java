// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDateTimeRange extends StudioFieldDateTime
{
  @Nullable
  public StudioBuildDateTime fromDefault;

  @Nullable
  public MetaIdField fromDefaultFieldId;

  @Nullable
  public MetaIdVar fromDefaultVarId;

  @Nullable
  public StudioBuildDateTime toDefault;

  @Nullable
  public MetaIdField toDefaultFieldId;

  @Nullable
  public MetaIdVar toDefaultVarId;
}
