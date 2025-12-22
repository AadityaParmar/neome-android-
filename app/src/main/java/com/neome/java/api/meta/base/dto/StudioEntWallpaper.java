// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MediaIdImage;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntWallpaper extends StudioBase
{
  @Nullable
  public Boolean repeatTile;

  @Nullable
  public MediaIdImage wallpaperImageId;
}
