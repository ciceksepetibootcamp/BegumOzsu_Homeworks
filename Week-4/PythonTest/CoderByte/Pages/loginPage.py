
from selenium.webdriver.common.by import By


class LoginPage:

    def __init__(self, driver):
        self.driver = driver

        self.username_textbox_xpath = '//*[@id="login"]/div/div/div/div[1]/div[2]/div[1]/div/input'
        self.password_textbox_xpath = '//*[@id="login"]/div/div/div/div[1]/div[2]/div[2]/div/input'
        self.loginButton_button_class = "login-link"
        self.secondLoginButton_button_xpath = '//*[@id="login"]/div/div/div/div[1]/div[1]/div[1]'
        self.thirdLoginButton_button_xpath = '//*[@id="login"]/div/div/div/div[1]/div[3]/button'


    def success_login(self, username, password):
        self.driver.find_element(By.CLASS_NAME, self.loginButton_button_class).click()
        self.driver.find_element(By.XPATH, self.secondLoginButton_button_xpath).click()
        self.driver.find_element(By.XPATH, self.username_textbox_xpath).send_keys(username)
        self.driver.find_element(By.XPATH, self.password_textbox_xpath).send_keys(password)
        self.driver.find_element(By.XPATH, self.thirdLoginButton_button_xpath).click()
