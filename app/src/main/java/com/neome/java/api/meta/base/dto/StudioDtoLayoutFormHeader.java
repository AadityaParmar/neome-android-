// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormHeader extends StudioBase
{
  @Nullable
  public StudioDtoColor backgroundColor;

  @Nullable
  public MetaIdVar backgroundColorVarId;

  @Nullable
  public MetaIdLayoutForm formLayoutId;

  @Nullable
  public FieldDtoImage headerImage;

  @Nullable
  public Long headerImageHeight;

  @Nullable
  public MetaIdVar headerImageVarId;

  @Nullable
  public MetaIdVar[] hyperlinkVarIdSet;

  @Nullable
  public Boolean showEnterprise;

  @Nullable
  public Boolean showSeparator;

  @Nullable
  public StudioDtoColor textColor;

  @Nullable
  public MetaIdVar textColorVarId;
}
