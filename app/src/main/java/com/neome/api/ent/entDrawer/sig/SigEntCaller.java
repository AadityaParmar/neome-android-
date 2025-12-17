// neome.ai API - do not change
//

package com.neome.api.ent.entDrawer.sig;

import com.neome.api.ent.base.dto.DtoEntAction;
import com.neome.api.ent.base.dto.DtoEntDeeplink;
import com.neome.api.ent.base.dto.DtoEntGroupMap;
import com.neome.api.ent.base.dto.DtoEntPrompt;
import com.neome.api.ent.base.dto.DtoEntRole;
import com.neome.api.ent.base.dto.DtoEntSpreadsheet;
import com.neome.api.ent.base.dto.DtoEntWallpaper;
import com.neome.api.ent.base.dto.DtoPaymentProvider;
import com.neome.api.ent.base.dto.DtoVarUserSetting;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy;
import com.neome.api.meta.base.Types.GroupId;
import com.neome.api.meta.base.Types.LanguageKey;
import com.neome.api.meta.base.Types.MediaId;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdDeeplink;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdPrompt;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.meta.base.Types.TimeZoneKey;
import com.neome.api.meta.base.Types.UserId;
import com.neome.api.meta.base.dto.DefnForm;
import com.neome.api.meta.base.dto.DefnLayoutUserMap;
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission;
import com.neome.api.meta.base.dto.StudioDtoLocationCapture;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class SigEntCaller extends SigVersion
{
  public Map<MetaIdAction, DtoEntAction> actionMap;

  @Nullable
  public MediaId avatarId;

  public String color;

  @Nullable
  public Map<MetaIdDeeplink, DtoEntDeeplink> deeplinkMap;

  @Nullable
  public String displayDateFormat;

  public EntId entId;

  public EntUserId entUserId;

  public String entUserIdHash;

  public Map<MetaIdForm, DefnForm> formMap;

  @Nullable
  public EntUserId grandManagerId;

  public Map<MetaIdGroup, GroupId> groupIdMapping;

  public DtoEntGroupMap groupMap;

  public String handle;

  @Nullable
  public LanguageKey languageKey;

  @Nullable
  public DefnLayoutUserMap layoutUserMap;

  @Nullable
  public Map<MetaIdAction, DefnStudioDtoActionPermission> layoutUserMenuActionMap;

  @Nullable
  public EnumDefnLocationAccuracy locationAccuracy;

  @Nullable
  public StudioDtoLocationCapture locationConfig;

  @Nullable
  public EntUserId managerId;

  @Nullable
  public Map<MetaIdRole, Set<EntUserId>> managerialRelationshipMap;

  public String nickName;

  @Nullable
  public DtoPaymentProvider paymentProvider;

  @Nullable
  public Map<MetaIdPrompt, DtoEntPrompt> promptMap;

  public Set<MetaIdRole> roleIdSet;

  public Map<MetaIdRole, DtoEntRole> roleMap;

  @Nullable
  public Map<MetaIdSpreadsheet, DtoEntSpreadsheet> spreadsheetMap;

  @Nullable
  public TimeZoneKey timeZone;

  public UserId userId;

  @Nullable
  public Map<MetaIdVar, DtoVarUserSetting> userSettingVarMap;

  @Nullable
  public DtoEntWallpaper wallpaper;
}
