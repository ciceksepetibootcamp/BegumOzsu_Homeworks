import unittest

from selenium import webdriver
from Pages.loginPage import LoginPage
from Pages.homePage import HomePage


class SelectDifficulty(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.driver = webdriver.Chrome(executable_path="/Users/begumozsu/PycharmProjects/CoderByte/drivers/chromedriver")
        cls.driver.implicitly_wait(10)
        cls.driver.maximize_window()

    def test_select_difficulty(self):
        driver = self.driver
        driver.get("https://coderbyte.com/challenges")
        login = LoginPage(self.driver)
        login.success_login("Begozumsu", "TestUser12345")
        home = HomePage(self.driver)
        home.click_easy()

    def test_clear_option(self):
        driver = self.driver
        driver.get("https://coderbyte.com/challenges")
        login = LoginPage(self.driver)
        login.success_login("Begozumsu", "TestUser12345")
        home = HomePage(self.driver)
        home.click_easy()
        driver.implicitly_wait(20)
        home.clear_option()

    @classmethod
    def tearDownClass(cls):
        cls.driver.close()
        cls.driver.quit()

