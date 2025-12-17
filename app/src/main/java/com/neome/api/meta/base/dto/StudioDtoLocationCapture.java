// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.AnyTime;
import com.neome.api.meta.base.Types.EnumDefnDay;
import com.neome.api.meta.base.Types.EnumDefnLocationCapturingMode;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLocationCapture
{
  @Nullable
  public EnumDefnDay[] excludeDaysSet;

  @Nullable
  public Long frequencyBasedOnDistance;

  @Nullable
  public Long frequencyBasedOnTime;

  @Nullable
  public AnyTime fromTime;

  @Nullable
  public MetaIdRole[] roleIdSet;

  @Nullable
  public AnyTime toTime;

  @Nullable
  public EnumDefnLocationCapturingMode type;
}
