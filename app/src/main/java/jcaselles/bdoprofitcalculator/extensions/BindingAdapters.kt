package jcaselles.bdoprofitcalculator.extensions

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("showKeyboard")
fun showKeyboard(view: View, editText: EditText) {
    view.setOnClickListener {
        editText.requestFocus()
        val inputMethodManager = editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }
}

@BindingAdapter("onDoneSoftKeyboard")
fun EditText.onDoneClick(funBind: () -> Unit) {
    this.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            funBind()
            true
        } else {
            false
        }
    }
}

@BindingAdapter("onLoseFocus")
fun EditText.onLoseFocus(funBind: () -> Unit) {
    this.setOnFocusChangeListener { _, b ->
        if (b) {
        } else {
            funBind()
        }
    }
}


@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(image: Int) {
    this.setImageResource(image)
}

@BindingAdapter("visibleGone")
fun View.visibleGone(visible: Boolean) {
    this.visibility = when (visible) {
        true -> View.VISIBLE
        false -> View.GONE
    }
}
