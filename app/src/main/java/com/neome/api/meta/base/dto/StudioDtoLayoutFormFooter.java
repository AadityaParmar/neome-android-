// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormFooter extends StudioBase
{
  @Nullable
  public FieldDtoImage footerImage;

  @Nullable
  public Long footerImageHeight;

  @Nullable
  public MetaIdVar footerImageVarId;

  @Nullable
  public MetaIdLayoutForm formLayoutId;

  @Nullable
  public Boolean showSeparator;
}
