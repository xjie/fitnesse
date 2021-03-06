// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse.updates;

import fitnesse.wiki.PageData;
import fitnesse.wiki.PathParser;
import fitnesse.wiki.WikiPage;
import fitnesse.wiki.WikiPageProperties;

public class VirtualWikiDepricationUpdateTest extends UpdateTestCase {
  protected Update makeUpdate() {
    return new VirtualWikiDeprecationUpdate(updater);
  }

  public void testDoVisiting() throws Exception {
    WikiPage page = crawler.addPage(root, PathParser.parse("SomePage"), "!virtualwiki http://some.url");
    PageTraversingUpdate update2 = (PageTraversingUpdate) update;
    update2.processPage(page);

    PageData data = page.getData();
    assertEquals("http://some.url", data.getAttribute(WikiPageProperties.VIRTUAL_WIKI_ATTRIBUTE));
  }
}
