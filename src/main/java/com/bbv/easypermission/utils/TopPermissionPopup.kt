package com.bbv.easypermission.utils

import android.content.Context
import android.widget.TextView
import com.bbv.easypermission.R
import com.lxj.xpopup.animator.PopupAnimator
import com.lxj.xpopup.animator.TranslateAnimator
import com.lxj.xpopup.core.PositionPopupView
import com.lxj.xpopup.enums.PopupAnimation

/**
 * @Description:
 * @Author: yang liv
 * @Date: 2026/1/27 10:20
 */
class TopPermissionPopup(context: Context, private val msg: String) : PositionPopupView(context) {

    // 1. 引入你的自定义 XML 布局
    override fun getImplLayoutId(): Int = R.layout.layout_custom_top_banner

    override fun onCreate() {
        super.onCreate()
        // 2. 初始化 View 逻辑
        findViewById<TextView>(R.id.tv_description).text = msg
    }

    // 3. 设置动画：顶部弹窗通常用 Translate (位移) 动画
    override fun getPopupAnimator(): PopupAnimator {
        return TranslateAnimator(popupContentView, animationDuration, PopupAnimation.TranslateFromTop)
    }

    // 4. 设置拖拽消失的方向（向上滑动消失）
//    override fun getDragOrientation(): DragOrientation {
//        return DragOrientation.DragToUp
//    }
}