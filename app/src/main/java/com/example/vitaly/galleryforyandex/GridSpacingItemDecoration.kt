package com.example.vitaly.galleryforyandex

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

// Класс для отступа элементов в RecyclerView, потому что отступы от краев экрана мне не нужны
class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view) // Позиция элемента
        val column = position % spanCount // В какой колонне элемент расположен

        if (column == 1) {
            outRect.left = spacing // Отступ слева только для элементов во второй колонне
        }
        outRect.bottom = spacing // Отступ снизу
    }
}