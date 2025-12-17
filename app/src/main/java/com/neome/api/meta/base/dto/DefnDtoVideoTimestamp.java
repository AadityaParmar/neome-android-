// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVideoTimestamp;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoVideoTimestamp
{
  @Nullable
  public MetaIdVideoTimestamp metaId;

  @Nullable
  public Long startTimeMinutes;

  @Nullable
  public Long startTimeSeconds;

  @Nullable
  public String style;

  @Nullable
  public String title;
}
