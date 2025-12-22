// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioPluginRpc extends StudioBase
{
  public Date lastUpdateTime;

  @Nullable
  public MetaIdForm pluginConfigFormId;
}
