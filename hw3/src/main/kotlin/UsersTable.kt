package ru.spb.hse.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class UsersTable(private val driver: WebDriver) : PageElement(driver, By.cssSelector(".table > tbody:nth-child(3)")) {

    companion object {
        val SELECTOR = ".table > tbody:nth-child(3)"
    }

    fun contains(loginName: String): Boolean {
        val rows = element.findElements(By.tagName("tr"))
        val loginNames = rows.map { row -> row.findElement(By.tagName("td")).findElement(By.tagName("a")).text }
        return loginNames.contains(loginName)
    }

    fun count(loginName: String): Int {
        val rows = element.findElements(By.tagName("tr"))
        val loginNames = rows.map { row -> row.findElement(By.tagName("td")).findElement(By.tagName("a")).text }
        return loginNames.count { s -> s == loginName }
    }
}