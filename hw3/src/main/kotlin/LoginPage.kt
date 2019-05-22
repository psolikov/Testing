package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class LoginPage(driver: WebDriver) : PageObject(driver) {

    private lateinit var login: WebElement

    private lateinit var loginField: WebElement

    private lateinit var passwordField: WebElement


    fun getFields() {
        waitElements("id_l.L.loginButton")
        waitElements("id_l.L.login")
        waitElements("id_l.L.password")
        login = driver.findElement(By.id("id_l.L.loginButton"))
        loginField = driver.findElement(By.id("id_l.L.login"))
        passwordField = driver.findElement(By.id("id_l.L.password"))
    }

    fun fillFields(login: String, pass: String) {
        loginField.clear()
        loginField.sendKeys(login)
        passwordField.clear()
        passwordField.sendKeys(pass)
    }

    fun pressLogin() {
        login!!.click()
    }

    fun testFields() {

        getFields()
        print(loginField)
        print(passwordField)
        loginField.clear()
        loginField.sendKeys("123")
        Thread.sleep(10000)
    }
}