// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.sig;

import com.neome.java.api.ent.base.dto.DtoEntUserAvatar;
import com.neome.java.api.meta.base.Types.DemoAppId;
import com.neome.java.api.meta.base.Types.LanguageKey;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.meta.base.Types.TimeZoneKey;
import com.neome.java.api.nucleus.base.sig.SigVersion;

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
