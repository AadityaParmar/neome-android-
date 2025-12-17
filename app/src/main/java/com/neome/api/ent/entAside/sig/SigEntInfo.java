// neome.ai API - do not change
//

package com.neome.api.ent.entAside.sig;

import com.neome.api.ent.base.dto.DtoEntUserAvatar;
import com.neome.api.meta.base.Types.DemoAppId;
import com.neome.api.meta.base.Types.LanguageKey;
import com.neome.api.meta.base.Types.MediaIdAvatar;
import com.neome.api.meta.base.Types.TimeZoneKey;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigEntInfo extends SigVersion
{
  public String about;

  @Nullable
  public MediaIdAvatar avatarId;

  public DemoAppId demoAppId;

  @Nullable
  public DtoEntUserAvatar[] entUserAvatarList;

  @Nullable
  public LanguageKey[] languageSet;

  public String name;

  public TimeZoneKey timeZone;
}
