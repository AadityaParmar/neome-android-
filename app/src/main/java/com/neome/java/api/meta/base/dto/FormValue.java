// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MetaIdComp;
import com.neome.java.api.meta.base.Types.RowId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.Map;

@SuppressWarnings("unused")
public class FormValue
{
  @Nullable
  public EntUserId createdBy;

  @Nullable
  public Date createdOn;

  public RowId rowId;

  @Nullable
  public String rowOrder;

  @Nullable
  public EntUserId updatedBy;

  @Nullable
  public Date updatedOn;

  public Map<MetaIdComp, Object> valueMap;
}
