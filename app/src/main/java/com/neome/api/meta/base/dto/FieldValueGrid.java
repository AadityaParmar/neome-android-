// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.RowId;

import java.util.Map;

@SuppressWarnings("unused")
public class FieldValueGrid
{
  public RowId[] keys;

  public Map<RowId, FieldDtoGridRow> map;
}
