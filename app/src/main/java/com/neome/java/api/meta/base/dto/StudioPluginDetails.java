// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumStoreLabel;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioPluginDetails extends StudioBase
{
  @Nullable
  public String about;

  @Nullable
  public MediaIdAvatar avatarId;

  public String name;

  @Nullable
  public String storeAbout;

  @Nullable
  public EnumStoreLabel[] storeLabelSet;
}
