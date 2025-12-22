// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.SysId;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.Set;

@SuppressWarnings("unused")
public class FieldDtoArg
{
  @Nullable
  public Boolean valueBoolean;

  @Nullable
  public Date valueDate;

  @Nullable
  public Double valueDouble;

  @Nullable
  public MetaIdField valueFieldId;

  @Nullable
  public Long valueLong;

  @Nullable
  public SysId valueSysId;

  @Nullable
  public SysId[] valueSysIdArray;

  @Nullable
  public Set<SysId> valueSysIdSet;

  @Nullable
  public String valueText;

  @Nullable
  public String[] valueTextArray;
}
