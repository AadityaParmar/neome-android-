// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AdminId;
import com.neome.java.api.meta.base.Types.PluginBundleId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioPluginBundleBase extends StudioBase
{
  public AdminId createdBy;

  public Date creationTime;

  @Nullable
  public StudioPluginMap deployMap;

  public PluginBundleId pluginBundleId;

  public AdminId updateBy;

  public Date updateTime;

  public String version;
}
