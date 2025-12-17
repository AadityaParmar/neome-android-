// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnDocFileExt;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldDocument extends StudioFieldEditable
{
  @Nullable
  public EnumDefnDocFileExt[] fileTypeSet;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdField maxSizeFieldId;

  @Nullable
  public MetaIdVar maxSizeVarId;

  @Nullable
  public Boolean showSize;

  @Nullable
  public MetaIdField showSizeFieldId;

  @Nullable
  public MetaIdVar showSizeVarId;
}
