// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVdErdDia;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdErdDiaMap extends StudioBase
{
  public MetaIdVdErdDia[] keys;

  public Map<MetaIdVdErdDia, EntVdErdDia> map;
}
