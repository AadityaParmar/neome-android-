// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.studio.studioMain.msg.MsgAdminId
import com.neome.api.studio.studioMain.msg.MsgAdminInvite
import com.neome.api.studio.studioMain.msg.MsgAnalyticDashboardStateGet
import com.neome.api.studio.studioMain.msg.MsgAnalyticEventCount
import com.neome.api.studio.studioMain.msg.MsgAnalyticEventData
import com.neome.api.studio.studioMain.msg.MsgClusterAnalyticData
import com.neome.api.studio.studioMain.msg.MsgClusterAnalyticEventCount
import com.neome.api.studio.studioMain.msg.MsgClusterAnalyticEventData
import com.neome.api.studio.studioMain.msg.MsgClusterEntUserCountGet
import com.neome.api.studio.studioMain.msg.MsgEntAdminAdd
import com.neome.api.studio.studioMain.msg.MsgEntAdminInviteDeeplinkGet
import com.neome.api.studio.studioMain.msg.MsgEntAdminUpdate
import com.neome.api.studio.studioMain.msg.MsgEntConfigUpdate
import com.neome.api.studio.studioMain.msg.MsgEntDemoApp
import com.neome.api.studio.studioMain.msg.MsgEntPaymentMapUpdate
import com.neome.api.studio.studioMain.msg.MsgEntPluginMapUpdate
import com.neome.api.studio.studioMain.msg.MsgEntSnapshot
import com.neome.api.studio.studioMain.msg.MsgEntSnapshotId
import com.neome.api.studio.studioMain.msg.MsgEntUserAdd
import com.neome.api.studio.studioMain.msg.MsgEntUserBulkImport
import com.neome.api.studio.studioMain.msg.MsgEntUserDeeplinkGet
import com.neome.api.studio.studioMain.msg.MsgEntUserGet
import com.neome.api.core.base.msg.MsgEntUserIdNoVersion
import com.neome.api.core.base.msg.MsgEntUserIdSet
import com.neome.api.studio.studioMain.msg.MsgEntUserInvite
import com.neome.api.studio.studioMain.msg.MsgEntUserListGet
import com.neome.api.studio.studioMain.msg.MsgEntUserUpdate
import com.neome.api.studio.studioMain.msg.MsgFormFieldTypeUpdate
import com.neome.api.studio.studioMain.msg.MsgFormId
import com.neome.api.studio.studioMain.msg.MsgKeychainCreate
import com.neome.api.studio.studioMain.msg.MsgKeychainPut
import com.neome.api.studio.studioMain.msg.MsgKeychainRemove
import com.neome.api.studio.studioMain.msg.MsgNeoQLResult
import com.neome.api.studio.studioMain.msg.MsgPluginAdminAdd
import com.neome.api.studio.studioMain.msg.MsgPluginAdminUpdate
import com.neome.api.studio.studioMain.msg.MsgPluginApiSpecGet
import com.neome.api.studio.studioMain.msg.MsgPluginId
import com.neome.api.studio.studioMain.msg.MsgScheduleNextExecutionList
import com.neome.api.studio.studioMain.msg.MsgStudioEnt
import com.neome.api.studio.studioMain.msg.MsgStudioPlugin
import com.neome.api.studio.studioMain.msg.MsgStudioSearchUsages
import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.studio.studioMain.msg.MsgWebhookCodeGet
import com.neome.api.studio.studioMain.msg.MsgWorkflowDebugBreakpointMap
import com.neome.api.studio.studioMain.msg.MsgWorkflowNodeFavoritesPut
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.studio.studioMain.sig.SigAdminEditLockDetail
import com.neome.api.studio.studioMain.sig.SigAnalyticData
import com.neome.api.studio.studioMain.sig.SigAnalyticEventCount
import com.neome.api.studio.studioMain.sig.SigAnalyticEventData
import com.neome.api.studio.studioMain.sig.SigAnalyticsDashboardStateGet
import com.neome.api.studio.studioMain.sig.SigDefnForm
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.studio.studioMain.sig.SigEntAdminCaller
import com.neome.api.studio.studioMain.sig.SigEntAdminList
import com.neome.api.studio.studioMain.sig.SigEntDemoApp
import com.neome.api.studio.studioMain.sig.SigEntDeployStatus
import com.neome.api.studio.studioMain.sig.SigEntPaymentMap
import com.neome.api.studio.studioMain.sig.SigEntPluginMap
import com.neome.api.studio.studioMain.sig.SigEntSnapshot
import com.neome.api.studio.studioMain.sig.SigEntSnapshotAvatarList
import com.neome.api.studio.studioMain.sig.SigEntUser
import com.neome.api.studio.studioMain.sig.SigEntUserBulkImport
import com.neome.api.studio.studioMain.sig.SigEntUserCount
import com.neome.api.studio.studioMain.sig.SigEntUserDeviceList
import com.neome.api.studio.studioMain.sig.SigEntUserList
import com.neome.api.studio.studioMain.sig.SigKeychainMap
import com.neome.api.studio.studioMain.sig.SigKeychainSecretKey
import com.neome.api.studio.studioEnt.sig.SigMediaIdDocument
import com.neome.api.studio.studioMain.sig.SigNeoQLResult
import com.neome.api.studio.studioMain.sig.SigPluginAdminCaller
import com.neome.api.studio.studioMain.sig.SigPluginAdminList
import com.neome.api.studio.studioMain.sig.SigPluginApiSpec
import com.neome.api.studio.studioMain.sig.SigScheduleNextExecutionList
import com.neome.api.studio.studioMain.sig.SigStudioEntConfig
import com.neome.api.studio.studioMain.sig.SigStudioPluginMap
import com.neome.api.studio.studioMain.sig.SigStudioSearchUsages
import com.neome.api.studio.studioMain.sig.SigSysDefnFormMapGet
import com.neome.api.core.deeplink.sig.SigUrlPassword
import com.neome.api.studio.studioMain.sig.SigWebhookId
import com.neome.api.studio.studioMain.sig.SigWhatsAppTemplateGroupMap
import com.neome.api.studio.studioMain.sig.SigWorkflowDebugConfig
import com.neome.api.studio.studioMain.sig.SigWorkflowNodeFavorites

class RpcStudioMain {
    companion object {
        val SN: ServiceName = ServiceName.studioMain

        fun analyticDashboardStateGet(
            msg: MsgAnalyticDashboardStateGet,
            sigAcceptor: ISigAcceptor<SigAnalyticsDashboardStateGet>
        ) {
            CallFactory.rpc.create(
                SigAnalyticsDashboardStateGet::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "analyticDashboardStateGet"
            )
                .get(msg, sigAcceptor)
        }

        fun analyticEventCountGet(
            entId: EntId,
            msg: MsgAnalyticEventCount,
            sigAcceptor: ISigAcceptor<SigAnalyticEventCount>
        ) {
            CallFactory.rpc.create(
                SigAnalyticEventCount::class.java,
                entId,
                SN,
                "analyticEventCountGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun analyticEventDataGet(
            entId: EntId,
            msg: MsgAnalyticEventData,
            sigAcceptor: ISigAcceptor<SigAnalyticEventData>
        ) {
            CallFactory.rpc.create(
                SigAnalyticEventData::class.java,
                entId,
                SN,
                "analyticEventDataGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun clusterAnalyticDataGet(
            msg: MsgClusterAnalyticData,
            sigAcceptor: ISigAcceptor<SigAnalyticData>
        ) {
            CallFactory.rpc.create(
                SigAnalyticData::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "clusterAnalyticDataGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun clusterAnalyticEventCountGet(
            msg: MsgClusterAnalyticEventCount,
            sigAcceptor: ISigAcceptor<SigAnalyticEventCount>
        ) {
            CallFactory.rpc.create(
                SigAnalyticEventCount::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "clusterAnalyticEventCountGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun clusterAnalyticEventDataGet(
            msg: MsgClusterAnalyticEventData,
            sigAcceptor: ISigAcceptor<SigAnalyticEventData>
        ) {
            CallFactory.rpc.create(
                SigAnalyticEventData::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "clusterAnalyticEventDataGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun clusterEntUserCountGet(
            msg: MsgClusterEntUserCountGet,
            sigAcceptor: ISigAcceptor<SigEntUserCount>
        ) {
            CallFactory.rpc.create(
                SigEntUserCount::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "clusterEntUserCountGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun defnFormGet(entId: EntId, msg: MsgFormId, sigAcceptor: ISigAcceptor<SigDefnForm>) {
            CallFactory.rpc.create(SigDefnForm::class.java, entId, SN, "defnFormGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entAdminAdd(entId: EntId, msg: MsgEntAdminAdd, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAdminAdd")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entAdminCallerGet(entId: EntId, sigAcceptor: ISigAcceptor<SigEntAdminCaller>) {
            CallFactory.rpc.create(SigEntAdminCaller::class.java, entId, SN, "entAdminCallerGet")
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun entAdminEditLockDetailGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigAdminEditLockDetail>
        ) {
            CallFactory.rpc.create(
                SigAdminEditLockDetail::class.java,
                entId,
                SN,
                "entAdminEditLockDetailGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entAdminEditLockTransfer(
            entId: EntId,
            msg: MsgAdminId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAdminEditLockTransfer")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entAdminExit(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAdminExit")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun entAdminInvite(entId: EntId, msg: MsgAdminInvite, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAdminInvite")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entAdminInviteDeeplinkGet(
            entId: EntId,
            msg: MsgEntAdminInviteDeeplinkGet,
            sigAcceptor: ISigAcceptor<SigUrlPassword>
        ) {
            CallFactory.rpc.create(
                SigUrlPassword::class.java,
                entId,
                SN,
                "entAdminInviteDeeplinkGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entAdminListGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigEntAdminList>
        ) {
            CallFactory.rpc.create(SigEntAdminList::class.java, entId, SN, "entAdminListGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entAdminRemove(entId: EntId, msg: MsgAdminId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAdminRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun entAdminUpdate(
            entId: EntId,
            msg: MsgEntAdminUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entAdminUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entDemoAppGet(entId: EntId, sigAcceptor: ISigAcceptor<SigEntDemoApp>) {
            CallFactory.rpc.create(SigEntDemoApp::class.java, entId, SN, "entDemoAppGet")
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun entDemoAppPut(entId: EntId, msg: MsgEntDemoApp, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entDemoAppPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entDemoAppRemove(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entDemoAppRemove")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun entFormFieldTypeUpdate(
            entId: EntId,
            msg: MsgFormFieldTypeUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entFormFieldTypeUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entPaymentMapGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigEntPaymentMap>
        ) {
            CallFactory.rpc.create(SigEntPaymentMap::class.java, entId, SN, "entPaymentMapGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entPaymentMapUpdate(
            entId: EntId,
            msg: MsgEntPaymentMapUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entPaymentMapUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entPluginMapGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigEntPluginMap>
        ) {
            CallFactory.rpc.create(SigEntPluginMap::class.java, entId, SN, "entPluginMapGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entPluginMapUpdate(
            entId: EntId,
            msg: MsgEntPluginMapUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entPluginMapUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entScheduleNextExecutionListGet(
            entId: EntId,
            msg: MsgScheduleNextExecutionList,
            sigAcceptor: ISigAcceptor<SigScheduleNextExecutionList>
        ) {
            CallFactory.rpc.create(
                SigScheduleNextExecutionList::class.java,
                entId,
                SN,
                "entScheduleNextExecutionListGet"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entSnapshotGet(
            entId: EntId,
            msg: MsgEntSnapshotId,
            sigAcceptor: ISigAcceptor<SigEntSnapshot>
        ) {
            CallFactory.rpc.create(SigEntSnapshot::class.java, entId, SN, "entSnapshotGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entSnapshotListGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigEntSnapshotAvatarList>
        ) {
            CallFactory.rpc.create(
                SigEntSnapshotAvatarList::class.java,
                entId,
                SN,
                "entSnapshotListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entSnapshotPut(entId: EntId, msg: MsgEntSnapshot, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entSnapshotPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entSnapshotRemove(
            entId: EntId,
            msg: MsgEntSnapshotId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entSnapshotRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun entUserActivate(
            entId: EntId,
            msg: MsgEntUserIdNoVersion,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserActivate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entUserAdd(entId: EntId, msg: MsgEntUserAdd, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserAdd")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entUserBulkImport(
            entId: EntId,
            msg: MsgEntUserBulkImport,
            sigAcceptor: ISigAcceptor<SigEntUserBulkImport>
        ) {
            CallFactory.rpc.create(SigEntUserBulkImport::class.java, entId, SN, "entUserBulkImport")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entUserCountGet(entId: EntId, sigAcceptor: ISigAcceptor<SigEntUserCount>) {
            CallFactory.rpc.create(SigEntUserCount::class.java, entId, SN, "entUserCountGet")
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun entUserDeactivate(
            entId: EntId,
            msg: MsgEntUserIdSet,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserDeactivate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entUserDeviceListGet(
            entId: EntId,
            msg: MsgEntUserIdNoVersion,
            sigAcceptor: ISigAcceptor<SigEntUserDeviceList>
        ) {
            CallFactory.rpc.create(
                SigEntUserDeviceList::class.java,
                entId,
                SN,
                "entUserDeviceListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entUserExit(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserExit")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun entUserGet(msg: MsgEntUserGet, sigAcceptor: ISigAcceptor<SigEntUser>) {
            CallFactory.rpc.create(SigEntUser::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "entUserGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entUserInvite(entId: EntId, msg: MsgEntUserInvite, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserInvite")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun entUserInviteDeeplinkGet(
            entId: EntId,
            msg: MsgEntUserDeeplinkGet,
            sigAcceptor: ISigAcceptor<SigUrlPassword>
        ) {
            CallFactory.rpc.create(
                SigUrlPassword::class.java,
                entId,
                SN,
                "entUserInviteDeeplinkGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entUserListGet(
            entId: EntId,
            msg: MsgEntUserListGet,
            sigAcceptor: ISigAcceptor<SigEntUserList>
        ) {
            CallFactory.rpc.create(SigEntUserList::class.java, entId, SN, "entUserListGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun entUserRemove(
            entId: EntId,
            msg: MsgEntUserIdNoVersion,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun entUserUpdate(entId: EntId, msg: MsgEntUserUpdate, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "entUserUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun entWebhookCodeGet(
            entId: EntId,
            msg: MsgWebhookCodeGet,
            sigAcceptor: ISigAcceptor<SigWebhookId>
        ) {
            CallFactory.rpc.create(SigWebhookId::class.java, entId, SN, "entWebhookCodeGet")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun keychainCreate(
            entId: EntId,
            msg: MsgKeychainCreate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "keychainCreate")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun keychainMapGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigKeychainMap>
        ) {
            CallFactory.rpc.create(SigKeychainMap::class.java, entId, SN, "keychainMapGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun keychainPut(entId: EntId, msg: MsgKeychainPut, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "keychainPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun keychainRemove(
            entId: EntId,
            msg: MsgKeychainRemove,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "keychainRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun keychainSecretKeyGenerate(
            entId: EntId,
            sigAcceptor: ISigAcceptor<SigKeychainSecretKey>
        ) {
            CallFactory.rpc.create(
                SigKeychainSecretKey::class.java,
                entId,
                SN,
                "keychainSecretKeyGenerate"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun neoQLResultGet(
            entId: EntId,
            msg: MsgNeoQLResult,
            sigAcceptor: ISigAcceptor<SigNeoQLResult>
        ) {
            CallFactory.rpc.create(SigNeoQLResult::class.java, entId, SN, "neoQLResultGet")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun pluginAdminAdd(
            pluginBundleId: PluginBundleId,
            msg: MsgPluginAdminAdd,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "pluginAdminAdd")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun pluginAdminCallerGet(
            pluginBundleId: PluginBundleId,
            sigAcceptor: ISigAcceptor<SigPluginAdminCaller>
        ) {
            CallFactory.rpc.create(
                SigPluginAdminCaller::class.java,
                pluginBundleId,
                SN,
                "pluginAdminCallerGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun pluginAdminEditLockDetailGet(
            pluginBundleId: PluginBundleId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigAdminEditLockDetail>
        ) {
            CallFactory.rpc.create(
                SigAdminEditLockDetail::class.java,
                pluginBundleId,
                SN,
                "pluginAdminEditLockDetailGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun pluginAdminEditLockTransfer(
            pluginBundleId: PluginBundleId,
            msg: MsgAdminId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                pluginBundleId,
                SN,
                "pluginAdminEditLockTransfer"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun pluginAdminExit(pluginBundleId: PluginBundleId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "pluginAdminExit")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun pluginAdminInvite(
            pluginBundleId: PluginBundleId,
            msg: MsgAdminInvite,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "pluginAdminInvite")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun pluginAdminListGet(
            pluginBundleId: PluginBundleId,
            sigAcceptor: ISigAcceptor<SigPluginAdminList>
        ) {
            CallFactory.rpc.create(
                SigPluginAdminList::class.java,
                pluginBundleId,
                SN,
                "pluginAdminListGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun pluginAdminRemove(
            pluginBundleId: PluginBundleId,
            msg: MsgAdminId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "pluginAdminRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun pluginAdminUpdate(
            pluginBundleId: PluginBundleId,
            msg: MsgPluginAdminUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "pluginAdminUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun pluginApiSpecGet(
            entId: EntId,
            msg: MsgPluginApiSpecGet,
            sigAcceptor: ISigAcceptor<SigPluginApiSpec>
        ) {
            CallFactory.rpc.create(SigPluginApiSpec::class.java, entId, SN, "pluginApiSpecGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun pluginSourceCodeDownload(
            pluginBundleId: PluginBundleId,
            sigAcceptor: ISigAcceptor<SigMediaIdDocument>
        ) {
            CallFactory.rpc.create(
                SigMediaIdDocument::class.java,
                pluginBundleId,
                SN,
                "pluginSourceCodeDownload"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun studioEntConfigGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigStudioEntConfig>
        ) {
            CallFactory.rpc.create(SigStudioEntConfig::class.java, entId, SN, "studioEntConfigGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioEntConfigUpdate(
            entId: EntId,
            msg: MsgEntConfigUpdate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "studioEntConfigUpdate")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun studioEntDeployStatusGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigEntDeployStatus>
        ) {
            CallFactory.rpc.create(
                SigEntDeployStatus::class.java,
                entId,
                SN,
                "studioEntDeployStatusGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioEntMerge(entId: EntId, msg: MsgStudioEnt, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "studioEntMerge")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioEntPut(entId: EntId, msg: MsgStudioEnt, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "studioEntPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun studioEntRevertToDeploy(entId: EntId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "studioEntRevertToDeploy")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun studioFindUsages(
            artifactId: ArtifactId,
            msg: MsgStudioSearchUsages,
            sigAcceptor: ISigAcceptor<SigStudioSearchUsages>
        ) {
            CallFactory.rpc.create(
                SigStudioSearchUsages::class.java,
                artifactId,
                SN,
                "studioFindUsages"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioPluginMapGet(sigAcceptor: ISigAcceptor<SigStudioPluginMap>) {
            CallFactory.rpc.create(
                SigStudioPluginMap::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioPluginMapGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun studioPluginMarkObsolete(
            pluginBundleId: PluginBundleId,
            msg: MsgPluginId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                pluginBundleId,
                SN,
                "studioPluginMarkObsolete"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun studioPluginPut(
            pluginBundleId: PluginBundleId,
            msg: MsgStudioPlugin,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "studioPluginPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun studioPluginRemove(
            pluginBundleId: PluginBundleId,
            msg: MsgPluginId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "studioPluginRemove")
                .sendBearerToken()
                .delete(msg, sigAcceptor)
        }

        fun sysDefnFormMapGet(sigAcceptor: ISigAcceptor<SigSysDefnFormMapGet>) {
            CallFactory.rpc.create(
                SigSysDefnFormMapGet::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "sysDefnFormMapGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun whatsAppTemplateGroupMapGet(
            entId: EntId,
            sigAcceptor: ISigAcceptor<SigWhatsAppTemplateGroupMap>
        ) {
            CallFactory.rpc.create(
                SigWhatsAppTemplateGroupMap::class.java,
                entId,
                SN,
                "whatsAppTemplateGroupMapGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun workflowDebugBreakpointMapPut(
            entId: EntId,
            msg: MsgWorkflowDebugBreakpointMap,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "workflowDebugBreakpointMapPut")
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }

        fun workflowDebugConfigGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigWorkflowDebugConfig>
        ) {
            CallFactory.rpc.create(
                SigWorkflowDebugConfig::class.java,
                entId,
                SN,
                "workflowDebugConfigGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun workflowNodeFavoritesGet(
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigWorkflowNodeFavorites>
        ) {
            CallFactory.rpc.create(
                SigWorkflowNodeFavorites::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "workflowNodeFavoritesGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun workflowNodeFavoritesPut(
            msg: MsgWorkflowNodeFavoritesPut,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "workflowNodeFavoritesPut"
            )
                .sendBearerToken()
                .put(msg, sigAcceptor)
        }
    }
}
