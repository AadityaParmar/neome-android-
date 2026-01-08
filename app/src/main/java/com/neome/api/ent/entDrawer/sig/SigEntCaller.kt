// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutUserMap
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
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
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.dto.StudioDtoLocationCapture
import com.neome.api.meta.base.Types.TimeZoneKey
import com.neome.api.meta.base.Types.UserId

interface SigEntCaller : SigVersion
{
  val actionMap: Map<MetaIdAction, DtoEntAction>
  val avatarId: MediaId?
  val color: String
  val deeplinkMap: Map<MetaIdDeeplink, DtoEntDeeplink>?
  val displayDateFormat: String?
  val entId: EntId
  val entUserId: EntUserId
  val entUserIdHash: String
  val formMap: Map<MetaIdForm, DefnForm>
  val grandManagerId: EntUserId?
  val groupIdMapping: Map<MetaIdGroup, GroupId>
  val groupMap: DtoEntGroupMap
  val handle: String
  val languageKey: LanguageKey?
  val layoutUserMap: DefnLayoutUserMap?
  val layoutUserMenuActionMap: Map<MetaIdAction, DefnStudioDtoActionPermission>?
  val locationAccuracy: EnumDefnLocationAccuracy?
  val locationConfig: StudioDtoLocationCapture?
  val managerId: EntUserId?
  val managerialRelationshipMap: Map<MetaIdRole, Array<EntUserId>>?
  val nickName: String
  val paymentProvider: DtoPaymentProvider?
  val promptMap: Map<MetaIdPrompt, DtoEntPrompt>?
  val roleIdSet: Array<MetaIdRole>
  val roleMap: Map<MetaIdRole, DtoEntRole>
  val spreadsheetMap: Map<MetaIdSpreadsheet, DtoEntSpreadsheet>?
  val timeZone: TimeZoneKey?
  val userId: UserId
  val userSettingVarMap: Map<MetaIdVar, DtoVarUserSetting>?
  val wallpaper: DtoEntWallpaper?
}