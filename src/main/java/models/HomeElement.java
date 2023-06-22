package models;

public class HomeElement {

    public String ele_label_guru_bar = "xpath:::.//h2[@class='barone']";
    
    // OPTIONS LIST
    public String ele_link_menu_manager = "xpath:::.//ul[@class='menusubnav']//a[@href='Managerhomepage.php']";
    public String ele_link_menu_new_customer = "xpath:::.//ul[@class='menusubnav']//a[@href='addcustomerpage.php']";
    public String ele_link_menu_edit_customer = "xpath:::.//ul[@class='menusubnav']//a[@href='EditCustomer.php']";
    public String ele_link_menu_delete_customer = "xpath:::.//ul[@class='menusubnav']//a[@href='DeleteCustomerInput.php']";
    public String ele_link_menu_new_account = "xpath:::.//ul[@class='menusubnav']//a[@href='addAccount.php']";
    public String ele_link_menu_edit_account = "xpath:::.//ul[@class='menusubnav']//a[@href='editAccount.php']";
    public String ele_link_menu_delete_account = "xpath:::.//ul[@class='menusubnav']//a[@href='deleteAccountInput.php']";
    public String ele_link_menu_deposit = "xpath:::.//ul[@class='menusubnav']//a[@href='DepositInput.php']";
    public String ele_link_menu_with_drawal = "xpath:::.//ul[@class='menusubnav']//a[@href='WithdrawalInput.php']";
    public String ele_link_menu_fund_transfer = "xpath:::.//ul[@class='menusubnav']//a[@href='FundTransInput.php']";
    public String ele_link_menu_password_input = "xpath:::.//ul[@class='menusubnav']//a[@href='PasswordInput.php']";
    public String ele_link_menu_balance_enquiry = "xpath:::.//ul[@class='menusubnav']//a[@href='BalEnqInput.php']";
    public String ele_link_menu_mini_statement = "xpath:::.//ul[@class='menusubnav']//a[@href='MiniStatementInput.php']";
    public String ele_link_menu_customised_statement = "xpath:::.//ul[@class='menusubnav']//a[@href='CustomisedStatementInput.php']";
    public String ele_link_menu_logout = "xpath:::.//ul[@class='menusubnav']//a[@href='Logout.php']";

    // Content
    public String ele_img_content_1 = "xpath:::.//img[@src='../images/1.gif']";
    public String ele_img_content_2 = "xpath:::.//img[@src='../images/2.gif']";
    public String ele_img_content_3 = "xpath:::.//img[@src='../images/3.gif']";
    public String ele_label_welcome = "xpath:::.//marquee[@class='heading3']";
    public String ele_label_manager_id = "xpath:::.//tr[@class='heading3']/td";
}