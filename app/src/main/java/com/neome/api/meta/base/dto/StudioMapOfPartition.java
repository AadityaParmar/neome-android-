// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdPartition;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoPartition;

@SuppressWarnings("unused")
public class StudioMapOfPartition extends StudioBase
{
  @Nullable
  public MetaIdPartition[] keys;

  public Map<MetaIdPartition, StudioDtoPartition> map;
}
