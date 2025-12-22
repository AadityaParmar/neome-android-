// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnVideoFormat;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldVideo extends DefnFieldEditable
{
  @Nullable
  public Boolean allowPickVideo;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdField maxSizeFieldId;

  @Nullable
  public Long maxSizeVar;

  @Nullable
  public Boolean showPreview;

  @Nullable
  public MetaIdField showPreviewFieldId;

  @Nullable
  public Boolean showPreviewVar;

  @Nullable
  public Boolean showSize;

  @Nullable
  public MetaIdField showSizeFieldId;

  @Nullable
  public Boolean showSizeVar;

  @Nullable
  public EnumDefnVideoFormat videoFormatType;
}
