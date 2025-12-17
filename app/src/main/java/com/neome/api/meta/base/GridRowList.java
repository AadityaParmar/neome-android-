// neome.ai API - do not change
//

package com.neome.api.meta.base;

import com.neome.api.meta.base.Types.RowId;

import java.util.Map;

public class GridRowList<T>
{

  public static final String KEY_KEYS = "keys";

  public static final String KEY_MAP = "map";

  public RowId[] keys;

  public Map<RowId, T> map;
}
