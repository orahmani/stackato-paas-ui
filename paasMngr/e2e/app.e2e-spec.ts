import { PaasMngrPage } from './app.po';

describe('paas-mngr App', function() {
  let page: PaasMngrPage;

  beforeEach(() => {
    page = new PaasMngrPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
