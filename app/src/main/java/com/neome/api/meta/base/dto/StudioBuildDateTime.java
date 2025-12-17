// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.AnyTime;
import com.neome.api.meta.base.dto.StudioBuildDate;

@SuppressWarnings("unused")
public class StudioBuildDateTime extends StudioBuildDate
{
  @Nullable
  public AnyTime time;
}
