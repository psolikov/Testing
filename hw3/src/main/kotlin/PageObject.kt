package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class PageObject(protected var driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    protected fun waitElements(id: String) {
        val timeOutInSeconds = 5.toLong()
        val webDriverWait = WebDriverWait(driver, timeOutInSeconds)
        webDriverWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id(id))
        )
    }
}