// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfLayoutGrid extends StudioBase
{
  @Nullable
  public MetaIdLayoutGrid asideDefaultLayoutId;

  public MetaIdLayoutGrid[] keys;

  public Map<MetaIdLayoutGrid, StudioDtoLayoutGrid> map;

  @Nullable
  public StudioDtoPlaceHolder placeholder;

  @Nullable
  public EnumDefnShowBorderKind[] showBorderSet;
}
