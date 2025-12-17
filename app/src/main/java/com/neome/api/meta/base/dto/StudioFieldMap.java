// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioFieldMap extends StudioBase
{
  public MetaIdField[] keys;

  public Map<MetaIdField, StudioField> map;
}
