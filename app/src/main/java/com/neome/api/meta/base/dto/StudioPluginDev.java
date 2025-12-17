// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioPluginDev extends StudioBase
{
  public Date lastUpdateTime;

  @Nullable
  public MetaIdVar packageNameVarId;

  @Nullable
  public MetaIdForm pluginConfigFormId;
}
