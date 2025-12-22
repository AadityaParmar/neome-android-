// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDocFileExt;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDocument extends DefnFieldEditable
{
  @Nullable
  public Boolean disablePreview;

  @Nullable
  public EnumDefnDocFileExt[] fileTypeSet;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdField maxSizeFieldId;

  @Nullable
  public Long maxSizeVar;

  @Nullable
  public Boolean showSize;

  @Nullable
  public MetaIdField showSizeFieldId;

  @Nullable
  public Boolean showSizeVar;
}
