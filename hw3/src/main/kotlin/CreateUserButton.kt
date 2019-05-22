package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class CreateUserButton(private val driver: WebDriver) : PageElement(driver, By.id("id_l.U.createNewUser")) {

    companion object {
        val ID = "id_l.U.createNewUser"
    }

    override fun performAction() {
        element.click()
    }
}