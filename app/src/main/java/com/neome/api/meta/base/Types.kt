// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base


class Types {
    enum class ServiceName {
        agent,
        ai,
        api,
        aside,
        base,
        cli,
        cluster,
        deeplink,
        doc,
        drawer,
        ent,
        entAside,
        entDrawer,
        entMain,
        extn,
        main,
        otp,
        rpc,
        scheduler,
        session,
        stem,
        store,
        studioDrawer,
        studioEnt,
        studioMain,
        task,
        user,
        wsoc
    }

    const val AVATAR_CROP_QUALITY: Int = 1
    const val AVATAR_MAX_MB: Double = 1.5
    const val AVATAR_SIZE_MAX: Int = 640
    const val AVATAR_SIZE_MIN: Int = 192
    const val GRID_MAX_COUNT: Int = 20
    const val PARAGRAPH_MAX_SIZE: Int = 10240
    const val PREFIX_ADMIN_ID: String = "ea"
    const val PREFIX_AUTOMATION_EXECUTION_ID: String = "ae"
    const val PREFIX_CONN_ID: String = "conn"
    const val PREFIX_DEMO_APP_ID: String = "dt"
    const val PREFIX_DEVICE_ID: String = "d"
    const val PREFIX_ENT_ID: String = "e"
    const val PREFIX_ENT_USER_ID: String = "eu"
    const val PREFIX_GHOST_ID: String = "gh"
    const val PREFIX_GROUP_ID: String = "g"
    const val PREFIX_INBOX_ID_FOLLOWER: String = "ii"
    const val PREFIX_INBOX_ID_MASTER: String = "im"
    const val PREFIX_INBOX_MESSAGE_ID: String = "imm"
    const val PREFIX_KEYCHAIN_ID: String = "k"
    const val PREFIX_KEYCHAIN_SECRET_ID: String = "ks"
    const val PREFIX_MEDIA_ID_AUDIO: String = "ma"
    const val PREFIX_MEDIA_ID_AVATAR: String = "mp"
    const val PREFIX_MEDIA_ID_DOCUMENT: String = "md"
    const val PREFIX_MEDIA_ID_IMAGE: String = "mi"
    const val PREFIX_MEDIA_ID_JAR: String = "mj"
    const val PREFIX_MEDIA_ID_STICKER: String = "ms"
    const val PREFIX_MEDIA_ID_THUMBNAIL: String = "mt"
    const val PREFIX_MEDIA_ID_VIDEO: String = "mv"
    const val PREFIX_MEDIA_ID_VOICE: String = "mo"
    const val PREFIX_MESSAGE_ID: String = "m"
    const val PREFIX_META_ID_ACTION: String = "mac"
    const val PREFIX_META_ID_AUTOMATION: String = "mau"
    const val PREFIX_META_ID_CHART_X_AXIS: String = "mcx"
    const val PREFIX_META_ID_CHART_Y_AXIS: String = "mcy"
    const val PREFIX_META_ID_CODE: String = "mc"
    const val PREFIX_META_ID_CONDITION: String = "mcn"
    const val PREFIX_META_ID_DEEPLINK: String = "mdl"
    const val PREFIX_META_ID_DRIVE_SHEET: String = "mds"
    const val PREFIX_META_ID_EVENT: String = "mev"
    const val PREFIX_META_ID_FIELD: String = "mfd"
    const val PREFIX_META_ID_FIELD_DYNAMIC_CONDITION: String = "mfc"
    const val PREFIX_META_ID_FIELD_DYNAMIC_RULE: String = "mfr"
    const val PREFIX_META_ID_FOOTER: String = "mft"
    const val PREFIX_META_ID_FORM: String = "mf"
    const val PREFIX_META_ID_FORMULA: String = "mfm"
    const val PREFIX_META_ID_FUNC_ARG: String = "mfa"
    const val PREFIX_META_ID_GRID: String = "mgr"
    const val PREFIX_META_ID_GROUP: String = "mgp"
    const val PREFIX_META_ID_HEADER: String = "mhd"
    const val PREFIX_META_ID_HYPERLINK: String = "mhl"
    const val PREFIX_META_ID_LAYOUT_DRIVE_SHEET: String = "mld"
    const val PREFIX_META_ID_LAYOUT_FORM: String = "mlf"
    const val PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE: String = "mle"
    const val PREFIX_META_ID_LAYOUT_GRID: String = "mlg"
    const val PREFIX_META_ID_LAYOUT_USER: String = "mlu"
    const val PREFIX_META_ID_MAPPING: String = "mg"
    const val PREFIX_META_ID_MODULE: String = "mm"
    const val PREFIX_META_ID_OPTION: String = "mop"
    const val PREFIX_META_ID_PARTITION: String = "mpt"
    const val PREFIX_META_ID_PAYMENT_PROVIDER: String = "mpp"
    const val PREFIX_META_ID_PIPELINE_SYSTEM: String = "mps"
    const val PREFIX_META_ID_PIPELINE_VAR: String = "mpv"
    const val PREFIX_META_ID_PLUGIN: String = "mpl"
    const val PREFIX_META_ID_PROMPT: String = "mpm"
    const val PREFIX_META_ID_REPORT: String = "mrp"
    const val PREFIX_META_ID_ROLE: String = "mr"
    const val PREFIX_META_ID_SECTION: String = "msc"
    const val PREFIX_META_ID_SPREADSHEET: String = "mss"
    const val PREFIX_META_ID_SPREADSHEET_REF: String = "msr"
    const val PREFIX_META_ID_STEP: String = "mst"
    const val PREFIX_META_ID_SWIMLANE: String = "msw"
    const val PREFIX_META_ID_TAB: String = "mtb"
    const val PREFIX_META_ID_TABLE_STYLE: String = "mts"
    const val PREFIX_META_ID_TRANSLATION: String = "mtl"
    const val PREFIX_META_ID_USER_CONDITION: String = "muc"
    const val PREFIX_META_ID_VAR: String = "mw"
    const val PREFIX_META_ID_VD_AUTO_DIA: String = "va"
    const val PREFIX_META_ID_VD_AUTO_EDGE: String = "vae"
    const val PREFIX_META_ID_VD_AUTO_FUNC: String = "vaf"
    const val PREFIX_META_ID_VD_AUTO_NODE: String = "van"
    const val PREFIX_META_ID_VD_COMMENT: String = "vc"
    const val PREFIX_META_ID_VD_ERD_DIA: String = "ve"
    const val PREFIX_META_ID_VD_IMAGE_FUNC: String = "vif"
    const val PREFIX_META_ID_VD_NOTE: String = "vn"
    const val PREFIX_META_ID_VD_REGION: String = "vrg"
    const val PREFIX_META_ID_VD_REPORT_DIA: String = "vr"
    const val PREFIX_META_ID_VD_REVIEW: String = "vrv"
    const val PREFIX_META_ID_VIDEO_TIMESTAMP: String = "mvt"
    const val PREFIX_META_ID_VISIBILITY_ACTION: String = "mva"
    const val PREFIX_META_ID_VISIBILITY_CONDITION: String = "mvc"
    const val PREFIX_META_ID_VISIBILITY_RULE: String = "mvr"
    const val PREFIX_META_ID_WIZARD: String = "mwz"
    const val PREFIX_PLUGIN_API_ID: String = "pa"
    const val PREFIX_PLUGIN_BUNDLE_ID: String = "pb"
    const val PREFIX_PLUGIN_ID: String = "p"
    const val PREFIX_PLUGIN_RESOURCE_ID: String = "pr"
    const val PREFIX_REPORT_EXECUTION_ID: String = "re"
    const val PREFIX_REQUEST_ID: String = "req"
    const val PREFIX_ROW_ID: String = "r"
    const val PREFIX_SCHEDULER_TASK_ID: String = "st"
    const val PREFIX_SHEET_ID: String = "s"
    const val PREFIX_SNAPSHOT_ID: String = "ss"
    const val PREFIX_SPREADSHEET_PARTITION_ID: String = "sp"
    const val PREFIX_STORE_ITEM_ID: String = "si"
    const val PREFIX_TAB_ID: String = "t"
    const val PREFIX_TRANSACTION_ID: String = "tr"
    const val PREFIX_USER_ID: String = "u"
    const val PREFIX_WORKFLOW_EXECUTION_ID: String = "we"
    const val PREFIX_WORKFLOW_GROUP_EXECUTION_ID: String = "wg"
    const val SCRIPT_MAX_SIZE: Int = 20480
    const val SUFFIX_TEMPLATE: String = ".template"
    const val THUMBNAIL_MAX_MB: Double = 0.25
    const val THUMBNAIL_SIZE: Int = 144

    class AdminId : SysId()
    class ArtifactId : SysId()
    class AutomationExecutionId : SysId()
    class ChatId : SysId()
    class ConnId : SysId()
    class ContactId : ChatId()
    class DemoAppId : SysId()
    class DeviceId : SysId()
    class EntId : ArtifactId()
    class EntUserId : ContactId()
    class GhostId : SysId()
    class GroupId : ContactId()
    class InboxId : SysId()
    class InboxIdFollower : InboxId()
    class InboxIdMaster : InboxId()
    class InboxMessageId : SysId()
    class KeychainId : SysId()
    class KeychainSecretId : SysId()
    class MediaId : SysId()
    class MediaIdAudio : MediaId()
    class MediaIdAvatar : MediaId()
    class MediaIdDocument : MediaId()
    class MediaIdIcon : MediaId()
    class MediaIdImage : MediaId()
    class MediaIdJar : MediaId()
    class MediaIdSticker : MediaId()
    class MediaIdThumbnail : MediaId()
    class MediaIdVideo : MediaId()
    class MediaIdVoice : MediaId()
    class MessageId : SysId()
    class MetaId : SysId()
    class MetaIdAction : MetaId()
    class MetaIdAutomation : MetaId()
    class MetaIdChartXAxis : MetaId()
    class MetaIdChartYAxis : MetaId()
    class MetaIdCode : MetaId()
    class MetaIdComp : MetaId()
    class MetaIdComposite : MetaIdComp()
    class MetaIdCondition : MetaId()
    class MetaIdDeeplink : MetaId()
    class MetaIdDriveSheet : MetaId()
    class MetaIdEvent : MetaId()
    class MetaIdField : MetaIdComp()
    class MetaIdFieldDynamicCondition : MetaId()
    class MetaIdFieldDynamicRule : MetaId()
    class MetaIdFooter : MetaId()
    class MetaIdForm : MetaId()
    class MetaIdFormula : MetaId()
    class MetaIdFuncArg : MetaId()
    class MetaIdGrid : MetaIdComposite()
    class MetaIdGroup : MetaId()
    class MetaIdHeader : MetaId()
    class MetaIdHyperlink : MetaId()
    class MetaIdLayoutDriveSheet : MetaId()
    class MetaIdLayoutForm : MetaId()
    class MetaIdLayoutFormEditorComposite : MetaId()
    class MetaIdLayoutGrid : MetaId()
    class MetaIdLayoutUser : MetaId()
    class MetaIdMapping : MetaId()
    class MetaIdModule : MetaId()
    class MetaIdOption : MetaId()
    class MetaIdPartition : MetaId()
    class MetaIdPaymentProvider : MetaId()
    class MetaIdPipelineParam : MetaId()
    class MetaIdPipelineSystem : MetaIdPipelineParam()
    class MetaIdPipelineVar : MetaIdPipelineParam()
    class MetaIdPlugin : MetaId()
    class MetaIdPrompt : MetaId()
    class MetaIdReport : MetaId()
    class MetaIdRole : MetaId()
    class MetaIdSection : MetaIdComposite()
    class MetaIdSpreadsheet : MetaId()
    class MetaIdSpreadsheetRef : MetaIdComposite()
    class MetaIdStep : MetaIdPipelineParam()
    class MetaIdSwimlane : MetaId()
    class MetaIdTab : MetaIdComposite()
    class MetaIdTableStyle : MetaId()
    class MetaIdTranslation : MetaId()
    class MetaIdUserCondition : MetaId()
    class MetaIdVar : MetaId()
    class MetaIdVdAutoDia : MetaId()
    class MetaIdVdAutoEdge : MetaId()
    class MetaIdVdAutoFunc : MetaId()
    class MetaIdVdAutoNode : MetaIdPipelineParam()
    class MetaIdVdComment : MetaId()
    class MetaIdVdErdDia : MetaId()
    class MetaIdVdImageFunc : MetaId()
    class MetaIdVdNote : MetaId()
    class MetaIdVdRegion : MetaId()
    class MetaIdVdReportDia : MetaId()
    class MetaIdVdReview : MetaId()
    class MetaIdVideoTimestamp : MetaId()
    class MetaIdVisibilityAction : MetaId()
    class MetaIdVisibilityCondition : MetaId()
    class MetaIdVisibilityRule : MetaId()
    class MetaIdWizard : MetaIdComposite()
    class PluginApiId : SysId()
    class PluginBundleId : ArtifactId()
    class PluginId : SysId()
    class PluginResourceId : SysId()
    class ReportExecutionId : SysId()
    class RequestId : SysId()
    class RowId : ChatId()
    class SchedulerTaskId : SysId()
    class SheetId : SysId()
    class SnapshotId : SysId()
    class SpreadsheetPartitionId : SysId()
    class StoreItemId : ArtifactId()

    class TabId : SysId()
    class TransactionId : SysId()
    class UserId : SysId()
    class WorkflowExecutionId : SysId()
    class WorkflowGroupExecutionId : SysId()

    class AnyTime : AnyValue()
    class ColumnPath : AnyValue()
    class CurrencyKey : AnyKey()
    class GeoPoint : AnyValue()
    class HandleKey : AnyKey()
    class Key : AnyKey()
    class LanguageKey : AnyKey()
    class SearchPath : AnyValue()
    class SymbolColumn : AnyValue()
    class SymbolGrid : AnyValue()
    class TimeZoneKey : AnyKey()

    enum class DtoLogTreeKeyValueType {
        neoQL,
        json,
        javascript,
        xml,
        regular
    }

    enum class EnumContactCopyField {
        firstName,
        lastName,
        fullName,
        mobileNumber,
        email,
        address,
        birthDate
    }

    enum class EnumDefnAdminDoNotOptionEnt {
        actions,
        adminPermissions,
        admins,
        backend,
        debug,
        debugApiBrowser,
        debugAutomation,
        debugLogs,
        debugQuery,
        debugWorkflow,
        deeplinks,
        deploy,
        deployInfo,
        deployPayment,
        deployPlugins,
        deployVariables,
        driveSheets,
        extensions,
        facets,
        forms,
        formulas,
        frontend,
        groups,
        layouts,
        manage,
        manageDashboard,
        manageKeychain,
        managePayment,
        manageSettings,
        menus,
        modules,
        permissions,
        plugins,
        reports,
        roles,
        spreadsheets,
        theme,
        tools,
        toolsDemoApp,
        toolsWidgetWizard,
        translations,
        users,
        variables,
        visibilityRules,
        workflows
    }

    enum class EnumDefnAdminDoNotOptionPlugin {
        admins
    }

    enum class EnumDefnAdminDoNotOptionStoreItem {
        admins
    }

    enum class EnumDefnAdminPermissionType {
        doNotEdit,
        doNotShow
    }

    enum class EnumDefnArgBinder {
        argument,
        context,
        derived,
        field,
        input,
        output,
        spreadsheet,
        sep,
        variable,
        constant,
        response,
        refTarget,
        parameter
    }

    enum class EnumDefnArgBinderArgument {
        selectedSectionId,
        selectedGridId,
        selectedCompositeId,
        selectedGridRowId
    }

    enum class EnumDefnArgBinderContext {
        caller,
        callerSetting,
        ent,
        form,
        plugin,
        pluginConfig,
        row
    }

    enum class EnumDefnArgBinderContextCaller {
        color,
        entUserId,
        handle,
        managerId,
        assistantIds,
        allAssistantIds,
        allManagerIds,
        grandManagerId,
        nickName,
        userId,
        email,
        mobileNumber,
        roles
    }

    enum class EnumDefnArgBinderContextEnt {
        about,
        id,
        name,
        timeZone,
        displayDateFormat,
        systemEntUserId
    }

    enum class EnumDefnArgBinderContextForm {
        id,
        name,
        label
    }

    enum class EnumDefnArgBinderContextPlugin {
        about,
        id,
        name
    }

    enum class EnumDefnArgBinderContextRow {
        createdBy,
        createdOn,
        id,
        order,
        parentId,
        type,
        updatedBy,
        updatedOn
    }

    enum class EnumDefnAudioFormat {
        ogg,
        mp3,
        wav
    }

    enum class EnumDefnAutomationSource {
        currentForm,
        currentGrid
    }

    enum class EnumDefnAutomationTerminateKind {
        terminate,
        resume,
        setField
    }

    enum class EnumDefnAutomationWebhookKind {
        location,
        neomeComment,
        neomeUserSession,
        razorpayPaymentReceipt
    }

    enum class EnumDefnButtonTargetType {
        callReport,
        invokePlugin,
        saveToSpreadsheet,
        sendWhatsAppMessage,
        triggerAction,
        executeCallable,
        startLocationTracking,
        stopLocationTracking
    }

    enum class EnumDefnCalculateFormulaMode {
        automatic,
        manual,
        onSend
    }

    enum class EnumDefnCaptureMode {
        manual,
        onInsert,
        onUpdate
    }

    enum class EnumDefnCaptureValueKind {
        captureLocation,
        captureTime,
        captureUser
    }

    enum class EnumDefnChartRenderingMode {
        horizontal,
        vertical
    }

    enum class EnumDefnCodeEditorLanguage {
        csv,
        html,
        javascript,
        json,
        neoQL,
        sql,
        text,
        xml
    }

    enum class EnumDefnCodeType {
        barCode,
        qrCode
    }

    enum class EnumDefnCompType {
        bool,
        date,
        decimal,
        logDecimal,
        image,
        label,
        number,
        logNumber,
        paragraph,
        text,
        enumAdminDoNotOptionEnt,
        enumAdminDoNotOptionPlugin,
        enumAudioFormat,
        enumAutomationSource,
        enumCaptureValueKind,
        enumCodeEditorLanguage,
        enumConditionOperator,
        enumConjunction,
        enumDataPartitionPeriod,
        enumDate,
        enumDay,
        enumDeeplinkConstraints,
        enumDeployVar,
        enumDeviceSize,
        enumDeviceType,
        enumDocFileExt,
        enumDriveStatus,
        enumDurationUnit,
        enumEntLockBehavior,
        enumEntLockReason,
        enumFields,
        enumFuncArgs,
        enumMapPinShape,
        enumPaymentMethod,
        enumPaymentPlan,
        enumPermission,
        enumPluginApiMethod,
        enumPluginResources,
        enumPluginSecurityAccess,
        enumPromptAction,
        enumRoles,
        enumRowAuditTrail,
        enumSetupKind,
        enumUserSettingOptions,
        enumUserSettingValue,
        enumVideoFormat,
        enumVisibilityOperator,
        enumMonth,
        enumQuarter,
        enumDeeplinkExpiry,
        enumForms,
        enumLogOperationKind,
        enumCodeType,
        enumPosition,
        enumDateOccurrence,
        enumFrequencyKind,
        enumRenderingKind,
        enumInsertVariant,
        enumUpdateVariant,
        enumRemoveVariant,
        enumEmptyFieldVariant,
        enumTableLayoutStyle,
        enumUserProperty,
        enumRowProperty,
        enumStoreItem,
        enumCaptureMode,
        enumLockOperation,
        enumRefreshOn,
        enumEditorLayoutRenderingMode,
        enumFormLayoutType,
        enumSetOfUserKind,
        enumUserContext,
        enumDynamicOperator,
        enumTargetType,
        enumDriveSheetLayoutFor,
        enumDriveSheetFieldLayoutOn,
        enumTextStyle,
        enumContentAlignment,
        enumUserProps,
        enumGridRenderingMode,
        enumPaymentMethodKind,
        enumSortOrder,
        enumTextValidationPattern,
        enumSyncMode,
        enumPluginMode,
        enumMapRenderingMode,
        enumCalculateFormulaMode,
        enumEjectionPolicy,
        enumRefSetOperationKind,
        enumEntStage,
        enumFreezeAvatarKind,
        enumTableLayoutTheme,
        enumChartRenderingMode,
        enumThemeImageRenderingMode,
        enumPromptAttachmentFormat,
        enumLocationCapturingMode,
        enumArgBinderContext,
        enumArgBinder,
        enumKindAction,
        enumKindActionUIUpdate,
        enumKindAutomation,
        enumKindButton,
        enumKindDeeplink,
        enumKindFormComposite,
        enumKindHyperlink,
        enumKindImport,
        enumKindRating,
        enumKindReport,
        enumKindScheduledEvent,
        enumKindAutomationStep,
        enumKindSpreadsheetEvent,
        enumKindPluginWebhookEvent,
        enumKindWebhookEvent,
        enumKindTranslation,
        enumTerminateSetting,
        enumAutomationWebhookKind,
        enumLocationAccuracy,
        enumKindAutoEdge,
        enumKindAutoNode,
        enumLayoutCardFilterKind,
        enumLayoutGridKind,
        enumThemeButtonSize,
        enumThemeButtonVariant,
        enumThemeColor,
        enumThemeColorShade,
        enumThemeDirection,
        enumThemeDividerThickness,
        enumThemeFieldMargin,
        enumThemeFieldSize,
        enumThemeFieldVariant,
        enumThemeFormVariant,
        enumThemeImageCorner,
        enumThemePickVariant,
        enumThemePickMultiVariant,
        enumPlacement,
        enumThemeSectionVariant,
        enumThemeStroke,
        enumThemeTabVariant,
        enumVisibilityAction,
        enumVisibilityActionOn,
        enumWizardNavigationMode,
        currency,
        icon,
        language,
        timeZone,
        pinShape,
        lineStroke,
        month,
        quarter,
        textSize,
        paymentStatus,
        messageKind,
        chipSet,
        chipSetDate,
        chipSetDateTime,
        chipSetDay,
        chipSetDeviceSize,
        chipSetDeviceType,
        chipSetTime,
        pickRole,
        pickText,
        pickTree,
        pickUser,
        pickGridRow,
        pickReportRow,
        setOfRole,
        setOfUser,
        setOfText,
        color,
        hyperlink,
        audio,
        camera,
        counter,
        logCounter,
        dateRange,
        dateTime,
        dateTimeRange,
        duration,
        email,
        handle,
        location,
        mobileNumber,
        rating,
        signature,
        slider,
        time,
        video,
        voice,
        geoPoint,
        rowId,
        symbol,
        schedulerId,
        spreadsheetId,
        button,
        divider,
        document,
        error,
        html,
        identifier,
        info,
        propertyMap,
        scanCode,
        setOfDocument,
        showCode,
        userId,
        dynamic,
        hyperlinkRow,
        password,
        ref,
        refSet,
        refUser,
        refReport,
        refTarget,
        refContact,
        grid,
        section,
        spreadsheetRef,
        tab,
        wizard,
        dateFormat,
        studioVarIdTextEditor,
        studioVarIdParagraphEditor,
        studioCodeEditor,
        pickActionId,
        pickCompId,
        pickPluginCompId,
        pickFieldId,
        pickPluginFieldId,
        pickFormId,
        pickPluginFormId,
        pickGridId,
        pickImportPluginId,
        pickImportPluginApiId,
        pickLayoutFormContentId,
        pickLayoutGridId,
        pickSpreadsheetRefLayoutId,
        pickLayoutSpreadsheetId,
        pickPluginBundleId,
        pickPluginId,
        pickReportId,
        pickSectionId,
        pickSpreadsheetId,
        pickVarId,
        pickGroupId,
        pickDeeplinkId,
        pickPipelineVarId,
        pickDeployPaymentProviderId,
        pickAutomationId,
        studioBuildAllModules,
        studioBuildArgBinder,
        studioSetOfDate,
        studioBuildColor,
        studioBuildDate,
        studioBuildDateTime,
        studioBuildPermissionMatrix,
        studioBuildTree,
        studioBuildUserSetting,
        studioBuildActionPermission,
        studioBuildPropertyMap,
        studioBuildMapping,
        studioBuildVideoTimestampMap,
        studioBuildOptionPermissionMatrix,
        studioMapOfForwardRolePermission,
        studioMapOfCondition,
        studioMapOfFormula,
        studioMapOfFuncArg,
        studioMapOfJarFile,
        studioMapOfLayoutSpreadsheet,
        studioMapOfLayoutGrid,
        studioMapOfText,
        studioMapOfVisibilityCondition,
        studioMapOfVisibilityAction,
        studioMapOfPartition,
        studioMapOfForwardGroupPermission,
        studioMapOfDynamicRule,
        studioMapOfPipelineVariable,
        studioMapOfDynamicCondition,
        studioMapOfUserCondition,
        studioMapOfLayoutDriveSpreadsheet,
        studioFieldMappingTree,
        studioGridMappingTree,
        studioMapOfArgBinder,
        studioMapOfRefTargetSpreadsheet,
        studioSetOfDocFileExt,
        studioSetOfStoreItemCategory,
        studioSetOfModule,
        studioSetOfNumber,
        studioSetOfAdminDoNotOption,
        studioSetOfPluginSecurityAccess,
        studioSetOfRowAuditTrail,
        studioSetOfMonth,
        studioSetOfBorder,
        studioSetOfBorderRadius,
        studioSetOfCompId,
        studioSetOfDataExportKind,
        studioSetOfLanguageKeys,
        studioSetOfActionId,
        studioSetOfFieldId,
        studioSetOfPluginFieldId,
        studioSetOfFieldRefId,
        studioSetOfFormId,
        studioSetOfGridId,
        studioSetOfGroupId,
        studioSetOfLayoutFormContentId,
        studioSetOfLayoutGridId,
        studioSetOfLayoutSpreadsheetId,
        studioSetOfReportId,
        studioSetOfSectionId,
        studioSetOfSpreadsheetId,
        studioSetOfVarId,
        studioCompArray,
        otp,
        avtar,
        carousel,
        formList,
        formListItem,
        pickOption,
        wallpaper
    }

    enum class EnumDefnConditionOperator {
        hasNoValue,
        equalTo,
        greaterThan,
        greaterThanOrEqualTo,
        hasValue,
        lessThan,
        lessThanOrEqualTo,
        notEqualTo,
        contains,
        notContains
    }

    enum class EnumDefnConjunction {
        or,
        and
    }

    enum class EnumDefnContentAlignment {
        start,
        center,
        end
    }

    enum class EnumDefnDataExportKind {
        xlsx,
        json
    }

    enum class EnumDefnDataPartitionPeriod {
        daily,
        hourly,
        weekly,
        monthly,
        quarterly,
        yearly
    }

    enum class EnumDefnDate {
        lastQuarter,
        lastWeek,
        lastMonth,
        lastYear,
        nextQuarter,
        nextWeek,
        nextMonth,
        nextYear,
        now,
        tomorrow,
        yesterday,
        startOfWeek,
        startOfMonth,
        startOfYear,
        endOfWeek,
        endOfMonth,
        endOfYear,
        createdOn,
        updatedOn
    }

    enum class EnumDefnDateOccurrence {
        custom,
        first,
        last
    }

    enum class EnumDefnDay {
        sunday,
        monday,
        tuesday,
        wednesday,
        thursday,
        friday,
        saturday
    }

    enum class EnumDefnDeeplinkConstraint {
        enforceGlobalUserSignIn,
        enforceEnterpriseUserSignIn,
        makeAnEnterpriseUser,
        allowPublicSharing
    }

    enum class EnumDefnDeeplinkExpiry {
        onFirstClick,
        withinOneWeek,
        withinOneMonth,
        noExpiry
    }

    enum class EnumDefnDeploy {
        requiredOnDeploy,
        fixedOnDeploy
    }

    enum class EnumDefnDeviceSize {
        mobile,
        tablet,
        laptop,
        desktop
    }

    enum class EnumDefnDocFileExt {
        ai,
        any,
        avi,
        cdr,
        csv,
        dll,
        doc,
        docx,
        drawio,
        dwg,
        eml,
        gif,
        html,
        jar,
        jpeg,
        jpg,
        json,
        mov,
        mp3,
        mp4,
        msg,
        oga,
        ogg,
        pdf,
        png,
        ppt,
        pptx,
        rvt,
        std,
        svg,
        tiff,
        txt,
        wav,
        webm,
        xls,
        xlsx,
        xml,
        zip
    }

    enum class EnumDefnDriveSheetFieldLayoutOn {
        column,
        header
    }

    enum class EnumDefnDriveSheetLayoutFor {
        sectionOrGrid,
        field
    }

    enum class EnumDefnDriveStatus {
        connected,
        disconnected,
        notInstalled
    }

    enum class EnumDefnDurationUnit {
        seconds,
        minutes,
        hours,
        days,
        weeks,
        months,
        quarters,
        years
    }

    enum class EnumDefnDynamicOperator {
        hasNoValue,
        hasValue,
        equalTo,
        notEqualTo
    }

    enum class EnumDefnEditorLayoutRenderingMode {
        tabs,
        stack,
        wizard
    }

    enum class EnumDefnEjectionPolicy {
        FIFO,
        LIFO
    }

    enum class EnumDefnEmptyFieldVariant {
        ignoreEmptyField,
        overrideEmptyField
    }

    enum class EnumDefnEntLockBehavior {
        readAccess,
        zeroAccess,
        fullAccessWithWarning
    }

    enum class EnumDefnEntLockReason {
        blocked,
        obsolete,
        other,
        paymentNotReceived,
        tooMuchLoad,
        userUpgrade
    }

    enum class EnumDefnEntStage {
        Created,
        POC,
        UserInvited,
        Production
    }

    enum class EnumDefnErrorSeverity {
        error,
        suggestion,
        warning
    }

    enum class EnumDefnFields {
        $CreatedBy,
        $CreatedOn,
        $RowId,
        $RowOrder,
        $UpdatedBy,
        $UpdatedOn,
        $ParentRowId
    }

    enum class EnumDefnFormLayoutType {
        editor,
        content,
        template
    }

    enum class EnumDefnForms {
        $FormMapOfOptions,
        $FormPickTree,
        $FormSetOfUser,
        $FormPluginConfig,
        $FormSchedule,
        $FormPaymentReceipt,
        $FormUserSession,
        $FormRowComment,
        $FormLocation,
        $FormEntAdmin,
        $FormEntUser,
        $FormEntAuditRecord,
        $FormPrompt,
        $FormRagPromptResponse,
        $FormRowEditHistory,
        $FormHumanLink,
        $FormUserMembership,
        $FormCrawl,
        $FormSearch,
        $FormBotResponse,
        $FormBotHistory
    }

    enum class EnumDefnFreezeAvatarKind {
        rounded,
        square
    }

    enum class EnumDefnFuncArg {
        number,
        text,
        numberArray,
        textArray
    }

    enum class EnumDefnGridRenderingMode {
        auto,
        flex
    }

    enum class EnumDefnHttpMethod {
        delete,
        get,
        patch,
        post,
        put
    }

    enum class EnumDefnInsertVariant {
        insertForced,
        skipEmptyKeyField,
        doNotInsert
    }

    enum class EnumDefnKindAction {
        executeCallable,
        report,
        rowInsert,
        rowUpdate,
        spreadsheetEditor,
        spreadsheetHistory,
        uiUpdate,
        user
    }

    enum class EnumDefnKindActionUIUpdate {
        groupSwitcher
    }

    enum class EnumDefnKindAiProvider {
        openAI_4_1_MINI,
        openAI_5
    }

    enum class EnumDefnKindAutoEdge {
        ERROR,
        EXPIRY,
        FALSE,
        ITERATE,
        NEXT,
        TRUE,
        VALUE
    }

    enum class EnumDefnKindAutoNode {
        acquireLock,
        aiAgent,
        aiAudioToText,
        aiDocumentToForm,
        aiExcelToSpreadsheet,
        aiFakerToForm,
        aiFakerToSpreadsheet,
        aiFormToClassification,
        aiFormToForm,
        aiFormToHtml,
        aiFormToImage,
        aiFormToJSON,
        aiFormToPDF,
        aiFormToSentiment,
        aiFormToSummary,
        aiFormToXML,
        aiSpreadsheetToCSV,
        aiSpreadsheetToExcel,
        aiSpreadsheetToHTML,
        aiSpreadsheetToJSON,
        aiSpreadsheetToPDF,
        aiSpreadsheetToXML,
        aiTextToClassification,
        aiTextToForm,
        aiTextToJSON,
        aiTextToSentiment,
        aiTextToSummary,
        aiTextToXML,
        aiXMLToForm,
        aiXMLToSpreadsheet,
        applyFormula,
        applyTransforms,
        botBuildResponse,
        botHistoryAddPrompt,
        botHistoryAddResponse,
        botHistoryGet,
        botHistoryRemove,
        botHistoryToStory,
        botSendResponse,
        branchIfElse,
        branchIterateArray,
        branchIterateGrid,
        branchIterateSpreadsheet,
        branchSwitchCase,
        branchSwitchForm,
        branchSwitchPrompt,
        debugLog,
        eventChat,
        eventHumanLink,
        eventManualTrigger,
        eventPaymentReceipt,
        eventPluginWebhook,
        eventRowComment,
        eventRpcCall,
        eventSchedule,
        eventSsInsertAfter,
        eventSsInsertBefore,
        eventSsRemoveAfter,
        eventSsRemoveBefore,
        eventSsUpdateAfter,
        eventSsUpdateBefore,
        eventSubWorkflow,
        eventUserExit,
        eventUserJoin,
        eventUserLocation,
        eventUserOffline,
        eventUserOnline,
        executeAction,
        executeJavascript,
        executeParallel,
        executePlugin,
        executeReport,
        executeRpc,
        executeScheduler,
        executeSchedulerRemove,
        executeSubWorkflow,
        fieldRefSetSet,
        fieldRemove,
        fieldSet,
        generateDeeplink,
        generateImage,
        generatePaymentLink,
        generatePdf,
        imageTransforms,
        mediaExists,
        mediaRemove,
        paramCalc,
        paramClone,
        paramCreate,
        paramExist,
        paramRemove,
        paramUpdate,
        pause,
        releaseLock,
        resume,
        rowForward,
        rowGet,
        rowGetHistory,
        rowInsert,
        rowInsertPartitionRequest,
        rowRemove,
        rowSendComment,
        rowUpdate,
        rowUpdateFieldLogNumber,
        sendEmail,
        sendHumanLink,
        sendMessageToGroups,
        sendMessageToUsers,
        sendPushNotification,
        sendWhatsappMessage,
        sendWhatsappTemplate,
        ssCrawl,
        ssExecuteQuery,
        ssFtsSearch,
        ssRagSearch,
        ssRemoveRows,
        stopAndError,
        userAdd,
        userGet,
        userGetAllAssistants,
        userGetAssistants,
        userGetGrandManager,
        userGetManager,
        userHasGrandManager,
        userHasManager,
        userHasRoles,
        userIsAllAssistant,
        userIsAllManager,
        userIsAssistant,
        userIsGrandManager,
        userIsManager,
        userIterate,
        userRemove,
        userUpdate,
        validate,
        validatePrompt,
        wait
    }

    enum class EnumDefnKindAutoResponseWait {
        all,
        anyOne,
        none
    }

    enum class EnumDefnKindAutoXform {
        stringJoiner,
        stringIsMobileNumber,
        stringIsEmail
    }

    enum class EnumDefnKindAutomation {
        callable,
        pluginWebhook,
        scheduled,
        spreadsheet,
        webhook
    }

    enum class EnumDefnKindAutomationStep {
        addUser,
        updateUser,
        calculateFormulas,
        callPlugin,
        callReport,
        copyField,
        forwardToGroups,
        forwardToUsers,
        generateDeeplink,
        getSpreadsheetRow,
        getSpreadsheetRows,
        validation,
        insertIntoSpreadsheet,
        lock,
        sendMessage,
        sendMessageToUsers,
        sendMessageAsComment,
        sendMessageToGroups,
        generatePdf,
        generateImage,
        generatePaymentLink,
        sendWhatsappTemplateMessage,
        sendWhatsappDynamicMessage,
        sendEmail,
        sendPushNotification,
        partitionSend,
        pause,
        removeField,
        removeFromSpreadsheet,
        removeCurrentRow,
        removeRows,
        removeUser,
        returnEvent,
        terminate,
        updateField,
        updateFieldLogNumber,
        updateFieldRefSet,
        updateSpreadsheet,
        execute,
        executeAsync,
        clearPipeline,
        parseDocument,
        addSchedule,
        removeSchedule
    }

    enum class EnumDefnKindBranchIfElse {
        Condition,
        ConditionVar
    }

    enum class EnumDefnKindButton {
        submit,
        reset,
        refresh,
        normal
    }

    enum class EnumDefnKindCallableEvent {
        onFire
    }

    enum class EnumDefnKindChannelType {
        email,
        neome,
        slack,
        sms,
        whatsapp
    }

    enum class EnumDefnKindDeeplink {
        report,
        spreadsheetEditor,
        spreadsheetInsert,
        spreadsheetRow
    }

    enum class EnumDefnKindFormComposite {
        grid,
        section,
        spreadsheetRef
    }

    enum class EnumDefnKindHyperlink {
        general,
        youtube
    }

    enum class EnumDefnKindImageXform {
        blur
    }

    enum class EnumDefnKindImport {
        plugin
    }

    enum class EnumDefnKindMessage {
        audio,
        camera,
        document,
        image,
        linkText,
        location,
        text,
        video,
        user,
        voice
    }

    enum class EnumDefnKindNoteStatus {
        Done,
        Error,
        Start,
        Verify
    }

    enum class EnumDefnKindPipelineUpdate {
        Mapping,
        MappingVar
    }

    enum class EnumDefnKindPluginWebhookEvent {
        onCallback
    }

    enum class EnumDefnKindRating {
        heart_1,
        thumbs_2,
        star_3,
        star_4,
        star_5
    }

    enum class EnumDefnKindReport {
        composite,
        mapper,
        plugin,
        query,
        spreadsheet
    }

    enum class EnumDefnKindScheduledEvent {
        onExpiry
    }

    enum class EnumDefnKindSentiment {
        VeryPositive,
        Positive,
        Neutral,
        Negative,
        VeryNegative
    }

    enum class EnumDefnKindSetOfUser {
        roles,
        fields,
        context
    }

    enum class EnumDefnKindSpreadsheetEvent {
        afterInsert,
        afterRemove,
        afterUpdate,
        beforeInsert,
        beforeRemove,
        beforeUpdate
    }

    enum class EnumDefnKindTranslation {
        text,
        paragraph
    }

    enum class EnumDefnKindWebhookEvent {
        onCallback
    }

    enum class EnumDefnLayoutCardFilterKind {
        tree,
        tab
    }

    enum class EnumDefnLayoutGridKind {
        card,
        list,
        map,
        table,
        kanban,
        calendar,
        xyChartBarGraph,
        xyChartLineChart,
        xyChartPieChart,
        xyChartDoughnut,
        xyChartScatterPlot
    }

    enum class EnumDefnLayoutUserKind {
        hierarchy,
        tree
    }

    enum class EnumDefnLocationAccuracy {
        high,
        balanced,
        low
    }

    enum class EnumDefnLocationCapturingMode {
        scheduled,
        manual
    }

    enum class EnumDefnLockOperation {
        acquire,
        release
    }

    enum class EnumDefnLogOperationKind {
        add,
        subtract,
        set
    }

    enum class EnumDefnMapPinShape {
        avatar,
        avatarWithName,
        circle,
        circleBig,
        circleMedium,
        circleWithLabel,
        heart,
        heartBig,
        heartMedium,
        label,
        pin,
        pinWithLabel,
        square,
        squareBig,
        squareMedium,
        star,
        starBig,
        starMedium,
        triangle,
        triangleBig,
        triangleMedium
    }

    enum class EnumDefnMapRenderingMode {
        fixedLocation,
        liveLocation
    }

    enum class EnumDefnMonth {
        January,
        February,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        October,
        November,
        December,
        CurrentMonth,
        PreviousMonth,
        NextMonth
    }

    enum class EnumDefnNodeTerminateKind {
        resume,
        stopOrErrorBranch
    }

    enum class EnumDefnPaymentMethod {
        creditCard,
        debitCard
    }

    enum class EnumDefnPaymentMethodKind {
        netbanking,
        card,
        upi
    }

    enum class EnumDefnPaymentPlan {
        free,
        team,
        business,
        onPremise
    }

    enum class EnumDefnPaymentStatus {
        pending,
        paid,
        failed
    }

    enum class EnumDefnPermission {
        hide,
        read,
        writeOnInsert,
        writeOnce,
        invisible,
        write
    }

    enum class EnumDefnPipelineFormKind {
        input,
        output
    }

    enum class EnumDefnPipelineSystem {
        $Curr,
        $Iter,
        $Out,
        $Prev,
        $Prior,
        $Sys
    }

    enum class EnumDefnPlacement {
        top,
        bottom,
        start,
        end,
        center,
        diagonal,
        overlayTop,
        flexCenter,
        spaceBetween,
        justify
    }

    enum class EnumDefnPluginApiMethod {
        delete,
        get,
        patch,
        post,
        put,
        webhook,
        function
    }

    enum class EnumDefnPluginMode {
        agent,
        javascript,
        webService
    }

    enum class EnumDefnPluginResources {
        jar,
        rpc,
        dev
    }

    enum class EnumDefnPluginSecurityAccess {
        drive,
        network
    }

    enum class EnumDefnPosition {
        topLeft,
        topRight,
        bottomLeft,
        bottomRight
    }

    enum class EnumDefnPromptAction {
        insert,
        update,
        remove,
        get
    }

    enum class EnumDefnPromptAttachmentFormat {
        pdf,
        image
    }

    enum class EnumDefnQuarter {
        Quarter_1,
        Quarter_2,
        Quarter_3,
        Quarter_4
    }

    enum class EnumDefnRefSetOperationKind {
        set,
        union,
        intersection,
        insert,
        put,
        remove,
        moveUp,
        moveDown,
        moveTop,
        moveBottom,
        sort
    }

    enum class EnumDefnRefreshOn {
        refreshOnOpen,
        refreshOnSend,
        refreshOnDemand
    }

    enum class EnumDefnRemoveVariant {
        removeForced,
        doNotRemove
    }

    enum class EnumDefnRenderingKind {
        a4Size,
        custom,
        fitToScreen,
        fullScreen,
        mm_48,
        mm_58,
        mm_72,
        mm_80,
        mm_104,
        receiptSize
    }

    enum class EnumDefnRepeatFrequencyKind {
        minutes,
        hours,
        days,
        weeks,
        months,
        years
    }

    enum class EnumDefnRoles {
        $Public,
        $Manager,
        $GrandManager,
        $AllManagers,
        $Assistants,
        $AllAssistants,
        $Self
    }

    enum class EnumDefnRowAuditTrail {
        insert,
        update,
        remove
    }

    enum class EnumDefnRowProperty {
        createdBy,
        updatedBy
    }

    enum class EnumDefnScanCodeType {
        barCode,
        qrCode
    }

    enum class EnumDefnSetupKind {
        quick,
        standard,
        advanced,
        focusDeploy,
        focusBackend,
        focusFrontend
    }

    enum class EnumDefnShowBorderKind {
        top,
        bottom,
        left,
        right
    }

    enum class EnumDefnShowBorderRadiusKind {
        topLeft,
        topRight,
        bottomLeft,
        bottomRight
    }

    enum class EnumDefnSortOrder {
        ascending,
        descending
    }

    enum class EnumDefnStoreItem {
        template,
        application
    }

    enum class EnumDefnSyncMode {
        backup,
        biDirectional
    }

    enum class EnumDefnTableLayoutTheme {
        standard,
        spacious
    }

    enum class EnumDefnTableStyle {
        defaultStyle
    }

    enum class EnumDefnTextSize {
        body1,
        body2,
        button,
        caption,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        inherit,
        overline,
        subtitle1,
        subtitle2,
        subtitle3,
        subtitle4
    }

    enum class EnumDefnTextStyle {
        bold,
        italic,
        underlined,
        strikeout
    }

    enum class EnumDefnTextValidationPattern {
        aadhaar,
        gstin,
        pan
    }

    enum class EnumDefnThemeButtonSize {
        small,
        medium,
        large
    }

    enum class EnumDefnThemeButtonVariant {
        text,
        contained,
        outlined,
        icon
    }

    enum class EnumDefnThemeColor {
        transparent,
        primary,
        secondary,
        error,
        info,
        success,
        warning,
        textPrimary,
        textSecondary,
        textDisabled,
        textInverse,
        primaryLight,
        secondaryLight,
        successLight,
        errorLight,
        infoLight,
        warningLight,
        primaryDark,
        secondaryDark,
        successDark,
        errorDark,
        infoDark,
        warningDark,
        amber,
        black,
        blue,
        cyan,
        deepOrange,
        deepPurple,
        green,
        grey,
        indigo,
        lightBlue,
        lightGreen,
        lime,
        orange,
        pink,
        purple,
        red,
        teal,
        white,
        yellow
    }

    enum class EnumDefnThemeColorShade {
        s50,
        s100,
        s200,
        s300,
        s400,
        s500
    }

    enum class EnumDefnThemeDirection {
        horizontal,
        vertical
    }

    enum class EnumDefnThemeDividerKind {
        thick,
        thin
    }

    enum class EnumDefnThemeFieldMargin {
        dense,
        none,
        normal
    }

    enum class EnumDefnThemeFieldSize {
        medium,
        small
    }

    enum class EnumDefnThemeFieldVariant {
        outlined,
        filled,
        standard
    }

    enum class EnumDefnThemeFormVariant {
        form,
        report
    }

    enum class EnumDefnThemeImageCorner {
        rectangle,
        circle,
        rounded
    }

    enum class EnumDefnThemeImageRenderingMode {
        aspectFit,
        scaleToFit
    }

    enum class EnumDefnThemePickMultiVariant {
        checkboxVertical,
        checkboxHorizontal,
        dropdown
    }

    enum class EnumDefnThemePickVariant {
        radioButtonVertical,
        radioButtonHorizontal,
        led,
        dropdown
    }

    enum class EnumDefnThemeSectionVariant {
        form,
        propertyEditor
    }

    enum class EnumDefnThemeStroke {
        dash,
        dotted,
        solid
    }

    enum class EnumDefnThemeTabVariant {
        standard,
        scrollable,
        fullWidth
    }

    enum class EnumDefnTime {
        now
    }

    enum class EnumDefnUpdateVariant {
        updateForced,
        doNotUpdate
    }

    enum class EnumDefnUserContext {
        caller,
        createdBy,
        updatedBy
    }

    enum class EnumDefnUserProperty {
        nickName,
        handle
    }

    enum class EnumDefnUserProps {
        firstName,
        lastName,
        fullName,
        email,
        mobileNumber,
        handle
    }

    enum class EnumDefnUserSettingOptions {
        text,
        number,
        decimal,
        pickOne,
        pickMany
    }

    enum class EnumDefnUserSettingValue {
        dataEntered,
        dataNotEntered
    }

    enum class EnumDefnVideoFormat {
        mp4
    }

    enum class EnumDefnVisibilityAction {
        blink,
        click,
        clear,
        setValue,
        disable,
        enable,
        executeAction,
        hidden,
        highlight,
        invisible,
        shake,
        visible
    }

    enum class EnumDefnVisibilityActionOn {
        component,
        field,
        layout,
        sendButton
    }

    enum class EnumDefnVisibilityOperator {
        hasNoValue,
        hasValue,
        equalTo,
        notEqualTo,
        hasChanged
    }

    enum class EnumDefnWizardNavigationMode {
        nextButton,
        nextPreviousButton
    }

    enum class EnumDeviceType {
        android,
        ios,
        web,
        widget,
        agent,
        test
    }

    enum class EnumEnvValidationError {
        cli,
        composite,
        invalidParam,
        notAccessible,
        notChanged,
        notFound,
        ruleViolation
    }

    enum class EnumFormContentPosition {
        start,
        flexCenter,
        end
    }

    enum class EnumFormExportType {
        pdf,
        image,
        html
    }

    enum class EnumIdentityProviderKind {
        apple,
        google,
        microsoft
    }

    enum class EnumKeychainType {
        rpcReceive,
        rpcSend,
        slack
    }

    enum class EnumLogItemType {
        text,
        tree,
        table
    }

    enum class EnumLogTableAlignment {
        left,
        center,
        right
    }

    enum class EnumLogTableTextStyle {
        plain,
        bold,
        italic,
        underline,
        strikeThrough,
        boldItalic,
        boldUnderline,
        boldStrikeThrough
    }

    enum class EnumLogTextType {
        neoQL,
        cli,
        json,
        plain,
        monospaced,
        javascript,
        html,
        xml
    }

    enum class EnumLogTreeItemType {
        keyValue,
        line
    }

    enum class EnumLogTreeLineCollapse {
        showCollapse,
        showExpand,
        ignore
    }

    enum class EnumMediaType {
        audio,
        document,
        icon,
        image,
        jar,
        avatar,
        sticker,
        thumbnail,
        video,
        voice
    }

    enum class EnumNeatPathCaption {
        About,
        Plugins,
        Roles,
        Variables,
        Translations,
        Forms,
        Reports,
        Spreadsheets,
        Actions,
        Groups,
        Deeplinks,
        DriveSheets,
        Deploy,
        Automation,
        Admins,
        Users,
        Details,
        API,
        Resources,
        Store
    }

    enum class EnumPaymentProviderKind {
        razorpay
    }

    enum class EnumSchemaColumnType {
        Boolean,
        Date,
        DateArray,
        Double,
        GeoHash,
        GeoPoint,
        Long,
        String,
        StringArray,
        SysId,
        LongArray,
        SysIdArray
    }

    enum class EnumStoreItemArtifact {
        ent,
        plugin,
        template
    }

    enum class EnumStoreLabel {
        CRM,
        Demo,
        Ffreedom,
        Hubspot,
        Neome,
        Plugin,
        SalesForce,
        ServiceNow,
        Tally,
        Ticketing,
        Zendesk
    }

    enum class EnumStudioCompType {
        bool,
        date,
        decimal,
        logDecimal,
        image,
        label,
        number,
        logNumber,
        paragraph,
        text,
        chipSet,
        chipSetDate,
        chipSetDateTime,
        chipSetDay,
        chipSetDeviceSize,
        chipSetDeviceType,
        chipSetTime,
        currency,
        icon,
        language,
        timeZone,
        pinShape,
        lineStroke,
        paymentStatus,
        month,
        quarter,
        textSize,
        messageKind,
        pickRole,
        pickText,
        pickTree,
        pickUser,
        pickGridRow,
        pickReportRow,
        setOfRole,
        setOfUser,
        setOfText,
        color,
        hyperlink,
        audio,
        camera,
        counter,
        logCounter,
        dateRange,
        dateTime,
        dateTimeRange,
        duration,
        email,
        handle,
        location,
        mobileNumber,
        rating,
        signature,
        slider,
        time,
        video,
        voice,
        geoPoint,
        rowId,
        symbol,
        schedulerId,
        spreadsheetId,
        button,
        divider,
        document,
        error,
        html,
        identifier,
        info,
        propertyMap,
        scanCode,
        setOfDocument,
        showCode,
        userId,
        dynamic,
        hyperlinkRow,
        password,
        ref,
        refSet,
        refUser,
        refReport,
        refTarget,
        refContact,
        grid,
        section,
        spreadsheetRef
    }

    enum class EnumStudioVarKind {
        any,
        bool,
        buttonVariant,
        color,
        currency,
        date,
        dateTime,
        day,
        decimal,
        deviceSize,
        deviceType,
        direction,
        dividerKind,
        document,
        duration,
        email,
        textSize,
        html,
        hyperlink,
        icon,
        image,
        imageCorner,
        language,
        location,
        mapPinShape,
        mobileNumber,
        number,
        paragraph,
        ratingKind,
        stroke,
        symbol,
        text,
        placement,
        time,
        timeZone,
        month,
        quarter,
        condition,
        function,
        mapping,
        sequence,
        userSetting,
        mapOfText,
        setOfDate,
        setOfDay,
        setOfNumber,
        setOfText,
        setOfTime,
        setOfUser,
        tree
    }

    enum class EnumWhatsAppTemplateHeaderType {
        none,
        video,
        document,
        image
    }

    private val prefixSysIdClassMap: MutableMap<String, Class<out SysId>> = mutableMapOf()
    private val sysIdClassPrefixMap: MutableMap<Class<out SysId>, String> = mutableMapOf()

    init {
        prefixSysIdClassMap[PREFIX_ADMIN_ID] = AdminId::class.java
        prefixSysIdClassMap[PREFIX_AUTOMATION_EXECUTION_ID] = AutomationExecutionId::class.java
        prefixSysIdClassMap[PREFIX_CONN_ID] = ConnId::class.java
        prefixSysIdClassMap[PREFIX_DEMO_APP_ID] = DemoAppId::class.java
        prefixSysIdClassMap[PREFIX_DEVICE_ID] = DeviceId::class.java
        prefixSysIdClassMap[PREFIX_ENT_ID] = EntId::class.java
        prefixSysIdClassMap[PREFIX_ENT_USER_ID] = EntUserId::class.java
        prefixSysIdClassMap[PREFIX_GHOST_ID] = GhostId::class.java
        prefixSysIdClassMap[PREFIX_GROUP_ID] = GroupId::class.java
        prefixSysIdClassMap[PREFIX_INBOX_ID_FOLLOWER] = InboxIdFollower::class.java
        prefixSysIdClassMap[PREFIX_INBOX_ID_MASTER] = InboxIdMaster::class.java
        prefixSysIdClassMap[PREFIX_INBOX_MESSAGE_ID] = InboxMessageId::class.java
        prefixSysIdClassMap[PREFIX_KEYCHAIN_ID] = KeychainId::class.java
        prefixSysIdClassMap[PREFIX_KEYCHAIN_SECRET_ID] = KeychainSecretId::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_AUDIO] = MediaIdAudio::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_AVATAR] = MediaIdAvatar::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_DOCUMENT] = MediaIdDocument::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_IMAGE] = MediaIdImage::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_JAR] = MediaIdJar::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_STICKER] = MediaIdSticker::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_THUMBNAIL] = MediaIdThumbnail::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_VIDEO] = MediaIdVideo::class.java
        prefixSysIdClassMap[PREFIX_MEDIA_ID_VOICE] = MediaIdVoice::class.java
        prefixSysIdClassMap[PREFIX_MESSAGE_ID] = MessageId::class.java
        prefixSysIdClassMap[PREFIX_META_ID_ACTION] = MetaIdAction::class.java
        prefixSysIdClassMap[PREFIX_META_ID_AUTOMATION] = MetaIdAutomation::class.java
        prefixSysIdClassMap[PREFIX_META_ID_CHART_X_AXIS] = MetaIdChartXAxis::class.java
        prefixSysIdClassMap[PREFIX_META_ID_CHART_Y_AXIS] = MetaIdChartYAxis::class.java
        prefixSysIdClassMap[PREFIX_META_ID_CODE] = MetaIdCode::class.java
        prefixSysIdClassMap[PREFIX_META_ID_CONDITION] = MetaIdCondition::class.java
        prefixSysIdClassMap[PREFIX_META_ID_DEEPLINK] = MetaIdDeeplink::class.java
        prefixSysIdClassMap[PREFIX_META_ID_DRIVE_SHEET] = MetaIdDriveSheet::class.java
        prefixSysIdClassMap[PREFIX_META_ID_EVENT] = MetaIdEvent::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FIELD] = MetaIdField::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FIELD_DYNAMIC_CONDITION] =
            MetaIdFieldDynamicCondition::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FIELD_DYNAMIC_RULE] = MetaIdFieldDynamicRule::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FOOTER] = MetaIdFooter::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FORM] = MetaIdForm::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FORMULA] = MetaIdFormula::class.java
        prefixSysIdClassMap[PREFIX_META_ID_FUNC_ARG] = MetaIdFuncArg::class.java
        prefixSysIdClassMap[PREFIX_META_ID_GRID] = MetaIdGrid::class.java
        prefixSysIdClassMap[PREFIX_META_ID_GROUP] = MetaIdGroup::class.java
        prefixSysIdClassMap[PREFIX_META_ID_HEADER] = MetaIdHeader::class.java
        prefixSysIdClassMap[PREFIX_META_ID_HYPERLINK] = MetaIdHyperlink::class.java
        prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_DRIVE_SHEET] = MetaIdLayoutDriveSheet::class.java
        prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_FORM] = MetaIdLayoutForm::class.java
        prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE] =
            MetaIdLayoutFormEditorComposite::class.java
        prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_GRID] = MetaIdLayoutGrid::class.java
        prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_USER] = MetaIdLayoutUser::class.java
        prefixSysIdClassMap[PREFIX_META_ID_MAPPING] = MetaIdMapping::class.java
        prefixSysIdClassMap[PREFIX_META_ID_MODULE] = MetaIdModule::class.java
        prefixSysIdClassMap[PREFIX_META_ID_OPTION] = MetaIdOption::class.java
        prefixSysIdClassMap[PREFIX_META_ID_PARTITION] = MetaIdPartition::class.java
        prefixSysIdClassMap[PREFIX_META_ID_PAYMENT_PROVIDER] = MetaIdPaymentProvider::class.java
        prefixSysIdClassMap[PREFIX_META_ID_PIPELINE_SYSTEM] = MetaIdPipelineSystem::class.java
        prefixSysIdClassMap[PREFIX_META_ID_PIPELINE_VAR] = MetaIdPipelineVar::class.java
        prefixSysIdClassMap[PREFIX_META_ID_PLUGIN] = MetaIdPlugin::class.java
        prefixSysIdClassMap[PREFIX_META_ID_PROMPT] = MetaIdPrompt::class.java
        prefixSysIdClassMap[PREFIX_META_ID_REPORT] = MetaIdReport::class.java
        prefixSysIdClassMap[PREFIX_META_ID_ROLE] = MetaIdRole::class.java
        prefixSysIdClassMap[PREFIX_META_ID_SECTION] = MetaIdSection::class.java
        prefixSysIdClassMap[PREFIX_META_ID_SPREADSHEET] = MetaIdSpreadsheet::class.java
        prefixSysIdClassMap[PREFIX_META_ID_SPREADSHEET_REF] = MetaIdSpreadsheetRef::class.java
        prefixSysIdClassMap[PREFIX_META_ID_STEP] = MetaIdStep::class.java
        prefixSysIdClassMap[PREFIX_META_ID_SWIMLANE] = MetaIdSwimlane::class.java
        prefixSysIdClassMap[PREFIX_META_ID_TAB] = MetaIdTab::class.java
        prefixSysIdClassMap[PREFIX_META_ID_TABLE_STYLE] = MetaIdTableStyle::class.java
        prefixSysIdClassMap[PREFIX_META_ID_TRANSLATION] = MetaIdTranslation::class.java
        prefixSysIdClassMap[PREFIX_META_ID_USER_CONDITION] = MetaIdUserCondition::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VAR] = MetaIdVar::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_DIA] = MetaIdVdAutoDia::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_EDGE] = MetaIdVdAutoEdge::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_FUNC] = MetaIdVdAutoFunc::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_NODE] = MetaIdVdAutoNode::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_COMMENT] = MetaIdVdComment::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_ERD_DIA] = MetaIdVdErdDia::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_IMAGE_FUNC] = MetaIdVdImageFunc::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_NOTE] = MetaIdVdNote::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_REGION] = MetaIdVdRegion::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_REPORT_DIA] = MetaIdVdReportDia::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VD_REVIEW] = MetaIdVdReview::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VIDEO_TIMESTAMP] = MetaIdVideoTimestamp::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VISIBILITY_ACTION] = MetaIdVisibilityAction::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VISIBILITY_CONDITION] =
            MetaIdVisibilityCondition::class.java
        prefixSysIdClassMap[PREFIX_META_ID_VISIBILITY_RULE] = MetaIdVisibilityRule::class.java
        prefixSysIdClassMap[PREFIX_META_ID_WIZARD] = MetaIdWizard::class.java
        prefixSysIdClassMap[PREFIX_PLUGIN_API_ID] = PluginApiId::class.java
        prefixSysIdClassMap[PREFIX_PLUGIN_BUNDLE_ID] = PluginBundleId::class.java
        prefixSysIdClassMap[PREFIX_PLUGIN_ID] = PluginId::class.java
        prefixSysIdClassMap[PREFIX_PLUGIN_RESOURCE_ID] = PluginResourceId::class.java
        prefixSysIdClassMap[PREFIX_REPORT_EXECUTION_ID] = ReportExecutionId::class.java
        prefixSysIdClassMap[PREFIX_REQUEST_ID] = RequestId::class.java
        prefixSysIdClassMap[PREFIX_ROW_ID] = RowId::class.java
        prefixSysIdClassMap[PREFIX_SCHEDULER_TASK_ID] = SchedulerTaskId::class.java
        prefixSysIdClassMap[PREFIX_SHEET_ID] = SheetId::class.java
        prefixSysIdClassMap[PREFIX_SNAPSHOT_ID] = SnapshotId::class.java
        prefixSysIdClassMap[PREFIX_SPREADSHEET_PARTITION_ID] = SpreadsheetPartitionId::class.java
        prefixSysIdClassMap[PREFIX_STORE_ITEM_ID] = StoreItemId::class.java
        prefixSysIdClassMap[PREFIX_TAB_ID] = TabId::class.java
        prefixSysIdClassMap[PREFIX_TRANSACTION_ID] = TransactionId::class.java
        prefixSysIdClassMap[PREFIX_USER_ID] = UserId::class.java
        prefixSysIdClassMap[PREFIX_WORKFLOW_EXECUTION_ID] = WorkflowExecutionId::class.java
        prefixSysIdClassMap[PREFIX_WORKFLOW_GROUP_EXECUTION_ID] =
            WorkflowGroupExecutionId::class.java

        sysIdClassPrefixMap[AdminId::class.java] = PREFIX_ADMIN_ID
        sysIdClassPrefixMap[AutomationExecutionId::class.java] = PREFIX_AUTOMATION_EXECUTION_ID
        sysIdClassPrefixMap[ConnId::class.java] = PREFIX_CONN_ID
        sysIdClassPrefixMap[DemoAppId::class.java] = PREFIX_DEMO_APP_ID
        sysIdClassPrefixMap[DeviceId::class.java] = PREFIX_DEVICE_ID
        sysIdClassPrefixMap[EntId::class.java] = PREFIX_ENT_ID
        sysIdClassPrefixMap[EntUserId::class.java] = PREFIX_ENT_USER_ID
        sysIdClassPrefixMap[GhostId::class.java] = PREFIX_GHOST_ID
        sysIdClassPrefixMap[GroupId::class.java] = PREFIX_GROUP_ID
        sysIdClassPrefixMap[InboxIdFollower::class.java] = PREFIX_INBOX_ID_FOLLOWER
        sysIdClassPrefixMap[InboxIdMaster::class.java] = PREFIX_INBOX_ID_MASTER
        sysIdClassPrefixMap[InboxMessageId::class.java] = PREFIX_INBOX_MESSAGE_ID
        sysIdClassPrefixMap[KeychainId::class.java] = PREFIX_KEYCHAIN_ID
        sysIdClassPrefixMap[KeychainSecretId::class.java] = PREFIX_KEYCHAIN_SECRET_ID
        sysIdClassPrefixMap[MediaIdAudio::class.java] = PREFIX_MEDIA_ID_AUDIO
        sysIdClassPrefixMap[MediaIdAvatar::class.java] = PREFIX_MEDIA_ID_AVATAR
        sysIdClassPrefixMap[MediaIdDocument::class.java] = PREFIX_MEDIA_ID_DOCUMENT
        sysIdClassPrefixMap[MediaIdImage::class.java] = PREFIX_MEDIA_ID_IMAGE
        sysIdClassPrefixMap[MediaIdJar::class.java] = PREFIX_MEDIA_ID_JAR
        sysIdClassPrefixMap[MediaIdSticker::class.java] = PREFIX_MEDIA_ID_STICKER
        sysIdClassPrefixMap[MediaIdThumbnail::class.java] = PREFIX_MEDIA_ID_THUMBNAIL
        sysIdClassPrefixMap[MediaIdVideo::class.java] = PREFIX_MEDIA_ID_VIDEO
        sysIdClassPrefixMap[MediaIdVoice::class.java] = PREFIX_MEDIA_ID_VOICE
        sysIdClassPrefixMap[MessageId::class.java] = PREFIX_MESSAGE_ID
        sysIdClassPrefixMap[MetaIdAction::class.java] = PREFIX_META_ID_ACTION
        sysIdClassPrefixMap[MetaIdAutomation::class.java] = PREFIX_META_ID_AUTOMATION
        sysIdClassPrefixMap[MetaIdChartXAxis::class.java] = PREFIX_META_ID_CHART_X_AXIS
        sysIdClassPrefixMap[MetaIdChartYAxis::class.java] = PREFIX_META_ID_CHART_Y_AXIS
        sysIdClassPrefixMap[MetaIdCode::class.java] = PREFIX_META_ID_CODE
        sysIdClassPrefixMap[MetaIdCondition::class.java] = PREFIX_META_ID_CONDITION
        sysIdClassPrefixMap[MetaIdDeeplink::class.java] = PREFIX_META_ID_DEEPLINK
        sysIdClassPrefixMap[MetaIdDriveSheet::class.java] = PREFIX_META_ID_DRIVE_SHEET
        sysIdClassPrefixMap[MetaIdEvent::class.java] = PREFIX_META_ID_EVENT
        sysIdClassPrefixMap[MetaIdField::class.java] = PREFIX_META_ID_FIELD
        sysIdClassPrefixMap[MetaIdFieldDynamicCondition::class.java] =
            PREFIX_META_ID_FIELD_DYNAMIC_CONDITION
        sysIdClassPrefixMap[MetaIdFieldDynamicRule::class.java] = PREFIX_META_ID_FIELD_DYNAMIC_RULE
        sysIdClassPrefixMap[MetaIdFooter::class.java] = PREFIX_META_ID_FOOTER
        sysIdClassPrefixMap[MetaIdForm::class.java] = PREFIX_META_ID_FORM
        sysIdClassPrefixMap[MetaIdFormula::class.java] = PREFIX_META_ID_FORMULA
        sysIdClassPrefixMap[MetaIdFuncArg::class.java] = PREFIX_META_ID_FUNC_ARG
        sysIdClassPrefixMap[MetaIdGrid::class.java] = PREFIX_META_ID_GRID
        sysIdClassPrefixMap[MetaIdGroup::class.java] = PREFIX_META_ID_GROUP
        sysIdClassPrefixMap[MetaIdHeader::class.java] = PREFIX_META_ID_HEADER
        sysIdClassPrefixMap[MetaIdHyperlink::class.java] = PREFIX_META_ID_HYPERLINK
        sysIdClassPrefixMap[MetaIdLayoutDriveSheet::class.java] = PREFIX_META_ID_LAYOUT_DRIVE_SHEET
        sysIdClassPrefixMap[MetaIdLayoutForm::class.java] = PREFIX_META_ID_LAYOUT_FORM
        sysIdClassPrefixMap[MetaIdLayoutFormEditorComposite::class.java] =
            PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE
        sysIdClassPrefixMap[MetaIdLayoutGrid::class.java] = PREFIX_META_ID_LAYOUT_GRID
        sysIdClassPrefixMap[MetaIdLayoutUser::class.java] = PREFIX_META_ID_LAYOUT_USER
        sysIdClassPrefixMap[MetaIdMapping::class.java] = PREFIX_META_ID_MAPPING
        sysIdClassPrefixMap[MetaIdModule::class.java] = PREFIX_META_ID_MODULE
        sysIdClassPrefixMap[MetaIdOption::class.java] = PREFIX_META_ID_OPTION
        sysIdClassPrefixMap[MetaIdPartition::class.java] = PREFIX_META_ID_PARTITION
        sysIdClassPrefixMap[MetaIdPaymentProvider::class.java] = PREFIX_META_ID_PAYMENT_PROVIDER
        sysIdClassPrefixMap[MetaIdPipelineSystem::class.java] = PREFIX_META_ID_PIPELINE_SYSTEM
        sysIdClassPrefixMap[MetaIdPipelineVar::class.java] = PREFIX_META_ID_PIPELINE_VAR
        sysIdClassPrefixMap[MetaIdPlugin::class.java] = PREFIX_META_ID_PLUGIN
        sysIdClassPrefixMap[MetaIdPrompt::class.java] = PREFIX_META_ID_PROMPT
        sysIdClassPrefixMap[MetaIdReport::class.java] = PREFIX_META_ID_REPORT
        sysIdClassPrefixMap[MetaIdRole::class.java] = PREFIX_META_ID_ROLE
        sysIdClassPrefixMap[MetaIdSection::class.java] = PREFIX_META_ID_SECTION
        sysIdClassPrefixMap[MetaIdSpreadsheet::class.java] = PREFIX_META_ID_SPREADSHEET
        sysIdClassPrefixMap[MetaIdSpreadsheetRef::class.java] = PREFIX_META_ID_SPREADSHEET_REF
        sysIdClassPrefixMap[MetaIdStep::class.java] = PREFIX_META_ID_STEP
        sysIdClassPrefixMap[MetaIdSwimlane::class.java] = PREFIX_META_ID_SWIMLANE
        sysIdClassPrefixMap[MetaIdTab::class.java] = PREFIX_META_ID_TAB
        sysIdClassPrefixMap[MetaIdTableStyle::class.java] = PREFIX_META_ID_TABLE_STYLE
        sysIdClassPrefixMap[MetaIdTranslation::class.java] = PREFIX_META_ID_TRANSLATION
        sysIdClassPrefixMap[MetaIdUserCondition::class.java] = PREFIX_META_ID_USER_CONDITION
        sysIdClassPrefixMap[MetaIdVar::class.java] = PREFIX_META_ID_VAR
        sysIdClassPrefixMap[MetaIdVdAutoDia::class.java] = PREFIX_META_ID_VD_AUTO_DIA
        sysIdClassPrefixMap[MetaIdVdAutoEdge::class.java] = PREFIX_META_ID_VD_AUTO_EDGE
        sysIdClassPrefixMap[MetaIdVdAutoFunc::class.java] = PREFIX_META_ID_VD_AUTO_FUNC
        sysIdClassPrefixMap[MetaIdVdAutoNode::class.java] = PREFIX_META_ID_VD_AUTO_NODE
        sysIdClassPrefixMap[MetaIdVdComment::class.java] = PREFIX_META_ID_VD_COMMENT
        sysIdClassPrefixMap[MetaIdVdErdDia::class.java] = PREFIX_META_ID_VD_ERD_DIA
        sysIdClassPrefixMap[MetaIdVdImageFunc::class.java] = PREFIX_META_ID_VD_IMAGE_FUNC
        sysIdClassPrefixMap[MetaIdVdNote::class.java] = PREFIX_META_ID_VD_NOTE
        sysIdClassPrefixMap[MetaIdVdRegion::class.java] = PREFIX_META_ID_VD_REGION
        sysIdClassPrefixMap[MetaIdVdReportDia::class.java] = PREFIX_META_ID_VD_REPORT_DIA
        sysIdClassPrefixMap[MetaIdVdReview::class.java] = PREFIX_META_ID_VD_REVIEW
        sysIdClassPrefixMap[MetaIdVideoTimestamp::class.java] = PREFIX_META_ID_VIDEO_TIMESTAMP
        sysIdClassPrefixMap[MetaIdVisibilityAction::class.java] = PREFIX_META_ID_VISIBILITY_ACTION
        sysIdClassPrefixMap[MetaIdVisibilityCondition::class.java] =
            PREFIX_META_ID_VISIBILITY_CONDITION
        sysIdClassPrefixMap[MetaIdVisibilityRule::class.java] = PREFIX_META_ID_VISIBILITY_RULE
        sysIdClassPrefixMap[MetaIdWizard::class.java] = PREFIX_META_ID_WIZARD
        sysIdClassPrefixMap[PluginApiId::class.java] = PREFIX_PLUGIN_API_ID
        sysIdClassPrefixMap[PluginBundleId::class.java] = PREFIX_PLUGIN_BUNDLE_ID
        sysIdClassPrefixMap[PluginId::class.java] = PREFIX_PLUGIN_ID
        sysIdClassPrefixMap[PluginResourceId::class.java] = PREFIX_PLUGIN_RESOURCE_ID
        sysIdClassPrefixMap[ReportExecutionId::class.java] = PREFIX_REPORT_EXECUTION_ID
        sysIdClassPrefixMap[RequestId::class.java] = PREFIX_REQUEST_ID
        sysIdClassPrefixMap[RowId::class.java] = PREFIX_ROW_ID
        sysIdClassPrefixMap[SchedulerTaskId::class.java] = PREFIX_SCHEDULER_TASK_ID
        sysIdClassPrefixMap[SheetId::class.java] = PREFIX_SHEET_ID
        sysIdClassPrefixMap[SnapshotId::class.java] = PREFIX_SNAPSHOT_ID
        sysIdClassPrefixMap[SpreadsheetPartitionId::class.java] = PREFIX_SPREADSHEET_PARTITION_ID
        sysIdClassPrefixMap[StoreItemId::class.java] = PREFIX_STORE_ITEM_ID
        sysIdClassPrefixMap[TabId::class.java] = PREFIX_TAB_ID
        sysIdClassPrefixMap[TransactionId::class.java] = PREFIX_TRANSACTION_ID
        sysIdClassPrefixMap[UserId::class.java] = PREFIX_USER_ID
        sysIdClassPrefixMap[WorkflowExecutionId::class.java] = PREFIX_WORKFLOW_EXECUTION_ID
        sysIdClassPrefixMap[WorkflowGroupExecutionId::class.java] =
            PREFIX_WORKFLOW_GROUP_EXECUTION_ID
    }

    fun getSysIdClass(prefix: String): Class<out SysId>? {
        return prefixSysIdClassMap[prefix]
    }

    fun getSysIdPrefix(sysIdClass: Class<out SysId>): String? {
        return sysIdClassPrefixMap[sysIdClass]
    }
}
