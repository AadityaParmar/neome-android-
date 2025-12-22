// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldTime extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public DefnBuildTime defaultValue;

  @Nullable
  public DefnBuildTime defaultVar;

  @Nullable
  public String displayDateFormat;

  @Nullable
  public DefnBuildTime max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public DefnBuildTime maxVar;

  @Nullable
  public DefnBuildTime min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public DefnBuildTime minVar;

  @Nullable
  public Boolean showSecond;

  @Nullable
  public MetaIdField showSecondFieldId;

  @Nullable
  public Boolean showSecondVar;
}
