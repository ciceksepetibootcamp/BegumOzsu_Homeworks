from selenium.webdriver.common.by import By


class HomePage:

    def __init__(self, driver):
        self.driver = driver

        self.easyoption_xpath = '//*[@id="challenges"]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/label/input'
        self.resetoption_xpath = '//*[@id="challenges"]/div[2]/div/div/div[2]/div[1]/span'

    def click_easy(self):
        self.driver.find_element(By.XPATH, self.easyoption_xpath).click()

    def clear_option(self):
        self.driver.find_element(By.XPATH, self.resetoption_xpath).click()

