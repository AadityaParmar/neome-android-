// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPartition;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfPartition extends StudioBase
{
  @Nullable
  public MetaIdPartition[] keys;

  public Map<MetaIdPartition, StudioDtoPartition> map;
}
