package net.mf;

import static org.junit.Assert.*;

import com.hp.lft.report.CaptureLevel;
import com.hp.lft.report.Reporter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;
import com.hp.lft.sdk.web.*;
import net.mf.ApplicationModel.*;

public class LeanFtTest extends UnitTestClassBase {
    Browser browser;
    ApplicationModel aosModel;

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }
    @After
    public void tearDown() throws Exception {
        aosModel.REMOVE().click();
        aosModel.CONTINUE_SHOPPING().click();
        browser.closeAllTabs();
    }
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
        Reporter.setSnapshotCaptureLevel(CaptureLevel.All);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.navigate("http://nimbusserver.aos.com:8000/#/");
        aosModel = new ApplicationModel(browser);
    }

    @Test
    public void buySpeaker() throws GeneralLeanFtException, InterruptedException {
        aosModel.SPEAKERS().click();
        aosModel.SPEAKER().click();
        aosModel.ADD_TO_CART().click();

        browser.describe(WebElement.class, new WebElementDescription.Builder()
                .accessibilityName("")
                .index(6)
                .innerText("")
                .tagName("path").build()).click();

    }

}