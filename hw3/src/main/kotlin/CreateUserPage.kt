package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class CreateUserPage(driver: WebDriver) : PageObject(driver) {

    private lateinit var loginField: WebElement
    private lateinit var passwordField: WebElement
    private lateinit var cpasswordField: WebElement
    private lateinit var createUserOK: WebElement
    private lateinit var cancelButton: WebElement

    private fun getFields() {
        waitElements("id_l.U.cr.login")
        waitElements("id_l.U.cr.password")
        waitElements("id_l.U.cr.confirmPassword")
        waitElements("id_l.U.cr.createUserOk")
        waitElements("id_l.U.cr.createUserCancel")
        loginField = driver.findElement(By.id("id_l.U.cr.login"))
        passwordField = driver.findElement(By.id("id_l.U.cr.password"))
        cpasswordField = driver.findElement(By.id("id_l.U.cr.confirmPassword"))
        createUserOK = driver.findElement(By.id("id_l.U.cr.createUserOk"))
        cancelButton = driver.findElement(By.id("id_l.U.cr.createUserCancel"))
    }

    init {
        getFields()
    }

    fun fill(login: String, pass: String) {
        loginField.clear()
        loginField.sendKeys(login)
        passwordField.clear()
        passwordField.sendKeys(pass)
        cpasswordField.clear()
        cpasswordField.sendKeys(pass)
        createUserOK.click()
    }

    fun clickCancelButton() {
        cancelButton.click()
    }
}