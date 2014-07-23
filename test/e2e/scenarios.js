'use strict';

/* http://docs.angularjs.org/guide/dev_guide.e2e-testing */

describe('common-app-javaee7', function() {

  it('should redirect index.html to index.html#/login', function() {
    browser().navigateTo('web/index.html');
    expect(browser().location().url()).toBe('/login');
  });


});
