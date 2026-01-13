package com.neome.core.common.serializer.api.ent.entDrawer.sig

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.ent.base.dto.DtoEntGroupMap
import com.neome.api.ent.base.dto.DtoEntPrompt
import com.neome.api.ent.base.dto.DtoEntRole
import com.neome.api.ent.base.dto.DtoEntSpreadsheet
import com.neome.api.ent.base.dto.DtoEntWallpaper
import com.neome.api.ent.base.dto.DtoPaymentProvider
import com.neome.api.ent.base.dto.DtoVarUserSetting
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutUserMap
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import com.neome.api.meta.base.dto.StudioDtoLocationCapture
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntActionSeal
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntDeeplinkData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntGroupMapData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntPromptData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntRoleData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntSpreadsheetData
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntWallpaperData
import com.neome.core.common.serializer.api.ent.base.dto.DtoPaymentProviderData
import com.neome.core.common.serializer.api.ent.base.dto.DtoVarUserSettingData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutUserMapData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioDtoActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLocationCaptureData
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.LanguageKeySer
import com.neome.core.common.serializer.sysId.MediaIdSer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdPromptSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import com.neome.core.common.serializer.sysId.UserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntCallerData(
    override val version: String,
    override val actionMap: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, DtoEntActionSeal>,
    @Serializable(with = MediaIdSer::class) override val avatarId: Types.MediaId? = null,
    override val color: String,
    override val deeplinkMap: Map<@Serializable(with = MetaIdDeeplinkSer::class) Types.MetaIdDeeplink, DtoEntDeeplinkData>? = null,
    override val displayDateFormat: String? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val entUserIdHash: String,
    override val formMap: Map<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm, DefnFormData>,
    @Serializable(with = EntUserIdSer::class) override val grandManagerId: Types.EntUserId? = null,
    override val groupIdMapping: Map<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup, @Serializable(with = GroupIdSer::class) Types.GroupId>,
    override val groupMap: DtoEntGroupMapData,
    override val handle: String,
    @Serializable(with = LanguageKeySer::class) override val languageKey: Types.LanguageKey? = null,
    override val layoutUserMap: DefnLayoutUserMapData? = null,
    override val layoutUserMenuActionMap: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, DefnStudioDtoActionPermissionData>? = null,
    override val locationAccuracy: EnumDefnLocationAccuracy? = null,
    override val locationConfig: StudioDtoLocationCaptureData? = null,
    @Serializable(with = EntUserIdSer::class) override val managerId: Types.EntUserId? = null,
    override val managerialRelationshipMap: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, List<@Serializable(with = EntUserIdSer::class) Types.EntUserId>>? = null,
    override val nickName: String,
    override val paymentProvider: DtoPaymentProviderData? = null,
    override val promptMap: Map<@Serializable(with = MetaIdPromptSer::class) Types.MetaIdPrompt, DtoEntPromptData>? = null,
    override val roleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>,
    override val roleMap: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, DtoEntRoleData>,
    override val spreadsheetMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, DtoEntSpreadsheetData>? = null,
    @Serializable(with = TimeZoneKeySer::class) override val timeZone: Types.TimeZoneKey? = null,
    @Serializable(with = UserIdSer::class) override val userId: Types.UserId,
    override val userSettingVarMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, DtoVarUserSettingData>? = null,
    override val wallpaper: DtoEntWallpaperData? = null
) : SigEntCaller
