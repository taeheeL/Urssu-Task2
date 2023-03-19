package com.example.urssu_task2.view.common

import android.content.res.ColorStateList
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.urssu_task2.R
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("helperTextColor")
fun setHelperTextColor(textView: TextView, isValid: String?) {
    textView.setTextColor(
        when (isValid) {
            "empty", "valid" -> {
                ContextCompat.getColor(textView.context, R.color.text_tertiary)
            }
            null -> {
                ContextCompat.getColor(textView.context, R.color.text_tertiary)

            }
            else -> ContextCompat.getColor(textView.context, R.color.error)
        }
    )
}

@BindingAdapter("backgroundTint")
fun setBackgroundTint(button: Button, isValid: String?) {
    val colorStateList = when (isValid) {
        "" -> ColorStateList.valueOf(
            ContextCompat.getColor(
                button.context,
                R.color.button_disabled_color
            )
        )
        "valid" -> ColorStateList.valueOf(
            ContextCompat.getColor(
                button.context,
                R.color.button_enabled_color
            )
        )
        else -> ColorStateList.valueOf(
            ContextCompat.getColor(
                button.context,
                R.color.button_disabled_color
            )
        )
    }
    button.backgroundTintList = colorStateList
}

@BindingAdapter("enabled")
fun setButtonEnabled(button: Button, isValid: String?) {
    when (isValid) {
        "" -> button.isEnabled = false
        "valid" -> button.isEnabled = true
        else -> button.isEnabled = false
    }
}


@BindingAdapter("boxStrokeColor")
fun setBoxStrokeColor(textInputLayout: TextInputLayout, isValid: String?) {
    textInputLayout.boxStrokeColor =
        when (isValid) {
            null -> ContextCompat.getColor(textInputLayout.context, R.color.white)
            "empty" -> {
                ContextCompat.getColor(textInputLayout.context, R.color.white)
            }
            "valid" -> {
                ContextCompat.getColor(textInputLayout.context, R.color.primary)
            }
            else -> ContextCompat.getColor(textInputLayout.context, R.color.error)
        }
}
