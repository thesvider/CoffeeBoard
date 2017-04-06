import { ZcoffeePage } from './app.po';

describe('zcoffee App', function() {
  let page: ZcoffeePage;

  beforeEach(() => {
    page = new ZcoffeePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
