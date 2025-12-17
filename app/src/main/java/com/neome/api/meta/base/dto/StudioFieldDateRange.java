// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDateRange extends StudioFieldDate
{
  @Nullable
  public StudioBuildDate fromDefault;

  @Nullable
  public MetaIdField fromDefaultFieldId;

  @Nullable
  public MetaIdVar fromDefaultVarId;

  @Nullable
  public StudioBuildDate toDefault;

  @Nullable
  public MetaIdField toDefaultFieldId;

  @Nullable
  public MetaIdVar toDefaultVarId;
}
