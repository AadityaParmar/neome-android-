// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnDtoPluginApi;
import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.dto.FieldDtoTree;
import com.neome.api.meta.base.Types.MetaIdField;

@SuppressWarnings("unused")
public class DefnFieldPickTree extends DefnFieldEditable
{
  @Nullable
  public Boolean autoPickSingleChild;

  @Nullable
  public MetaIdField defaultOptionFieldId;

  @Nullable
  public String defaultOptionId;

  @Nullable
  public Boolean forceLeafSelection;

  @Nullable
  public Boolean includeAllChildrenInReport;

  @Nullable
  public DefnDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public FieldDtoTree sourceVar;
}
