// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldTime extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public StudioBuildTime defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public StudioBuildTime max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public MetaIdVar maxVarId;

  @Nullable
  public StudioBuildTime min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public MetaIdVar minVarId;

  @Nullable
  public Boolean showSecond;

  @Nullable
  public MetaIdField showSecondFieldId;

  @Nullable
  public MetaIdVar showSecondVarId;
}
