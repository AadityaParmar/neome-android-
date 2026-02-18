package com.neome.feature.form.presentation.components.field

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Maps MUI (Material-UI React) icon names to Compose Material Icons [ImageVector].
 *
 * MUI uses the same Google Material Icons set, but with camelCase naming.
 * This mapper handles common icon names used in button definitions.
 *
 * Examples:
 * - "add" -> Icons.Filled.Add
 * - "delete" -> Icons.Filled.Delete
 * - "arrowBack" -> Icons.AutoMirrored.Filled.ArrowBack
 *
 * Returns `null` for unmapped icon names. Callers should handle null gracefully
 * (e.g., omit the icon from the button).
 *
 * @param iconName MUI icon name (camelCase, e.g., "add", "delete", "arrowBack")
 * @return Corresponding Compose [ImageVector], or null if not mapped
 */
fun muiIconToImageVector(iconName: String?): ImageVector? {
    if (iconName == null) return null

    return when (iconName.lowercase().trim()) {
        // Navigation
        "arrowback", "arrow_back" -> Icons.AutoMirrored.Filled.ArrowBack
        "arrowforward", "arrow_forward" -> Icons.AutoMirrored.Filled.ArrowForward
        "arrowupward", "arrow_upward" -> Icons.Filled.ArrowUpward
        "arrowdownward", "arrow_downward" -> Icons.Filled.ArrowDownward
        "arrowdropdown", "arrow_drop_down" -> Icons.Filled.ArrowDropDown
        "arrowdropup", "arrow_drop_up" -> Icons.Filled.ArrowDropUp
        "home" -> Icons.Filled.Home
        "menu" -> Icons.Filled.Menu
        "morevert", "more_vert" -> Icons.Filled.MoreVert

        // Actions
        "add" -> Icons.Filled.Add
        "addcircle", "add_circle" -> Icons.Filled.AddCircle
        "remove" -> Icons.Filled.Remove
        "removecircle", "remove_circle" -> Icons.Filled.RemoveCircle
        "edit", "pencil" -> Icons.Filled.Edit
        "create" -> Icons.Filled.Create
        "delete", "deleteoutline", "delete_outline" -> Icons.Filled.Delete
        "clear" -> Icons.Filled.Clear
        "close" -> Icons.Filled.Close
        "check", "checkmark" -> Icons.Filled.Check
        "checkcircle", "check_circle" -> Icons.Filled.CheckCircle
        "done" -> Icons.Filled.Done
        "save" -> Icons.Filled.Save
        "send" -> Icons.AutoMirrored.Filled.Send
        "share" -> Icons.Filled.Share
        "copy", "contentcopy", "content_copy" -> Icons.Filled.ContentCopy
        "print" -> Icons.Filled.Print
        "refresh", "sync" -> Icons.Filled.Refresh
        "syncalt", "sync_alt" -> Icons.Filled.Sync
        "search" -> Icons.Filled.Search
        "filterlist", "filter_list", "filter" -> Icons.Filled.FilterList
        "tune" -> Icons.Filled.Tune
        "openinnew", "open_in_new" -> Icons.AutoMirrored.Filled.OpenInNew
        "upload", "fileupload", "file_upload" -> Icons.Filled.Upload
        "download", "filedownload", "file_download" -> Icons.Filled.Download
        "cloudupload", "cloud_upload" -> Icons.Filled.CloudUpload
        "attachfile", "attach_file" -> Icons.Filled.AttachFile

        // Media
        "playarrow", "play_arrow", "play" -> Icons.Filled.PlayArrow
        "pause" -> Icons.Filled.Pause
        "stop" -> Icons.Filled.Stop
        "mic", "microphone" -> Icons.Filled.Mic
        "camera", "photo" -> Icons.Filled.Camera
        "image", "photo_library" -> Icons.Filled.Image

        // Communication
        "email", "mail" -> Icons.Filled.Email
        "call", "phone" -> Icons.Filled.Call
        "phone" -> Icons.Filled.Phone
        "notifications", "notification" -> Icons.Filled.Notifications

        // UI/Display
        "visibility", "eye" -> Icons.Filled.Visibility
        "visibilityoff", "visibility_off", "eyeoff" -> Icons.Filled.VisibilityOff
        "calendar", "calendartoday", "calendar_today" -> Icons.Filled.CalendarToday
        "accesstime", "access_time", "time", "clock" -> Icons.Filled.AccessTime
        "location", "locationon", "location_on", "place" -> Icons.Filled.LocationOn
        "link" -> Icons.Filled.Link
        "info" -> Icons.Filled.Info
        "warning", "caution" -> Icons.Filled.Warning
        "error" -> Icons.Filled.Error
        "star", "favorite_border" -> Icons.Filled.Star
        "favorite", "heart" -> Icons.Filled.Favorite
        "shoppingcart", "shopping_cart", "cart" -> Icons.Filled.ShoppingCart

        // Account/Security
        "person", "account_circle", "user" -> Icons.Filled.Person
        "settings", "gear" -> Icons.Filled.Settings
        "lock", "lockoutline", "lock_outline" -> Icons.Filled.Lock
        "login", "signin" -> Icons.AutoMirrored.Filled.Login
        "logout", "signout" -> Icons.AutoMirrored.Filled.Logout

        else -> null
    }
}
