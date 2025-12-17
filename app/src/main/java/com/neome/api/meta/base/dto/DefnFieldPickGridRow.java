// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.dto.DefnStudioDtoCondition;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;

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
