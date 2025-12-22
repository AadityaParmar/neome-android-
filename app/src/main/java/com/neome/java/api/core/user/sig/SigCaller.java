// neome.ai API - do not change
//

package com.neome.java.api.core.user.sig;

import com.neome.java.api.core.base.dto.DtoEntChatNotificationSetting;
import com.neome.java.api.core.base.dto.DtoNotificationSetting;
import com.neome.java.api.meta.base.Types.AdminId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.GroupId;
import com.neome.java.api.meta.base.Types.LanguageKey;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.meta.base.Types.PluginBundleId;
import com.neome.java.api.meta.base.Types.StoreItemId;
import com.neome.java.api.meta.base.Types.UserId;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class SigCaller extends SigVersion
{
  @Nullable
  public String about;

  @Nullable
  public Boolean allowCluster;

  @Nullable
  public Boolean allowStorePublish;

  @Nullable
  public Boolean allowStudio;

  @Nullable
  public Map<EntId, DtoEntChatNotificationSetting> chatNotificationSettingMap;

  public Date creationTime;

  public Map<EntId, AdminId> entAdminIdMap;

  public Map<EntId, EntUserId> entUserIdMap;

  @Nullable
  public Boolean enterIsSendDesktop;

  @Nullable
  public Boolean enterIsSendMobile;

  @Nullable
  public String firstName;

  @Nullable
  public Boolean fromCache;

  @Nullable
  public DtoNotificationSetting globalNotificationSetting;

  public Set<GroupId> groupIdSet;

  @Nullable
  public String handle;

  @Nullable
  public LanguageKey languageKey;

  @Nullable
  public String lastName;

  public Date lastUpdate;

  @Nullable
  public MediaIdAvatar mediaIdAvatar;

  public Map<PluginBundleId, AdminId> pluginAdminIdMap;

  @Nullable
  public Boolean resetPassword;

  public Map<StoreItemId, AdminId> storeItemAdminIdMap;

  @Nullable
  public Boolean updateProfile;

  public UserId userId;

  public String userIdHash;
}
