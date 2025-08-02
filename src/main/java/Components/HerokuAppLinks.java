package Components;

import Utility.BaseTest;
import Utility.XpathStore;
import org.openqa.selenium.WebDriver;

public class HerokuAppLinks extends BaseTest {

    public static final String B_Testing = "A/B Testing";
    public static final String AddRemove_Elements = "Add/Remove Elements";
    public static final String Basic_Auth = "Basic Auth";
    public static final String Broken_Images = "Broken Images";
    public static final String Challenging_DOM = "Challenging DOM";
    public static final String Checkboxes = "Checkboxes";
    public static final String Context_Menu = "Context Menu";
    public static final String Digest_Authentication = "Digest Authentication";
    public static final String Disappearing_Elements = "Disappearing Elements";
    public static final String Drag_and_Drop = "Drag and Drop";
    public static final String Dropdown = "Dropdown";
    public static final String Dynamic_Content = "Dynamic Content";
    public static final String Dynamic_Controls = "Dynamic Controls";
    public static final String Dynamic_Loading = "Dynamic Loading";
    public static final String Entry_Ad = "Entry Ad";
    public static final String Exit_Intent = "Exit Intent";
    public static final String File_Download = "File Download";
    public static final String File_Upload = "File Upload";
    public static final String Floating_Menu = "Floating Menu";
    public static final String Forgot_Password = "Forgot Password";
    public static final String Form_Authentication = "Form Authentication";
    public static final String Frames = "Frames";
    public static final String Geolocation = "Geolocation";
    public static final String Horizontal_Slider = "Horizontal Slider";
    public static final String Hovers = "Hovers";
    public static final String Infinite_Scroll = "Infinite Scroll";
    public static final String Inputs = "Inputs";
    public static final String JQuery_UI_Menus = "JQuery UI Menus";
    public static final String JavaScript_Alerts = "JavaScript Alerts";
    public static final String JavaScript_onload_event_error = "JavaScript onload event error";
    public static final String Key_Presses = "Key Presses";
    public static final String Large_Deep_DOM = "Large & Deep DOM";
    public static final String Multiple_Windows = "Multiple Windows";
    public static final String Nested_Frames = "Nested Frames";
    public static final String Notification_Messages = "Notification Messages";
    public static final String Redirect_Link = "Redirect Link";
    public static final String Secure_File_Download = "Secure File Download";
    public static final String Shadow_DOM = "Shadow DOM";
    public static final String Shifting_Content = "Shifting Content";
    public static final String Slow_Resources = "Slow Resources";
    public static final String Sortable_Data_Tables = "Sortable Data Tables";
    public static final String Status_Codes = "Status Codes";
    public static final String Typos = "Typos";
    public static final String WYSIWYG_Editor = "WYSIWYG Editor";

    public void clickOnElementFromList(WebDriver driver, String searchText) {
        this.clickOnElementFromList(driver, XpathStore.allLinksElementList_locator, searchText);
    }
}