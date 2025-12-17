// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdMapping;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioDtoMappingFieldMapBase extends StudioBase
{
  public MetaIdMapping[] keys;

  public Map<MetaIdMapping, StudioDtoMappingField> map;
}
