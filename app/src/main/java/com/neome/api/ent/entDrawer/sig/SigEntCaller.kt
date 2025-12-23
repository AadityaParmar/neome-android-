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
import java.util.Map

open class SigEntCaller : SigVersion() {
    lateinit var actionMap: Map<MetaIdAction, DtoEntAction>
    var avatarId: MediaId? = null
    lateinit var color: String
    var deeplinkMap: Map<MetaIdDeeplink, DtoEntDeeplink>? = null
    var displayDateFormat: String? = null
    lateinit var entId: EntId
    lateinit var entUserId: EntUserId
    lateinit var entUserIdHash: String
    lateinit var formMap: Map<MetaIdForm, DefnForm>
    var grandManagerId: EntUserId? = null
    lateinit var groupIdMapping: Map<MetaIdGroup, GroupId>
    lateinit var groupMap: DtoEntGroupMap
    lateinit var handle: String
    var languageKey: LanguageKey? = null
    var layoutUserMap: DefnLayoutUserMap? = null
    var layoutUserMenuActionMap: Map<MetaIdAction, DefnStudioDtoActionPermission>? = null
    var locationAccuracy: EnumDefnLocationAccuracy? = null
    var locationConfig: StudioDtoLocationCapture? = null
    var managerId: EntUserId? = null
    var managerialRelationshipMap: Map<MetaIdRole, Array<EntUserId>>? = null
    lateinit var nickName: String
    var paymentProvider: DtoPaymentProvider? = null
    var promptMap: Map<MetaIdPrompt, DtoEntPrompt>? = null
    lateinit var roleIdSet: Array<MetaIdRole>
    lateinit var roleMap: Map<MetaIdRole, DtoEntRole>
    var spreadsheetMap: Map<MetaIdSpreadsheet, DtoEntSpreadsheet>? = null
    var timeZone: TimeZoneKey? = null
    lateinit var userId: UserId
    var userSettingVarMap: Map<MetaIdVar, DtoVarUserSetting>? = null
    var wallpaper: DtoEntWallpaper? = null
}
