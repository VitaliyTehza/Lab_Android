import android.graphics.Color
import android.view.Gravity
import com.l1l2.my.MainActivity
import org.jetbrains.anko.*

class MainView : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER

            textView {
                text = "Hello World!" // change to your text!
                textSize = 18f
                textColor = Color.GRAY
            }.lparams(width = wrapContent, height = wrapContent)
        }
    }
}
