// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdFormula;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfFormula extends StudioBase
{
  @Nullable
  public MetaIdFormula[] keys;

  public Map<MetaIdFormula, StudioDtoFormula> map;
}
