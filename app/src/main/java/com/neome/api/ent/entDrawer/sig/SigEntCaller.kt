// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.ent.base.dto.DtoEntDeeplink
import com.neome.api.ent.base.dto.DtoEntGroupMap
import com.neome.api.ent.base.dto.DtoEntPrompt
import com.neome.api.ent.base.dto.DtoEntRole
import com.neome.api.ent.base.dto.DtoEntSpreadsheet
import com.neome.api.ent.base.dto.DtoEntWallpaper
import com.neome.api.ent.base.dto.DtoPaymentProvider
import com.neome.api.ent.base.dto.DtoVarUserSetting
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.TimeZoneKey
import com.neome.api.meta.base.Types.UserId
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutUserMap
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import com.neome.api.meta.base.dto.StudioDtoLocationCapture
import com.neome.api.nucleus.base.sig.SigVersion

class SigEntCaller : SigVersion() {
    val actionMap: Record<MetaIdAction, DtoEntAction>
    var avatarId: MediaId? = null
    val color: string
    var deeplinkMap: Record<MetaIdDeeplink, DtoEntDeeplink>? = null
    var displayDateFormat: string? = null
    val entId: EntId
    val entUserId: EntUserId
    val entUserIdHash: string
    val formMap: Record<MetaIdForm, DefnForm>
    var grandManagerId: EntUserId? = null
    val groupIdMapping: Record<MetaIdGroup, GroupId>
    val groupMap: DtoEntGroupMap
    val handle: string
    var languageKey: LanguageKey? = null
    var layoutUserMap: DefnLayoutUserMap? = null
    var layoutUserMenuActionMap: Record<MetaIdAction, DefnStudioDtoActionPermission>? = null
    var locationAccuracy: EnumDefnLocationAccuracy? = null
    var locationConfig: StudioDtoLocationCapture? = null
    var managerId: EntUserId? = null
    var managerialRelationshipMap: Record<MetaIdRole, EntUserId[]>? = null
    val nickName: string
    var paymentProvider: DtoPaymentProvider? = null
    var promptMap: Record<MetaIdPrompt, DtoEntPrompt>? = null
    val roleIdSet: MetaIdRole[]
    val roleMap: Record<MetaIdRole, DtoEntRole>
    var spreadsheetMap: Record<MetaIdSpreadsheet, DtoEntSpreadsheet>? = null
    var timeZone: TimeZoneKey? = null
    val userId: UserId
    var userSettingVarMap: Record<MetaIdVar, DtoVarUserSetting>? = null
    var wallpaper: DtoEntWallpaper? = null
}
