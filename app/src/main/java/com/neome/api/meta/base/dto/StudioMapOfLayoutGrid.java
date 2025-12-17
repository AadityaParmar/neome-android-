// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid;
import com.neome.api.meta.base.dto.StudioDtoPlaceHolder;

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
