// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.dto.StudioBase;

@SuppressWarnings("unused")
public class StudioBuildRepeatSetting extends StudioBase
{
  @Nullable
  public Date endDateTime;

  @Nullable
  public MetaIdVar excludeSetOfDateVarId;

  @Nullable
  public Long frequency;

  public EnumDefnRepeatFrequencyKind repeatFrequencyKind;
}
