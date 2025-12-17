// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EnumDefnEntStage;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntConfig
{
  @Nullable
  public Boolean allowClearSpreadsheet;

  @Nullable
  public Boolean confirmBeforeDelete;

  @Nullable
  public Boolean hideObsoleteFeatures;

  @Nullable
  public Boolean lockEnterprise;

  @Nullable
  public Boolean showCompletedWorkflows;

  @Nullable
  public EnumDefnEntStage stage;
}
