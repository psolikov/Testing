package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class CreateUserForm(driver: WebDriver) : PageObject(driver) {

    private lateinit var fullNameField: WebElement
    private lateinit var emailField: WebElement
    private lateinit var loginField: WebElement
    private lateinit var passwordField: WebElement
    private lateinit var cpasswordField: WebElement
    private lateinit var registerButton: WebElement

    private fun getFields() {
        waitElements("id_l.R.user_fullName")
        waitElements("id_l.R.user_email")
        waitElements("id_l.R.user_login")
        waitElements("id_l.R.password")
        waitElements("id_l.R.confirmPassword")
        waitElements("id_l.R.register")
        fullNameField = driver.findElement(By.id("id_l.R.user_fullName"))
        emailField = driver.findElement(By.id("id_l.R.user_email"))
        loginField = driver.findElement(By.id("id_l.R.user_login"))
        passwordField = driver.findElement(By.id("id_l.R.password"))
        cpasswordField = driver.findElement(By.id("id_l.R.confirmPassword"))
        registerButton = driver.findElement(By.id("id_l.R.register"))
    }

    init {
        getFields()
    }

    fun fill(login: String, pass: String) {
        fullNameField.clear()
        fullNameField.sendKeys("123")
        emailField.clear()
        emailField.sendKeys("123")
        loginField.clear()
        loginField.sendKeys(login)
        passwordField.clear()
        passwordField.sendKeys(pass)
        cpasswordField.clear()
        cpasswordField.sendKeys(pass)
    }

    fun clickCancelButton() {
        registerButton.click()
    }
}