// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy;
import com.neome.api.meta.base.Types.EnumDefnStoreItem;
import com.neome.api.meta.base.Types.EnumStoreLabel;
import com.neome.api.meta.base.Types.LanguageKey;
import com.neome.api.meta.base.Types.MediaIdAvatar;
import com.neome.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDetails extends StudioBase
{
  @Nullable
  public String about;

  @Nullable
  public MediaIdAvatar avatarId;

  @Nullable
  public String displayDateFormat;

  @Nullable
  public Boolean hideAddressBook;

  @Nullable
  public LanguageKey[] languageSet;

  @Nullable
  public EnumDefnLocationAccuracy locationAccuracy;

  public String name;

  @Nullable
  public String storeAbout;

  @Nullable
  public EnumDefnStoreItem storeItemType;

  @Nullable
  public EnumStoreLabel[] storeLabelSet;

  @Nullable
  public TimeZoneKey timeZone;

  @Nullable
  public StudioEntWallpaper wallpaper;
}
