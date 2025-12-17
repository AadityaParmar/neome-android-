// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdPlugin;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.Types.PluginApiId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepCallPlugin extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdField errorFieldId;

  @Nullable
  public MetaIdVar errorRetryCountVarId;

  @Nullable
  public MetaIdVar errorRetryDurationVarId;

  @Nullable
  public Boolean exposeOutputAsPipelineVariable;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public MetaIdVar pluginInputMappingVarId;

  @Nullable
  public MetaIdVar pluginOutputMappingVarId;

  @Nullable
  public PluginApiId targetPluginApiId;

  @Nullable
  public MetaIdPlugin targetPluginId;
}
