package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class PageElement(private val driver: WebDriver, where: By) {

    protected var element: WebElement

    protected fun waitElements(id: String) {
        val timeOutInSeconds = 5.toLong()
        val webDriverWait = WebDriverWait(driver, timeOutInSeconds)
        webDriverWait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id(id))
        )
    }

    open fun performAction() {}

    init {
        val timeOutInSeconds = 5.toLong()
        val webDriverWait = WebDriverWait(driver, timeOutInSeconds)
        webDriverWait.until(
            ExpectedConditions.visibilityOfElementLocated(where)
        )
        element = driver.findElement(where)
    }
}