// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnAudioFormat;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldAudio extends DefnFieldEditable
{
  @Nullable
  public EnumDefnAudioFormat audioFormatType;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdField maxSizeFieldId;

  @Nullable
  public Long maxSizeVar;
}
