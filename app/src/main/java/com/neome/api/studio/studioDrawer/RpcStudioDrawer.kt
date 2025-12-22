// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.core.base.sig.SigVerifyKey
import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone
import com.neome.api.studio.studioDrawer.msg.MsgArtifactDuplicate
import com.neome.api.studio.studioDrawer.msg.MsgStudioArtifactAvatarListGet
import com.neome.api.studio.studioDrawer.msg.MsgStudioEntCreate
import com.neome.api.studio.studioDrawer.msg.MsgStudioEntMergeTest
import com.neome.api.studio.studioDrawer.msg.MsgStudioEntPartMerge
import com.neome.api.studio.studioDrawer.msg.MsgStudioPluginCreate
import com.neome.api.studio.studioDrawer.msg.MsgStudioSearch
import com.neome.api.studio.studioDrawer.sig.SigStudioArtifactAvatarList
import com.neome.api.studio.studioDrawer.sig.SigStudioDeployedArtifactList
import com.neome.api.studio.studioDrawer.sig.SigStudioEntAvatar
import com.neome.api.studio.studioDrawer.sig.SigStudioEntDeploy
import com.neome.api.studio.studioDrawer.sig.SigStudioPluginAvatar
import com.neome.api.studio.studioDrawer.sig.SigStudioPluginBundle
import com.neome.api.studio.studioDrawer.sig.SigStudioSearch
import com.neome.api.studio.studioMain.msg.MsgStudioEntDeploy
import com.neome.api.studio.studioMain.sig.SigStudioEnt

class RpcStudioDrawer {
    companion object {
        val SN: ServiceName = ServiceName.studioDrawer

        fun artifactDuplicate(
            artifactId: ArtifactId,
            msg: MsgArtifactDuplicate,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, artifactId, SN, "artifactDuplicate")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioArtifactAvatarListGet(
            msg: MsgStudioArtifactAvatarListGet,
            sigAcceptor: ISigAcceptor<SigStudioArtifactAvatarList>
        ) {
            CallFactory.rpc.create(
                SigStudioArtifactAvatarList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioArtifactAvatarListGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioDeployedArtifactListGet(sigAcceptor: ISigAcceptor<SigStudioDeployedArtifactList>) {
            CallFactory.rpc.create(
                SigStudioDeployedArtifactList::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioDeployedArtifactListGet"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }

        fun studioEntAvatarGet(
            entId: EntId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigStudioEntAvatar>
        ) {
            CallFactory.rpc.create(SigStudioEntAvatar::class.java, entId, SN, "studioEntAvatarGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioEntCreate(msg: MsgStudioEntCreate, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioEntCreate"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioEntDeploy(
            entId: EntId,
            msg: MsgStudioEntDeploy,
            sigAcceptor: ISigAcceptor<SigStudioEntDeploy>
        ) {
            CallFactory.rpc.create(SigStudioEntDeploy::class.java, entId, SN, "studioEntDeploy")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioEntGet(entId: EntId, msg: MsgVersion, sigAcceptor: ISigAcceptor<SigStudioEnt>) {
            CallFactory.rpc.create(SigStudioEnt::class.java, entId, SN, "studioEntGet")
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioEntMergeTest(msg: MsgStudioEntMergeTest, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioEntMergeTest"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioEntPartMerge(
            entId: EntId,
            msg: MsgStudioEntPartMerge,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(SigDone::class.java, entId, SN, "studioEntPartMerge")
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioEntRemove(entId: EntId, sigAcceptor: ISigAcceptor<SigStudioEntDeploy>) {
            CallFactory.rpc.create(SigStudioEntDeploy::class.java, entId, SN, "studioEntRemove")
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun studioEntReset(entId: EntId, sigAcceptor: ISigAcceptor<SigVerifyKey>) {
            CallFactory.rpc.create(SigVerifyKey::class.java, entId, SN, "studioEntReset")
                .sendBearerToken()
                .post(null, sigAcceptor)
        }

        fun studioPluginAvatarGet(
            pluginBundleId: PluginBundleId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigStudioPluginAvatar>
        ) {
            CallFactory.rpc.create(
                SigStudioPluginAvatar::class.java,
                pluginBundleId,
                SN,
                "studioPluginAvatarGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioPluginBundleGet(
            pluginBundleId: PluginBundleId,
            msg: MsgVersion,
            sigAcceptor: ISigAcceptor<SigStudioPluginBundle>
        ) {
            CallFactory.rpc.create(
                SigStudioPluginBundle::class.java,
                pluginBundleId,
                SN,
                "studioPluginBundleGet"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }

        fun studioPluginBundleRemove(
            pluginBundleId: PluginBundleId,
            sigAcceptor: ISigAcceptor<SigDone>
        ) {
            CallFactory.rpc.create(
                SigDone::class.java,
                pluginBundleId,
                SN,
                "studioPluginBundleRemove"
            )
                .sendBearerToken()
                .delete(null, sigAcceptor)
        }

        fun studioPluginCreate(msg: MsgStudioPluginCreate, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioPluginCreate"
            )
                .sendBearerToken()
                .post(msg, sigAcceptor)
        }

        fun studioPluginDeploy(pluginBundleId: PluginBundleId, sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(SigDone::class.java, pluginBundleId, SN, "studioPluginDeploy")
                .sendBearerToken()
                .put(null, sigAcceptor)
        }

        fun studioSearch(msg: MsgStudioSearch, sigAcceptor: ISigAcceptor<SigStudioSearch>) {
            CallFactory.rpc.create(
                SigStudioSearch::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "studioSearch"
            )
                .sendBearerToken()
                .get(msg, sigAcceptor)
        }
    }
}
