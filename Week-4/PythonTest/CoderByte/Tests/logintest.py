import unittest

from selenium import webdriver
from selenium.webdriver.common.by import By
from Pages.loginPage import LoginPage
from Pages.homePage import HomePage


class LoginTest(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.driver = webdriver.Chrome(executable_path="/Users/begumozsu/PycharmProjects/CoderByte/drivers/chromedriver")
        cls.driver.implicitly_wait(10)
        cls.driver.maximize_window()

    def test_login_valid(self):

        driver = self.driver
        driver.get("https://coderbyte.com/challenges")

        login = LoginPage(driver)
        login.success_login("Begozumsu", "TestUser12345")
        self.driver.implicitly_wait(10)

    @classmethod
    def tearDownClass(cls):
        cls.driver.close()
        cls.driver.quit()
