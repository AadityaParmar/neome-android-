// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldImage extends StudioFieldEditable
{
  @Nullable
  public FieldDtoImage defaultImage;

  @Nullable
  public MetaIdField defaultImageFieldId;

  @Nullable
  public MetaIdVar defaultImageVarId;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdField maxSizeFieldId;

  @Nullable
  public MetaIdVar maxSizeVarId;

  @Nullable
  public Boolean showLabel;

  @Nullable
  public MetaIdField showLabelFieldId;

  @Nullable
  public MetaIdVar showLabelVarId;

  @Nullable
  public Boolean showPreview;

  @Nullable
  public MetaIdField showPreviewFieldId;

  @Nullable
  public MetaIdVar showPreviewVarId;

  @Nullable
  public Boolean showSize;

  @Nullable
  public MetaIdField showSizeFieldId;

  @Nullable
  public MetaIdVar showSizeVarId;
}
