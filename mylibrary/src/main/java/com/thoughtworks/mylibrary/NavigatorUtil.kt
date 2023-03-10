package com.thoughtworks.mylibrary

import androidx.fragment.app.Fragment
import com.thoughtworks.mylibrary.ui.innercontainerfragment.InnerContainerFragment

object NavigatorUtil {
    fun getInnerContainerFragment(): Class<out Fragment> {
        return InnerContainerFragment::class.java
    }
}