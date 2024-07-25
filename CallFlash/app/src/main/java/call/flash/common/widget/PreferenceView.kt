package call.flash.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import call.flash.R
import call.flash.databinding.PreferenceViewBinding

class PreferenceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    val binding = PreferenceViewBinding.inflate(LayoutInflater.from(context))
    var viewWidgetFrame: View? = null

    var title: String? = null
        set(value) {
            field = value

            binding.titleView.text = value
        }

    var summary: String? = null
        set(value) {
            field = value

            binding.summaryView.text = value
            binding.summaryView.isVisible = value?.isNotEmpty() == true
        }

    init {
        layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        binding.root.layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        addView(binding.root)

        context.obtainStyledAttributes(attrs, R.styleable.PreferenceView).run {
            title = getString(R.styleable.PreferenceView_title)
            summary = getString(R.styleable.PreferenceView_summary)

            getResourceId(R.styleable.PreferenceView_widget, -1).takeIf { it != -1 }?.let { id ->
                viewWidgetFrame = View.inflate(context, id, binding.widgetFrame)
            }

            getResourceId(R.styleable.PreferenceView_icon, -1).takeIf { it != -1 }?.let { id ->
                binding.icon.isVisible = true
                binding.icon.setImageResource(id)
            }

            recycle()
        }
    }

}