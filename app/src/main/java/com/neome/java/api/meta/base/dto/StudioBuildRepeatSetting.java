// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnRepeatFrequencyKind;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

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
