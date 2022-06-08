import { browser, by, element } from 'protractor';

export class AppPage {

  navigateTo(path: string = '') {
    return browser.get(`${browser.baseUrl}${path}`) as Promise<any>;
  }

  getLocation(){
    return browser.getCurrentUrl() as Promise<any>;
  }

  getTitleText(elemento: string) {
    return element(by.css(elemento)).getText() as Promise<string>;
  }
}
