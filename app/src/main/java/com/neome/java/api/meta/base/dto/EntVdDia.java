// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdModule;
import com.neome.java.api.meta.base.Types.MetaIdVdNote;
import com.neome.java.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdDia extends StudioBase
{
  @Nullable
  public Boolean isDefault;

  @Nullable
  public MetaIdModule moduleId;

  public Map<MetaIdVdNote, EntVdNote> noteMap;

  public Map<MetaIdVdRegion, EntVdRegion> regionMap;

  @Nullable
  public EntVdViewport viewport;
}
