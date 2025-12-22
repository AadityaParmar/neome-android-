// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnFieldPickGridRow extends DefnFieldEditable
{
  @Nullable
  public Map<MetaIdField, MetaIdField> copyFieldMap;

  @Nullable
  public MetaIdField[] editableFieldIdSet;

  @Nullable
  public DefnStudioDtoCondition filterConditionVar;

  public MetaIdField gridDisplayFieldId;

  public MetaIdGrid gridId;

  @Nullable
  public MetaIdLayoutGrid gridLayoutId;

  @Nullable
  public Boolean showAsDropdown;
}
