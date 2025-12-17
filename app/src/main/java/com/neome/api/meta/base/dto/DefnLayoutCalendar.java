// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutCalendar extends DefnLayoutGrid
{
  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public MetaIdField fromDateFieldId;

  @Nullable
  public MetaIdField fromTimeFieldId;

  @Nullable
  public MetaIdField[] showFieldIdSet;

  @Nullable
  public MetaIdField titleFieldId;

  @Nullable
  public MetaIdField toDateFieldId;

  @Nullable
  public MetaIdField toTimeFieldId;
}
