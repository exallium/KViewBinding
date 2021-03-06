# KViewBinding

Simple resource binding using kotlin delegates.  This does not handle listeners.  I recommend RxBinding for such things.

Sample Usage:

```kotlin
class CustomFragment : Fragment() {

    val textView: TextView by bindView(R.id.custom_view_text_view)
    val nullView: TextView by bindView(R.id.text)
    val color by bindColor(R.color.colorAccent)
    val dimen by bindDimen(R.dimen.test_dimen)
    val dimenOffset by bindDimenPixelOffset(R.dimen.test_dimen)
    val dimenSize by bindDimenPixelSize(R.dimen.test_dimen)
    val drawable by bindDrawable(R.drawable.ic_launcher_background)
    val str by bindString(R.string.app_name)
    val formatStr by bindString(R.string.fmt, "asdf")
    val text by bindText(R.string.app_name)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.custom_view, container, false)
    }

}
```

## Features

* Extension functions which will work for App Compat Activities / Fragments, Context, and Views
* Extension functions for custom types with single-method-interfaces to help define these types

## On JCenter

```groovy
repositories { 
    maven { 
        url "https://dl.bintray.com/exallium/maven" 
    }
}

implementation "com.exallium.ktviewbinding:lib:0.1.1"
```

## TODO

* String Arrays and other unsupported resources
* Better optionality through Kotlin's type system
* bindX methods which take Activity / Context / Fragment / View so as to not break encapsulation