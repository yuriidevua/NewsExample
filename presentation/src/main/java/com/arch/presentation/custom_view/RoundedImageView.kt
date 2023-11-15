package com.arch.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.arch.presentation.R

class RoundedImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatImageView(context, attrs, defStyle) {
    private val topLeft: Float
    private val topRight: Float
    private val bottomRight: Float
    private val bottomLeft: Float
    private var path: Path? = null

    init {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.RoundedImageView, 0, defStyle
        )
        topLeft = a.getDimension(R.styleable.RoundedImageView_topLeft, 0f)
        topRight = a.getDimension(R.styleable.RoundedImageView_topRight, 0f)
        bottomLeft = a.getDimension(R.styleable.RoundedImageView_bottomLeft, 0f)
        bottomRight = a.getDimension(R.styleable.RoundedImageView_bottomRight, 0f)
        a.recycle()
        init()
    }

    private fun init() {
        path = Path()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path = getPath(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.clipPath(path!!)
        super.onDraw(canvas)
    }

    private fun getPath(w: Int, h: Int): Path {
        val path = Path()
        val radii = FloatArray(8)
        radii[0] = topLeft
        radii[1] = topLeft
        radii[2] = topRight
        radii[3] = topRight
        radii[4] = bottomRight
        radii[5] = bottomRight
        radii[6] = bottomLeft
        radii[7] = bottomLeft
        path.addRoundRect(
            RectF(0f, 0f, w.toFloat(), h.toFloat()),
            radii, Path.Direction.CW
        )
        return path
    }
}