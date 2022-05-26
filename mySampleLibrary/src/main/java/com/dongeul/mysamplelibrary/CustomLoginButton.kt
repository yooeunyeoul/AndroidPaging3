package com.dongeul.mysamplelibrary

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class CustomLoginButton @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var tvLibrary: TextView

    init {
        init(context)
        getAttrs(attrs,defStyleAttr)
    }

    fun init(context: Context) {

        val view = LayoutInflater.from(context).inflate(R.layout.item_library, this, false)
        addView(view)

        tvLibrary = findViewById<TextView>(R.id.tvLibrary)


    }

    fun getAttrs(attrs: AttributeSet? , defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoginButton,defStyleAttr,0)
        setTypeArray(typedArray)
    }

    //<attr name="bgColor" format="reference|integer"/>
//    <attr name="text" format="reference|string"/>
//    <attr name="textColor" format="reference|integer"/>
    private fun setTypeArray(typedArray: TypedArray) {
        val text = typedArray.getText(R.styleable.LoginButton_customText)
        tvLibrary.text = text

        val textColor = typedArray.getColor(R.styleable.LoginButton_customTextColor, 0)
        tvLibrary.setTextColor(textColor)

        typedArray.recycle()

    }

}