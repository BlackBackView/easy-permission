package com.bbv.easypermission.utils

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bbv.easypermission.utils.EasyPermission.isAllGranted
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.XXPermissions
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.core.BasePopupView
import com.lxj.xpopup.util.XPopupUtils
import com.lxj.xpopup.util.XPopupUtils.dp2px

/**
 * @Description:
 * @Author: yang liv
 * @Date: 2025/4/5 21:23
 */
object EasyPermission {

    private var descriptionPopUp: BasePopupView? = null

    /**
     * 检查一组权限是否全部已授予
     */
    fun isAllGranted(context: Context, permissions: Array<String>): Boolean {
        return XXPermissions.isGranted(context, permissions)
    }

    /**
     * 显示顶部权限描述弹窗
     */
    private fun showDescription(context: Context, permissions: List<String>, description: String) {
        if (XXPermissions.isGranted(context, permissions)) {
            return
        }
        // 防止重复弹出
        if (descriptionPopUp?.isShow == true) return

        descriptionPopUp = XPopup.Builder(context)
            .dismissOnTouchOutside(false)
            .dismissOnBackPressed(false)
            .hasShadowBg(false)
            .popupWidth(XPopupUtils.getAppWidth(context))
            .offsetY(dp2px(context, 40F)) // 偏移量，避免遮挡状态栏
            .asCustom(TopPermissionPopup(context, description))
            .show()
    }

    /**
     * 隐藏描述弹窗
     */
    private fun dismissDescription() {
        descriptionPopUp?.dismiss()
        descriptionPopUp = null
    }



    /**
     * 请求权限带顶部权限描述弹框
     * @receiver FragmentActivity
     * @param permissions List<String> 权限列表
     * @param description String 权限描述
     * @param failMsg String 失败提示
     * @param fail Function0<Unit>? 失败回调
     * @param success Function0<Unit> 完成回调
     */
    fun FragmentActivity.requestPermissionsWithDescription(permissions: List<String>, description: String, failMsg: String, fail: (() -> Unit)? = null, success: () -> Unit) {

        showDescription(this, permissions, description)

        XXPermissions.with(this)
            .permission(permissions)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: List<String>, allGranted: Boolean) {
                    dismissDescription()
                    if (!allGranted) {
                        fail?.invoke()
                        this@requestPermissionsWithDescription.toast(failMsg)
                        return
                    }
                    success.invoke()
                }

                override fun onDenied(permissions: List<String>, doNotAskAgain: Boolean) {
                    dismissDescription()
                    if (doNotAskAgain) {
                        this@requestPermissionsWithDescription.toast("被永久拒绝授权，请手动授予权限")
                        // 如果是被永久拒绝就跳转到应用权限系统设置页面
                        XXPermissions.startPermissionActivity(this@requestPermissionsWithDescription, permissions)
                    } else {
                        fail?.invoke()
                        this@requestPermissionsWithDescription.toast(failMsg)
                    }
                }
            })
    }

    /**
     * 请求权限带顶部权限描述弹框
     * @receiver Fragment
     * @param permissions List<String> 权限列表
     * @param description String 权限描述
     * @param failMsg String 失败提示
     * @param fail Function0<Unit>? 失败回调
     * @param success Function0<Unit> 完成回调
     */
    fun Fragment.requestPermissionsWithDescription(permissions: List<String>, description: String, failMsg: String, fail: (() -> Unit)? = null, success: () -> Unit) {
        showDescription(requireActivity(), permissions, description)

        XXPermissions.with(this)
            .permission(permissions)
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: List<String>, allGranted: Boolean) {
                    dismissDescription()
                    if (!allGranted) {
                        fail?.invoke()
                        this@requestPermissionsWithDescription.toast(failMsg)
                        return
                    }
                    success.invoke()
                }

                override fun onDenied(permissions: List<String>, doNotAskAgain: Boolean) {
                    dismissDescription()
                    if (doNotAskAgain) {
                        this@requestPermissionsWithDescription.toast("被永久拒绝授权，请手动授予权限")
                        // 如果是被永久拒绝就跳转到应用权限系统设置页面
                        XXPermissions.startPermissionActivity(this@requestPermissionsWithDescription, permissions)
                    } else {
                        fail?.invoke()
                        this@requestPermissionsWithDescription.toast(failMsg)
                    }
                }
            })
    }
}
