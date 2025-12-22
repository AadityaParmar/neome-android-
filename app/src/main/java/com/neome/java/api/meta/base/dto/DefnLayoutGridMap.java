// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnLayoutGridMap
{
  @Nullable
  public MetaIdLayoutGrid asideDefaultLayoutId;

  public MetaIdLayoutGrid[] keys;

  public Map<MetaIdLayoutGrid, DefnLayoutGrid> map;

  @Nullable
  public DefnDtoPlaceholder placeholder;

  @Nullable
  public EnumDefnShowBorderKind[] showBorderSet;
}
