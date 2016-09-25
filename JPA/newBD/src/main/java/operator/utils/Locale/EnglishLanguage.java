package operator.utils.Locale;

/**
 * A class to hold the static String values for the English language.
 */
public class EnglishLanguage implements Translatable  {

    private final String JSP_PANEL_NAME = "Account control panel";
    private final String JSP_CONTRACTS_NAME = "Contracts";
    private final String JSP_BALANCE_NAME = "Balance";
    private final String JSP_INFO_NAME = "Account details";
    private final String JSP_PROFILE_NAME = "Profile";
    private final String JSP_SUPPORT_NAME = "Support";
    private final String JSP_INVITE_NAME = "Welcome";
    private final String JSP_LOGOUT_NAME = "Logout";
    private final String JSP_CONTRACTS_LIST_NAME = "Contracts list";
    private final String JSP_CONTRACTS_LIST_NUMBER = "Number";
    private final String JSP_CONTRACTS_LIST_TARIFF = "TariffOption";
    private final String JSP_CONTRACTS_LIST_OPTIONS = "Options";
    private final String JSP_CONTRACTS_LIST_STATUS = "Status";
    private final String JSP_CONTRACTS_LIST_ACTIONS = "Actions";
    private final String JSP_CONTRACTS_ACTION_DETAILED = "Details";
    private final String JSP_CONTRACTS_ACTION_CHANGE = "Modify";
    private final String JSP_CONTRACTS_DETAILED_VIEW_CONTRACT = "The details of the contract ";
    private final String JSP_CONTRACTS_DETAILED_VIEW_TARIFF = "Current tariff";
    private final String JSP_CONTRACTS_DETAILED_VIEW_PRICE = "Cost, per month";
    private final String JSP_CONTRACTS_DETAILED_VIEW_OPTIONS = "Current options";
    private final String JSP_CONTRACTS_DETAILED_VIEW_OVERALL_PRICE = "Cost, overall";
    private final String JSP_CONTRACTS_DETAILED_VIEW_IS_BLOCKED = "Account status";
    private final String JSP_CONTRACTS_CHANGE = "Changing the contract with the number ";
    private final String JSP_CONTRACTS_CHOOSE_TARIFF = "Kindly choose a tariff";
    private final String JSP_CONTRACTS_TARIFF_HELPER = "After selecting a tariff you may choose the options.";
    private final String JSP_CONTRACTS_PRICE = "Price";
    private final String JSP_CONTRACTS_SUBMIT = "Submit";
    private final String JSP_CONTRACTS_BLOCK = "Block";
    private final String JSP_CONTRACTS_BLOCKED = "The contract is BLOCKED. No changes can be made";
    private final String JSP_CONTRACTS_UNBLOCK = "Unblock";
    private final String JSP_CONTRACTS_UNBLOCKED = "The contract is not blocked";
    private final String JSP_CONTRACTS_BLOCKED_BY_ADMIN = "BLOCKED BY ADMIN. You can not unblock the contract yourself. Please contact your manager.";
    private final String JSP_CONTRACTS_ERROR = "Errors were found while selecting the options!";
    private final String JSP_CONTRACTS_CHANGING = "Changing the contract";
    private final String JSP_CONTRACTS_CHANGING_NUMBER = "Contracts number:";
    private final String JSP_CONTRACTS_CHOOSE_OPTIONS = "Kindly choose the options for the tariff";
    private final String JSP_CONTRACTS_DETAILED_OPTIONS = "Click an option to view its necessary and incompatible options.";
    private final String JSP_CONTRACTS_OPTION = "Option";
    private final String JSP_CONTRACTS_OPTION_PRICE = "Price";
    private final String JSP_CONTRACTS_OPTION_INITIAL_PRICE = "Initial price";
    private final String JSP_CONTRACTS_OPTIONS_TOGETHER = "Necessary options";
    private final String JSP_CONTRACTS_OPTIONS_INCOMPATIBLE = "Incompatible options";
    private final String JSP_CONTRACTS_SUBMIT_CONTRACT = "Modify a contract";
    private final String JSP_CONTRACTS_BACK_TO_TARIFF = "Back to tariffs' selection";
    private final String JSP_CONTRACTS_SUBMIT_BUCKET = "Please submit the changing of the contract";
    private final String JSP_CONTRACTS_SUBMIT_BUCKET_TARIFF_OPTIONS = "The selected tariff and options are:";
    private final String JSP_SUCCESS = "Success!";
    private final String JSP_BALANCE_PAY = "Make a payment";
    private final String JSP_BALANCE_INCREASE_BALANCE = "Increase the balance by 100 dollars";
    private final String JSP_BALANCE_CURRENT = "Current balance";
    private final String JSP_BALANCE_CURRENCY = "$";
    private final String JSP_BALANCE_DECREASED = "The account's balance will be decreased by ";
    private final String JSP_BALANCE_MONTHLY_CURRENCY = "$/month.";
    private final String JSP_INFO_PROFILE = "Profile of the account ";
    private final String JSP_INFO_BIRTHDAY = "Birthday";
    private final String JSP_INFO_PASSPORT = "Passport";
    private final String JSP_INFO_CONTACT_INFO = "Contact info";
    private final String JSP_INFO_EMAIL = "E-mail";
    private final String JSP_INFO_POST = "Post address";
    private final String JSP_PLEASE_WAIT = "Kindly wait for a moment ";
    private final String JSP_BLOCKED_BY_ADMIN = "BLOCKED BY ADMIN";
    private final String JSP_BLOCKED_BY_ADMIN_SMALL = "Blocked by admin";
    private final String JSP_BLOCKED = "Blocked";
    private final String JSP_ACTIVE = "Active";
    private final String JSP_POSSIBLE_OPTIONS_FOR_TARIFF = "Possible options to choose ";
    private final String JSP_NO_OPTIONS_FOR_TARIFF = "This tariff does not have any options to add.";
    private final String JSP_NO_OPTIONS_TOGETHER = "Current option does not have any necessary options to add.";
    private final String JSP_NO_OPTIONS_INCOMPATIBLE = "Current option does not have any incompatible options.";




    private static EnglishLanguage englishLanguage;
    private EnglishLanguage() {
    }
    public static EnglishLanguage getEnglishLanguage() {
        if (englishLanguage == null) {
            return englishLanguage = new EnglishLanguage();
        }
        else {
            return englishLanguage;
        }
    }
    @Override
    public String getJSP_PANEL_NAME() {
        return JSP_PANEL_NAME;
    }
    @Override
    public String getJSP_CONTRACTS_NAME() {
        return JSP_CONTRACTS_NAME;
    }
    @Override
    public String getJSP_BALANCE_NAME() {
        return JSP_BALANCE_NAME;
    }
    @Override
    public String getJSP_INFO_NAME() {
        return JSP_INFO_NAME;
    }
    @Override
    public String getJSP_PROFILE_NAME() {
        return JSP_PROFILE_NAME;
    }
    @Override
    public String getJSP_SUPPORT_NAME() {
        return JSP_SUPPORT_NAME;
    }
    @Override
    public String getJSP_INVITE_NAME() {
        return JSP_INVITE_NAME;
    }
    @Override
    public String getJSP_LOGOUT_NAME() {
        return JSP_LOGOUT_NAME;
    }
    @Override
    public String getJSP_CONTRACTS_LIST_NAME() {
        return JSP_CONTRACTS_LIST_NAME;
    }
    @Override
    public String getJSP_CONTRACTS_LIST_NUMBER() {
        return JSP_CONTRACTS_LIST_NUMBER;
    }
    @Override
    public String getJSP_CONTRACTS_LIST_TARIFF() {
        return JSP_CONTRACTS_LIST_TARIFF;
    }
    @Override
    public String getJSP_CONTRACTS_LIST_OPTIONS() {
        return JSP_CONTRACTS_LIST_OPTIONS;
    }
    @Override
    public String getJSP_CONTRACTS_LIST_STATUS() {
        return JSP_CONTRACTS_LIST_STATUS;
    }
    @Override
    public String getJSP_CONTRACTS_LIST_ACTIONS() {
        return JSP_CONTRACTS_LIST_ACTIONS;
    }
    @Override
    public String getJSP_CONTRACTS_ACTION_DETAILED() {
        return JSP_CONTRACTS_ACTION_DETAILED;
    }
    @Override
    public String getJSP_CONTRACTS_ACTION_CHANGE() {
        return JSP_CONTRACTS_ACTION_CHANGE;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_VIEW_CONTRACT() {
        return JSP_CONTRACTS_DETAILED_VIEW_CONTRACT;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_VIEW_TARIFF() {
        return JSP_CONTRACTS_DETAILED_VIEW_TARIFF;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_VIEW_PRICE() {
        return JSP_CONTRACTS_DETAILED_VIEW_PRICE;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_VIEW_OPTIONS() {
        return JSP_CONTRACTS_DETAILED_VIEW_OPTIONS;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_VIEW_OVERALL_PRICE() {
        return JSP_CONTRACTS_DETAILED_VIEW_OVERALL_PRICE;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_VIEW_IS_BLOCKED() {
        return JSP_CONTRACTS_DETAILED_VIEW_IS_BLOCKED;
    }
    @Override
    public String getJSP_CONTRACTS_CHANGE() {
        return JSP_CONTRACTS_CHANGE;
    }
    @Override
    public String getJSP_CONTRACTS_CHOOSE_TARIFF() {
        return JSP_CONTRACTS_CHOOSE_TARIFF;
    }
    @Override
    public String getJSP_CONTRACTS_TARIFF_HELPER() {
        return JSP_CONTRACTS_TARIFF_HELPER;
    }
    @Override
    public String getJSP_CONTRACTS_PRICE() {
        return JSP_CONTRACTS_PRICE;
    }
    @Override
    public String getJSP_CONTRACTS_SUBMIT() {
        return JSP_CONTRACTS_SUBMIT;
    }
    @Override
    public String getJSP_CONTRACTS_BLOCK() {
        return JSP_CONTRACTS_BLOCK;
    }
    @Override
    public String getJSP_CONTRACTS_BLOCKED() {
        return JSP_CONTRACTS_BLOCKED;
    }
    @Override
    public String getJSP_CONTRACTS_UNBLOCK() {
        return JSP_CONTRACTS_UNBLOCK;
    }
    @Override
    public String getJSP_CONTRACTS_UNBLOCKED() {
        return JSP_CONTRACTS_UNBLOCKED;
    }
    @Override
    public String getJSP_CONTRACTS_BLOCKED_BY_ADMIN() {
        return JSP_CONTRACTS_BLOCKED_BY_ADMIN;
    }
    @Override
    public String getJSP_CONTRACTS_ERROR() {
        return JSP_CONTRACTS_ERROR;
    }
    @Override
    public String getJSP_CONTRACTS_CHANGING() {
        return JSP_CONTRACTS_CHANGING;
    }
    @Override
    public String getJSP_CONTRACTS_CHANGING_NUMBER() {
        return JSP_CONTRACTS_CHANGING_NUMBER;
    }
    @Override
    public String getJSP_CONTRACTS_CHOOSE_OPTIONS() {
        return JSP_CONTRACTS_CHOOSE_OPTIONS;
    }
    @Override
    public String getJSP_CONTRACTS_DETAILED_OPTIONS() {
        return JSP_CONTRACTS_DETAILED_OPTIONS;
    }
    @Override
    public String getJSP_CONTRACTS_OPTION() {
        return JSP_CONTRACTS_OPTION;
    }
    @Override
    public String getJSP_CONTRACTS_OPTION_PRICE() {
        return JSP_CONTRACTS_OPTION_PRICE;
    }
    @Override
    public String getJSP_CONTRACTS_OPTION_INITIAL_PRICE() {
        return JSP_CONTRACTS_OPTION_INITIAL_PRICE;
    }
    @Override
    public String getJSP_CONTRACTS_OPTIONS_TOGETHER() {
        return JSP_CONTRACTS_OPTIONS_TOGETHER;
    }
    @Override
    public String getJSP_CONTRACTS_OPTIONS_INCOMPATIBLE() {
        return JSP_CONTRACTS_OPTIONS_INCOMPATIBLE;
    }
    @Override
    public String getJSP_CONTRACTS_SUBMIT_CONTRACT() {
        return JSP_CONTRACTS_SUBMIT_CONTRACT;
    }
    @Override
    public String getJSP_CONTRACTS_BACK_TO_TARIFF() {
        return JSP_CONTRACTS_BACK_TO_TARIFF;
    }
    @Override
    public String getJSP_CONTRACTS_SUBMIT_BUCKET() {
        return JSP_CONTRACTS_SUBMIT_BUCKET;
    }
    @Override
    public String getJSP_CONTRACTS_SUBMIT_BUCKET_TARIFF_OPTIONS() {
        return JSP_CONTRACTS_SUBMIT_BUCKET_TARIFF_OPTIONS;
    }
    @Override
    public String getJSP_SUCCESS() {
        return JSP_SUCCESS;
    }
    @Override
    public String getJSP_BALANCE_PAY() {
        return JSP_BALANCE_PAY;
    }
    @Override
    public String getJSP_BALANCE_INCREASE_BALANCE() {
        return JSP_BALANCE_INCREASE_BALANCE;
    }
    @Override
    public String getJSP_BALANCE_CURRENT() {
        return JSP_BALANCE_CURRENT;
    }
    @Override
    public String getJSP_BALANCE_CURRENCY() {
        return JSP_BALANCE_CURRENCY;
    }
    @Override
    public String getJSP_BALANCE_DECREASED() {
        return JSP_BALANCE_DECREASED;
    }
    @Override
    public String getJSP_BALANCE_MONTHLY_CURRENCY() {
        return JSP_BALANCE_MONTHLY_CURRENCY;
    }
    @Override
    public String getJSP_INFO_PROFILE() {
        return JSP_INFO_PROFILE;
    }
    @Override
    public String getJSP_INFO_BIRTHDAY() {
        return JSP_INFO_BIRTHDAY;
    }
    @Override
    public String getJSP_INFO_PASSPORT() {
        return JSP_INFO_PASSPORT;
    }
    @Override
    public String getJSP_INFO_CONTACT_INFO() {
        return JSP_INFO_CONTACT_INFO;
    }
    @Override
    public String getJSP_INFO_EMAIL() {
        return JSP_INFO_EMAIL;
    }
    @Override
    public String getJSP_INFO_POST() {
        return JSP_INFO_POST;
    }
    @Override
    public String getJSP_PLEASE_WAIT() {
        return JSP_PLEASE_WAIT;
    }
    @Override
    public String getJSP_BLOCKED_BY_ADMIN() {
        return JSP_BLOCKED_BY_ADMIN;
    }
    @Override
    public String getJSP_BLOCKED_BY_ADMIN_SMALL() {
        return JSP_BLOCKED_BY_ADMIN_SMALL;
    }
    @Override
    public String getJSP_BLOCKED() {
        return JSP_BLOCKED;
    }
    @Override
    public String getJSP_ACTIVE() {
        return JSP_ACTIVE;
    }
    @Override
    public String getJSP_POSSIBLE_OPTIONS_FOR_TARIFF() {
        return JSP_POSSIBLE_OPTIONS_FOR_TARIFF;
    }
    @Override
    public String getJSP_NO_OPTIONS_FOR_TARIFF() {
        return JSP_NO_OPTIONS_FOR_TARIFF;
    }
    @Override
    public String getJSP_NO_OPTIONS_TOGETHER() {
        return JSP_NO_OPTIONS_TOGETHER;
    }
    @Override
    public String getJSP_NO_OPTIONS_INCOMPATIBLE() {
        return JSP_NO_OPTIONS_INCOMPATIBLE;
    }
}
