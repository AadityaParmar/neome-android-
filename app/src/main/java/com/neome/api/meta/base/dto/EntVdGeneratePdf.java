// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdGeneratePdf extends EntVdAutoStep
{
  @Nullable
  public MetaIdLayoutForm contentLayoutId;

  @Nullable
  public StudioValueText fileName;

  @Nullable
  public StudioDtoArgValueParameter outputField;

  @Nullable
  public MetaIdLayoutForm templateLayoutId;
}
