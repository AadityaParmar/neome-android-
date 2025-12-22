// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDate extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public StudioBuildDate defaultValue;

  @Nullable
  public MetaIdVar defaultVarId;

  @Nullable
  public String displayDateFormat;

  @Nullable
  public StudioBuildDate max;

  @Nullable
  public MetaIdField maxFieldId;

  @Nullable
  public MetaIdVar maxVarId;

  @Nullable
  public StudioBuildDate min;

  @Nullable
  public MetaIdField minFieldId;

  @Nullable
  public MetaIdVar minVarId;
}
