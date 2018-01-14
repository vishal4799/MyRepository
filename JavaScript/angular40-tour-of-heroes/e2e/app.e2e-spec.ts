import { Angular40TourOfHeroesPage } from './app.po';

describe('angular40-tour-of-heroes App', () => {
  let page: Angular40TourOfHeroesPage;

  beforeEach(() => {
    page = new Angular40TourOfHeroesPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
