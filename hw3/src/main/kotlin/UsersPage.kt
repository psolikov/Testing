package ru.spb.hse.tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class UsersPage(driver: WebDriver) : PageObject(driver) {

    @FindBy(id = "firstname")
    private val firstName: WebElement? = null

    fun createUser(login: String, name: String) {

    }
}