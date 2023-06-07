package org.d3if3041.universerthings

import android.os.SystemClock
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.d3if3041.universerthings.model.HasilUniverse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    companion object {
        private val inputan = HasilUniverse ("Saturnus", 0,0)
        private val inputan2 = HasilUniverse("Bima Sakti",0,0)
    }


    @Before
    fun setUp() {
        InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun UserInterfaceTesting() {
        // Jalankan MainActivity
        ActivityScenario.launch(MainActivity::class.java)
        //inputan 1
        Espresso.onView(withId(R.id.inpPlanet)).perform(
            ViewActions.typeText(inputan.namaPlanet.toString()))
        SystemClock.sleep(2000)
        Espresso.onView(withId(R.id.btnCari)).perform(ViewActions.click())
        SystemClock.sleep(2000)
        Espresso.pressBack()
        Espresso.onView(withId(R.id.inpPlanet)).perform(ViewActions.clearText())

        //inputan 2
        Espresso.onView(withId(R.id.inpPlanet)).perform(
            ViewActions.typeText(inputan2.namaPlanet.toString()))
        SystemClock.sleep(2000)
        Espresso.onView(withId(R.id.btnCari)).perform(ViewActions.click())
        SystemClock.sleep(2000)
        Espresso.pressBack()


        Espresso.onView(withId(R.id.menu_histori)).perform(ViewActions.click())
        SystemClock.sleep(2000)
        Espresso.onView(withId(R.id.menu_hapus)).perform(ViewActions.click())
        SystemClock.sleep(2000)
        Espresso.onView(withText(R.string.hapus)).perform(click())
        SystemClock.sleep(2000)
        Espresso.pressBack()





    }
}