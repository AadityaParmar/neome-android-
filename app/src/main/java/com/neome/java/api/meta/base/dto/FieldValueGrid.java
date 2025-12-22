// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.RowId;

import java.util.Map;

@SuppressWarnings("unused")
public class FieldValueGrid
{
  public RowId[] keys;

  public Map<RowId, FieldDtoGridRow> map;
}
