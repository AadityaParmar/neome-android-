// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldPickTree extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultOptionFieldId;

  @Nullable
  public String defaultOptionId;

  @Nullable
  public Boolean forceLeafSelection;

  @Nullable
  public Boolean includeAllChildrenInReport;

  @Nullable
  public StudioDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public MetaIdVar pluginInputMappingVarId;

  @Nullable
  public MetaIdVar sourceVarId;
}
