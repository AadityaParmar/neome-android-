// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

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
