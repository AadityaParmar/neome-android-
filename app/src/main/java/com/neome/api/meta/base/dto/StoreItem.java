// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.AdminId;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EnumStoreItemArtifact;
import com.neome.api.meta.base.Types.StoreItemId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StoreItem extends StudioBase
{
  public EnumStoreItemArtifact artifactKind;

  @Nullable
  public AdminId createdBy;

  @Nullable
  public Date createdOn;

  @Nullable
  public StudioPluginBundle pluginBundle;

  @Nullable
  public EntId seedEntId;

  public StoreItemId storeItemId;

  @Nullable
  public StudioEnt studioEnt;

  @Nullable
  public AdminId updatedBy;

  @Nullable
  public Date updatedOn;
}
