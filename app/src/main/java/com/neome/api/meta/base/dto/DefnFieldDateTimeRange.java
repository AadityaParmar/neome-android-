// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDateTimeRange extends DefnFieldDateTime
{
  @Nullable
  public Boolean allowSingleDate;

  @Nullable
  public DefnBuildDateTime fromDefault;

  @Nullable
  public MetaIdField fromDefaultFieldId;

  @Nullable
  public DefnBuildDateTime fromDefaultVar;

  @Nullable
  public DefnBuildDateTime toDefault;

  @Nullable
  public MetaIdField toDefaultFieldId;

  @Nullable
  public DefnBuildDateTime toDefaultVar;
}
