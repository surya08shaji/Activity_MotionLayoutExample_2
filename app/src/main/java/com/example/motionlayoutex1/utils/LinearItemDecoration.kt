package com.example.motionlayoutex1.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class LinearItemDecoration(
    private val verticalSpace: Int = 0,
    private val startEndSpace: Int = 0,
    private val betweenSpace: Int = 0,
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val layoutManager = (parent.layoutManager as? LinearLayoutManager)
            ?: throw IllegalStateException(
                "Use LinearItemSpacingDecoration only with LinearLayoutManager"
            )

        val childPosition = parent.getChildLayoutPosition(view)
        val orientation = layoutManager.orientation

        if (orientation == LinearLayoutManager.HORIZONTAL) {
            when (childPosition) {
                0 -> {
                    outRect.left = startEndSpace
                    outRect.right = betweenSpace
                }
                (layoutManager.itemCount - 1) -> {
                    outRect.right = startEndSpace
                }
                else -> {
                    outRect.right = betweenSpace
                }
            }
            outRect.top = verticalSpace
            outRect.bottom = verticalSpace
        }
    }
}