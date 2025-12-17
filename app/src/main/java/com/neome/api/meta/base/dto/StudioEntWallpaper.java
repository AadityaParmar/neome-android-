// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MediaIdImage;
import com.neome.api.meta.base.dto.StudioBase;

@SuppressWarnings("unused")
public class StudioEntWallpaper extends StudioBase
{
  @Nullable
  public Boolean repeatTile;

  @Nullable
  public MediaIdImage wallpaperImageId;
}
