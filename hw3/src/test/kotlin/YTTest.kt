package ru.spb.hse.tests

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class YTTest {

    private lateinit var driver: WebDriver

    @Before
    fun setUp() {
        driver = FirefoxDriver()
        driver.get("http://pavels-macbook-pro.local:8080/")
        val loginPage = LoginPage(driver)
        loginPage.getFields()
        loginPage.fillFields("root", "321")
        loginPage.pressLogin()
    }

    private fun openPage(s: String) {
        driver.get(s)
    }

    private fun loginAsRoot() {
        punchLine()
        setUp()
    }

    private fun waitElements(by: By) {
        val timeOutInSeconds = 5.toLong()
        val webDriverWait = WebDriverWait(driver, timeOutInSeconds)
        webDriverWait.until(
            ExpectedConditions.visibilityOfElementLocated(by)
        )
    }

    private fun createUserAndCheck(username: String, fails: Boolean = false, expectedAmount: Int = 1) {
        openPage("http://localhost:8080/users")
        openPage("http://localhost:8080/registerUserForm")
        val createUserPage = CreateUserForm(driver)
        createUserPage.fill(username, "0")
        createUserPage.clickCancelButton()
        if (fails) {
            assertTrue(driver.currentUrl!!.contains("registerUserForm"))
            return
        }
        assertTrue(driver.currentUrl!!.contains("dashboard"))
        loginAsRoot()
        openPage("http://localhost:8080/users")
        val usersTable = UsersTable(driver)
        assertEquals(expectedAmount, usersTable.count(username))
    }

    @After
    fun punchLine() {
        driver.quit()
    }

    @Test
    fun testUsers() {
        openPage("http://localhost:8080/users")
        CreateUserButton(driver).performAction()
        val createUserPage = CreateUserPage(driver)
        createUserPage.fill("User", "0")
        Thread.sleep(1000)
        createUserPage.clickCancelButton()
        Thread.sleep(1000)
    }

    @Test
    fun testUsersTable() {
        openPage("http://localhost:8080/users")
        assertTrue(UsersTable(driver).contains("root"))
    }

    @Test
    fun testCreatesUniqueUser() {
        createUserAndCheck("User-${System.currentTimeMillis()}")
    }

    @Test
    fun testCreateEmptyNameUser() {
        createUserAndCheck("", true)
    }

    @Test
    fun testCreateNumbersOnlyNameUser() {
        createUserAndCheck("123125124")
    }

    @Test
    fun testCreateSpecialCharactersOnlyNameUser() {
        createUserAndCheck("&&$&@*___")
    }

    //YouTrack cuts digits
    @Test
    fun testCreateLotOfAsOnlyNameUser() {
        createUserAndCheck(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            expectedAmount = 0
        )
    }

    @Test
    fun testDoesNotCreateRootAgain() {
        openPage("http://localhost:8080/users")
        CreateUserButton(driver).performAction()
        val createUserPage = CreateUserPage(driver)
        createUserPage.fill("root", "0")
        createUserPage.clickCancelButton()
        val usersTable = UsersTable(driver)
        assertEquals(usersTable.count("root"), 1)
    }
}