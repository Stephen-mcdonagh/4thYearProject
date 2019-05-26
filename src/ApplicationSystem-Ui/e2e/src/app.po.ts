import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  getH2ApplicationHeading() {
    return element(by.css('app-home h2')).getText();
  }
  getH2AboutHeading() {
    return element(by.css('about h2')).getText();
  }
  getH2ChatbotHeading() {
    return element(by.css('chatbot h2')).getText();
  }
  getH4LocationHeadingFromFootber() {
    return element(by.id('LocationHeadingFooter')).getText();
  }
  getH4MyDetailsHeadingFromFootber() {
    return element(by.id('MyDetailsHeadingFooter')).getText();
  }
  getH4AboutPassportHeadingFromFootber() {
    return element(by.id('AboutPassportHeadingFooter')).getText();
  }
  getLinkedInImage() {
    return element(by.id('LinkedInLink'));
  }
  getGithutImage() {
    return element(by.id('GithubLink'));
  }
  getAboutButtonFromNavBar(){
    return element(by.id('NavBarAbout')).getText();
  }
  getAboutButtonToBePressed(){
    return element(by.id('NavBarAbout'));
  }
  getApplicationButtonFromNavBar(){
    return element(by.id('NavBarApplicationt')).getText();
  }
  getChatbotButtonFromNavBar(){
    return element(by.id('NavBarChatbot')).getText();
  }
  getChatbotButtonToBePressed(){
    return element(by.id('NavBarChatbot'));
  }
  getSubmitButton(){
    return element(by.id('submit')).getText();
  }
  getDateOfBirthInputField(){
    return element(by.id('Dob'));
  }
  getDobIncorrectFormat(){
    return element(by.id('DobIncorrectFormat')).getText();
  }
  getEmailInputField(){
    return element(by.id('email'));
  }
  getEmailIncorrectFormat(){
    return element(by.id('EmailIncorrectFormat')).getText();
  }
  getPpsNumberInputField(){
    return element(by.id('Pps'));
  }
  getPpsIncorrectFormat(){
    return element(by.id('PpsIncorrectFormat')).getText();
  }
  getNumberInputField(){
    return element(by.id('PhoneNumber'));
  }
  getNumberIncorrectFormat(){
    return element(by.id('NumberIncorrectFormat')).getText();
  }

}
