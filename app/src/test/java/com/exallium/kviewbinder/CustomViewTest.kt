package com.exallium.kviewbinder

import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotEqual
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CustomViewTest {
    @Test
    fun allResourcesLoadSuccessfully() {
        val testSubject = CustomView(RuntimeEnvironment.application)

        testSubject.textView shouldNotEqual null
        testSubject.nullView shouldEqual null
        testSubject.color shouldNotEqual null
        testSubject.dimen shouldNotEqual null
        testSubject.dimenOffset shouldNotEqual null
        testSubject.dimenSize shouldNotEqual null
        testSubject.drawable shouldNotEqual null
        testSubject.str shouldNotEqual null
        testSubject.formatStr shouldNotEqual null
        testSubject.text shouldNotEqual null
    }
}