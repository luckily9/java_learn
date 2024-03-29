package ru.stqa.pft.rest.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.rest.appmanager.ApplicationManager;
import java.io.IOException;
public class TestBase {
  protected static final ApplicationManager app = new ApplicationManager();
  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }
  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
  public boolean isIssueOpen (int issueId) throws IOException {
    String status = app.json().getIssueStatus(issueId);
    if( status.equals("Resolved") || status.equals("Closed")) {
      return false;
    }
    return true;
  }
}