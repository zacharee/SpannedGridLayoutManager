package com.arasthel.spannedgridlayoutmanager.sample

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager

/**
 * Created by Jorge Martín on 24/5/17.
 */
class MainActivity: androidx.appcompat.app.AppCompatActivity() {
    private val recyclerview: RecyclerView? by lazy { findViewById(R.id.recyclerView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val spannedGridLayoutManager = SpannedGridLayoutManager(orientation = RecyclerView.VERTICAL, _rowCount = 4, _columnCount = 4, context = this)
        spannedGridLayoutManager.itemOrderIsStable = true

        recyclerview?.layoutManager = spannedGridLayoutManager
        recyclerview?.addItemDecoration(SpaceItemDecorator(left = 10, top = 10, right = 10, bottom = 10))

        val adapter = GridItemAdapter()

        if (savedInstanceState != null && savedInstanceState.containsKey("clicked")) {
            val clicked = savedInstanceState.getBooleanArray("clicked")!!
            adapter.clickedItems.clear()
            adapter.clickedItems.addAll(clicked.toList())
        }

        spannedGridLayoutManager.spanSizeLookup = SpannedGridLayoutManager.SpanSizeLookup { position ->
            if (adapter.clickedItems[position]) {
                SpanSize(2, 2)
            } else {
                SpanSize(1, 1)
            }
        }

        recyclerview?.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBooleanArray("clicked", (recyclerview?.adapter as GridItemAdapter).clickedItems.toBooleanArray())
    }
}