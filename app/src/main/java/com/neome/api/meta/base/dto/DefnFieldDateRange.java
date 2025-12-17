// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDateRange extends DefnFieldDate
{
  @Nullable
  public Boolean allowSingleDate;

  @Nullable
  public DefnBuildDate fromDefault;

  @Nullable
  public MetaIdField fromDefaultFieldId;

  @Nullable
  public DefnBuildDate fromDefaultVar;

  @Nullable
  public DefnBuildDate toDefault;

  @Nullable
  public MetaIdField toDefaultFieldId;

  @Nullable
  public DefnBuildDate toDefaultVar;
}
