import { AppPage } from './app.po';
import { browser, by, element } from 'protractor';


describe('Passport Application System UI Tests', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('Should Display Application Heading', () => {
    page.navigateTo();
    expect(page.getH2ApplicationHeading()).toEqual('APPLICATION');
  });

  it('Should Display All Navigation Bar Buttons',() =>{
    page.navigateTo();
    expect(page.getAboutButtonFromNavBar()).toEqual('ABOUT');
    expect(page.getApplicationButtonFromNavBar()).toEqual('APPLICATION');
    expect(page.getChatbotButtonFromNavBar()).toEqual('CHATBOT');
  });
  it('Should Display Submit Button',() =>{
    page.navigateTo();
    expect(page.getSubmitButton()).toEqual('SUBMIT');
  });
  it('Should Display Submit Button',() =>{
    page.navigateTo();
    expect(page.getSubmitButton()).toEqual('SUBMIT');
  });
  it('Should Route To About Page',() =>{
    page.navigateTo();
    page.getAboutButtonToBePressed().click();
    //page.getAboutButtonFromNavBar().click();
    expect(page.getH2AboutHeading()).toEqual('ABOUT');
  });
  it('Should Route To Chatbot Page',() =>{
    page.navigateTo();
    page.getChatbotButtonToBePressed().click();
    //page.getAboutButtonFromNavBar().click();
    expect(page.getH2ChatbotHeading()).toEqual('CHATBOT');
  });
  it('Should Check Footer LOCATION Heading',() =>{
    page.navigateTo();
    expect(page.getH4LocationHeadingFromFootber()).toEqual('LOCATION');
  });
  it('Should Check Footer MY DETAILS Heading',() =>{
    page.navigateTo();
    expect(page.getH4MyDetailsHeadingFromFootber()).toEqual('MY DETAILS');
  });
  it('Should Check Footer ABOUT PASSPORT Heading',() =>{
    page.navigateTo();
    expect(page.getH4AboutPassportHeadingFromFootber()).toEqual('ABOUT PASSPORT SYSTEM');
  });
  it('Should Check LinkedIn & Github Images Are Present',() =>{
    page.navigateTo();
    expect(page.getGithutImage().isDisplayed()).toBeTruthy();
    expect(page.getLinkedInImage().isDisplayed()).toBeTruthy();

  });
  it('Should Check If Images Are Displayed',() =>{
      page.navigateTo();
      page.getAboutButtonToBePressed().click();
    var imagesBrokenCount = browser.executeScript(`
      var elms = document.querySelectorAll("img");
      return [].filter.call(elms, e => e.offsetHeight > 1 && e.naturalHeight <= 1).length;
      `);
      //Will return Number true if there is no broken images
    expect(imagesBrokenCount).toEqual(0);
  });
  it('Should Display DOB Error Message',() =>{
    page.navigateTo();
    page.getDateOfBirthInputField().sendKeys('03/10/1996')
    expect(page.getDobIncorrectFormat()).toEqual('Please enter a valid date of birth (DD-MM-YYYY)');
  });
  it('Should Display Email Error Message',() =>{
    page.navigateTo();
    page.getEmailInputField().sendKeys('ThisIsNotAnEmailAddress')
    expect(page.getEmailIncorrectFormat()).toEqual('Please enter valid email');
  });
  it('Should Display Pps Error Message',() =>{
    page.navigateTo();
    page.getPpsNumberInputField().sendKeys('Not8')
    expect(page.getPpsIncorrectFormat()).toEqual('PPS number must be 8 characters');
  });
  it('Should Display Phonee Error Message',() =>{
    page.navigateTo();
    page.getNumberInputField().sendKeys('PhoneNumberMustHaveInts')
    expect(page.getNumberIncorrectFormat()).toEqual('Please enter valid phone number');
  });

});
